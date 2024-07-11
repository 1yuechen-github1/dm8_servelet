package org.example.Controller.Teacher.TeacherExamPaperLibrary;

import com.itextpdf.text.pdf.BaseFont;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.Dto.ExamDto;
import org.example.Service.*;
import org.example.common.R;
import org.example.config.DateConfig;
import org.example.config.WordDocumentGenerator;
import org.example.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Slf4j
@RestController
@Controller
@RequestMapping("/teacher")
public class TeacherExamPaperLibraryController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamPaperLibraryService examPaperLibraryService;

    @Autowired
    private StudExamService studExamService;

    @Autowired
    private QuesInfoService quesInfoService;

    @Autowired
    private ExamQuesInfoService examQuesInfoService;

    /**
     * 试卷库管理
     * 1.发布考试
     **/
    @Transactional
    @PostMapping("/postTheExam/{examId}")
    public R postTheExam(@PathVariable int examId,
                         @RequestBody Exam exam1) {
        Exam exam = examService.queryExamByExamId(examId);
        if (exam != null) {
            String formattedTime = DateConfig.getCurrentTimeFormatted();
            exam.setCreateTime(formattedTime);
//            exam.setExamName(exam1.getExamName());
            exam.setDuration(exam1.getDuration());
            exam.setClassName(exam1.getClassName());
            exam.setExamId(examId);
            int i = examService.addExamToRelatedExam(exam);
            return R.success("发布成功");
        }
        return R.error("发布失败");
    }

    /**
     * 新建考试
     **/
    @PostMapping("/PostTheExam")
    public R<String> PostTheExam(@RequestBody Exam exam) {
        //1.接收前端请求得到数据（试卷名字，题目，学生数量）
        // 创建一个SimpleDateFormat对象，用于格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取系统当前时间
        Date date = new Date();
        // 使用SimpleDateFormat对象将时间格式化为指定格式
        String currentTime = sdf.format(date);
        exam.setCreateTime(currentTime);
        int i = examService.addExam(exam);
        if (i != 0) {
            return R.success("新建成功")
                    .add("examId", exam.getId());
        }
        return R.error("新建失败");
    }


    /**
     * 查询已经新建的考试
     * 按照科目时间（待修改）
     **/
    @GetMapping("/getAllExams/{size}/{pageNum}")
    public R getAllExams(@PathVariable int size, @PathVariable int pageNum) {
        int offset = (pageNum - 1) * size;
        List<Exam> examList = examService.getAllExams(offset, size);
        return R.success(examList)
                .add("pageNum", pageNum)
                .add("size", size);
    }


    /**
     * 根据课程id查询已经新建的考试
     *
     **/
    @GetMapping("/getAllExamsByCourseId/{size}/{pageNum}")
    public R getAllExamsByCourseId(@PathVariable int size,
                                   @PathVariable int pageNum,
                                   @RequestParam int subjectId) {
        int offset = (pageNum - 1) * size;

        PageBean pageBean = examService.getAllExamsByCourseId(offset, size,subjectId);

        return R.success(pageBean);
    }

    /**
     * 查询全部学生交卷（未交卷）情况
     * 多种方式查询 按照班级 全部
     **/
    @GetMapping("/queryTurnInPapers")
    public R queryTurnInPapers() {
        List<TurnInPapers> turnInPapers = examPaperLibraryService.queryTurnInPapers();
        return R.success(turnInPapers);
    }

    /**
     * 查询所有主观题
     **/
    @GetMapping("/queryAllSubjectiveQuestions/{examId}")
    public R queryAllSubjectiveQuestions(@PathVariable int examId) {
        List<ExamQuesInfo> examQuesInfos = studExamService.queryAllSubjectiveQuestions(examId);
        return R.success(examQuesInfos);
    }

    /**
     * 评分 主观题 查询所有
     **/
    @GetMapping("/readTheExam")
    public R readTheExam(@RequestParam int score,
                         @RequestParam int userId,
                         @RequestParam int questionId) {
        boolean b = studExamService.updateStudAnsoIntoStudExam(score, userId,questionId);
        return R.success("评分成功");
    }

    /**
     * 预览试卷
     **/
    @GetMapping("/previewExamPaper/{examId}")
    public R previewExamPaper(@PathVariable int examId) {
        List<ExamQuesInfo> examQuesInfos = studExamService.queryExamQuesByexamId(examId);
        ArrayList<QuesInfo> quesInfos = new ArrayList<>();
        for (ExamQuesInfo examQuesInfo : examQuesInfos) {
            int questionId = examQuesInfo.getQuestionId();
            QuesInfo quesInfo = quesInfoService.queryQuestionInfoByQuesInfoId(questionId);
            quesInfos.add(quesInfo);
        }
        return R.success(quesInfos);
    }

    /**
     * 试卷下载为word/pdf
     **/
    @GetMapping("/downToWord/{examId}")
    public void downToWord(@PathVariable int examId, HttpServletResponse response) throws IOException {
        List<ExamQuesInfo> examQuesInfos = studExamService.queryExamQuesByexamId(examId);
        ArrayList<QuesInfo> quesInfos = new ArrayList<>();
        for (ExamQuesInfo examQuesInfo : examQuesInfos) {
            int questionId = examQuesInfo.getQuestionId();
            QuesInfo quesInfo = quesInfoService.queryQuestionInfoByQuesInfoId(questionId);
            quesInfos.add(quesInfo);
        }
        Exam exam = examService.queryExamByExamId(examId);

        // 使用 WordDocumentGenerator 生成 Word 文档
        WordDocumentGenerator<QuesInfo> documentGenerator = new WordDocumentGenerator<>();

        XWPFDocument document = documentGenerator.generateDocument(exam.getExamName(), quesInfos, new WordDocumentGenerator.DataObjectHandler<QuesInfo>() {
            @Override
            public void handleDataObject(XWPFDocument doc, QuesInfo quesInfo, int questionNumber) {
                // 添加题目内容
                XWPFParagraph questionParagraph = doc.createParagraph();
                questionParagraph.setAlignment(ParagraphAlignment.LEFT);
                XWPFRun questionRun = questionParagraph.createRun();
                questionRun.setText(questionNumber + "." + quesInfo.getTopicContent());
                questionRun.setFontSize(12);
                questionRun.addBreak();

                // 检查选项是否为空
                if (quesInfo.getChoice() != null && !quesInfo.getChoice().isEmpty()) {
                    // 将选项逐一添加到新行
                    String[] choices = quesInfo.getChoice().split("\\|\\|");
                    char optionLabel = 'A';
                    for (String choice : choices) {
                        XWPFParagraph choiceParagraph = doc.createParagraph();
                        choiceParagraph.setAlignment(ParagraphAlignment.LEFT);
                        XWPFRun choiceRun = choiceParagraph.createRun();
                        choiceRun.setText(optionLabel + ". " + choice.trim());
                        choiceRun.setFontSize(12);
                        choiceRun.addBreak();
                        optionLabel++;
                    }
                }
            }
        });

        // 设置 HTTP 响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        response.setHeader("Content-Disposition", "attachment; filename=" + exam.getId() + ".docx");

        // 写入响应输出流
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            document.write(outputStream);
        } finally {
            document.close();
        }

    }


    /**
     * 试卷下载为word/pdf
     **/
    @GetMapping("/downToPdf/{examId}")
    public void downToPdf(@PathVariable int examId, HttpServletResponse response) throws IOException, DocumentException {
        List<ExamQuesInfo> examQuesInfos = studExamService.queryExamQuesByexamId(examId);
        ArrayList<QuesInfo> quesInfos = new ArrayList<>();
        for (ExamQuesInfo examQuesInfo : examQuesInfos) {
            int questionId = examQuesInfo.getQuestionId();
            QuesInfo quesInfo = quesInfoService.queryQuestionInfoByQuesInfoId(questionId);
            quesInfos.add(quesInfo);
        }
        Exam exam = examService.queryExamByExamId(examId);

        // 创建 PDF 文档
        Document pdfDocument = new Document();

        // 设置 HTTP 响应头
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + exam.getId() + ".pdf");

        // 获取响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        PdfWriter.getInstance(pdfDocument, outputStream);

        pdfDocument.open();

        // 设置字体
        // 设置支持中文的字体
        // 设置支持中文的字体
        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bf, 12);
        Font titleFont = new Font(bf, 16, Font.BOLD);

        // 添加标题
        Paragraph title = new Paragraph(exam.getExamName(), titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        pdfDocument.add(title);
        pdfDocument.add(new Paragraph("\n", font));

        // 添加题目和选项
        int questionNumber = 1;
        for (QuesInfo quesInfo : quesInfos) {
            // 添加题目内容
            Paragraph questionParagraph = new Paragraph(questionNumber + ". " + quesInfo.getTopicContent(), font);
            questionParagraph.setAlignment(Element.ALIGN_LEFT);
            pdfDocument.add(questionParagraph);

            // 检查选项是否为空
            if (quesInfo.getChoice() != null && !quesInfo.getChoice().isEmpty()) {
                // 将选项逐一添加到新行
                String[] choices = quesInfo.getChoice().split("\\|\\|");
                char optionLabel = 'A';
                for (String choice : choices) {
                    Paragraph choiceParagraph = new Paragraph(optionLabel + ". " + choice.trim(), font);
                    choiceParagraph.setAlignment(Element.ALIGN_LEFT);
                    pdfDocument.add(choiceParagraph);
                    optionLabel++;
                }
            }

            pdfDocument.add(new Paragraph("\n"));
            questionNumber++;
        }

        pdfDocument.close();
        outputStream.close();
    }


    /**
     * 评分 成绩总分
     * user_id 主观题 exam_id
     * 得到的几个score加起来，得到主观题总分
     * **/
//    @PostMapping("/getSumScore")
//    public R getSumScore(@RequestBody List<ExamQuesInfo> examQuesInfos){
//        for (ExamQuesInfo examQuesInfo : examQuesInfos) {
//            int userId = examQuesInfo.getUserId();
//            String type = examQuesInfo.getType();
//            int examId = examQuesInfo.getExamId();
//            List<StudExam> studExams=studExamService.queryExamQuesByexamIdUserId(userId,examId,type);
//        }
//
//        return null;
//    }


    /**
     * 根据试卷id查询得到对应的题目
     * **/
    @GetMapping("/getAllQuesInfoByExamId/{examId}")
    public R getAllQuesInfoByExamId(@PathVariable int examId){
        List<ExamQuesInfo> examQuesInfos = examQuesInfoService.queryExamByExamId(examId);
        ArrayList<QuesInfo> quesInfos=new ArrayList<>();
        for (ExamQuesInfo examQuesInfo : examQuesInfos) {
            int score = examQuesInfo.getScore();
            int questionId = examQuesInfo.getQuestionId();
            QuesInfo quesInfo2 = quesInfoService.queryQuestionInfoByQuesInfoId(questionId);
            quesInfo2.setScore(score);
            quesInfos.add(quesInfo2);
        }
        return R.success(quesInfos);
    }

    /**
     * 试卷库管理
     * 教师查询发布的考试(按照学科查询)
     *
     * 返回试卷数目和待批阅的试卷数目
     * 应该和学生做完提交动态更新
     **/
    @Transactional
    @GetMapping("/getPostTheExam/{subjectId}")
    public R getPostTheExam(@PathVariable int subjectId) {
        ArrayList<ExamDto> examDtos = new ArrayList<>();
        // 根据学科id查询已经发布的考试
        List<Exam> examList = examService.queryExamBySubjectId(subjectId);
        for (Exam exam : examList) {
            ExamDto examDto = new ExamDto(); // 在这里创建新的examDto实例
            int count = 0;
            int handInCount=0;
            int id = exam.getExamId();
            boolean hasSubjective = examQuesInfoService.queryByExamId(id);
            // false是试卷包含简答题
            if (!hasSubjective) {
                count = examQuesInfoService.countStudent(id);
//                handInCount=
                examDto.setExam(exam);
                examDto.setCount(count);
                System.out.println(examDto);
                examDtos.add(examDto);
            }
            // 这张试卷全是客观题，告诉前端 待批阅是0+ 该考试学生人数
            else {
                examDto.setExam(exam); // 即便全是客观题，也应该设置exam信息
                examDto.setCount(count); // 这里count可以保持为0，或者根据需求设置
                System.out.println(examDto);
                examDtos.add(examDto);
            }
        }
        System.out.println(examDtos);
        return R.success(examDtos);
    }

    /**
     * 学生提交试卷，更新客观题分数
     * **/
    @GetMapping("/updateObjectiveQuestionsScore")
    public R updateObjectiveQuestionsScore(@RequestParam int examId,
                                           @RequestParam int userId) {
        System.out.println("examId: "+examId);
        System.out.println("userId: "+ userId);
//        log.info("examId:",examId);
//        log.info("userId:",userId);
       boolean i= examQuesInfoService.updateObjectiveQuestionsScore(examId,userId);
       return R.success("提交成功");
    }


    /**
     * 根据学生id和试卷id查询学生对应的主观题
     * **/
    @GetMapping("/queryQuesInfoByExam")
    public R queryQuesInfoByExam(@RequestParam int userId,
                                 @RequestParam int examId) {
        List<QuesInfo> list=new ArrayList<>();
        List<ExamQuesInfo> examQuesInfos = examQuesInfoService.queryExamPaperLibrarysByExamId(userId, examId);
        for (ExamQuesInfo examQuesInfo : examQuesInfos) {
            int questionId = examQuesInfo.getQuestionId();
            QuesInfo quesInfo = quesInfoService.queryQuestionInfoByQuesInfoId(questionId);
            quesInfo.setScore(examQuesInfo.getScore());
            list.add(quesInfo);
        }
        return R.success(list);
    }

    /**
     * 查询学生作答的内容
     * **/
    @GetMapping("/getStudAnso")
    public R getStudAnso(@RequestParam int questionId,
                         @RequestParam int userId) {
        ExamQuesInfo examQuesInfo = examQuesInfoService.queryEveryQues(questionId, userId);
        System.out.println(examQuesInfo);
        return R.success(examQuesInfo);
    }

    /**
     * 删除已经创建的试卷
     * **/
    @Transactional
    @GetMapping("/delCreateExam")
    public R delCreateExam(@RequestParam int id){
        //删除创建的考试
        //删除已经发布的考试
        boolean i=examService.delCreateExam(id);
        return R.success("删除考试成功");
    }

    /**
     *
     * **/

    /**
     * 教师阅卷 主观题
     * **/


    /***
     * 查询学生成绩
     * **/

    /**
     * 查看学生个人答题情况
     * **/

    /**
     * 智能画像
     * **/

}






