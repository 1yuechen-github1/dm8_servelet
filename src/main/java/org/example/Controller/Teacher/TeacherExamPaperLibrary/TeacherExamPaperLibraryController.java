package org.example.Controller.Teacher.TeacherExamPaperLibrary;

import org.example.Service.*;
import org.example.common.R;
import org.example.config.DateConfig;
import org.example.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Controller
@RequestMapping("/teacher")
public class ExamPaperLibraryController {

    @Autowired
    private ObjectService objectService;


    @Autowired
    private ExamService examService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ExamPaperLibraryService examPaperLibraryService;

    @Autowired
    private StudExamService studExamService;

    /**
     * 试卷库管理
     * 1.发布考试
     * **/
    @Transactional
    @GetMapping("/postTheExam/{examId}")
    public R postTheExam(@PathVariable int examId){
        Exam exam= examService.queryExamByExamId(examId);
        if (exam!=null){
            String formattedTime = DateConfig.getCurrentTimeFormatted();
            exam.setCreateTime(formattedTime);
            int i = examService.addExamToRelatedExam(exam);
            return R.success("发布成功");
        }
        return R.error("发布失败");
    }

    /**
     * 新建考试
     * **/
    @PostMapping("/PostTheExam")
    public R<String> PostTheExam(@RequestBody Exam exam){
        //1.接收前端请求得到数据（试卷名字，题目，学生数量）
//        Teacher teacher= teacherService.queryTeacherByTeacherId(exam.getCreateTeacher());
//        Object subject=objectService.queryByObjectId(exam.getSubjectId());
//        if (teacher==null || subject==null){
//            return R.error("没有该教师或者这门课");
//        }
        // 创建一个SimpleDateFormat对象，用于格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取系统当前时间
        Date date = new Date();
        // 使用SimpleDateFormat对象将时间格式化为指定格式
        String currentTime = sdf.format(date);
        exam.setCreateTime(currentTime);
        int i= examService.addExam(exam);
        if (i!=0){
            return R.success("新建成功");
        }
        return R.error("新建失败");
    }

    /**
     * 查询已经新建的考试
     * 按照科目时间（待修改）
     * **/
    @GetMapping("/getAllExams/{size}/{pageNum}")
    public R getAllExams(@PathVariable int size, @PathVariable int pageNum) {
        int offset = (pageNum - 1) * size;
        List<Exam> examList= examService.getAllExams(offset,size);
        return R.success(examList)
                .add("pageNum", pageNum)
                .add("size", size);
    }

    /**
     * 查询学生交卷（未交卷）情况
     * 多种方式查询 按照班级 全部
     * **/
    @GetMapping("/queryTurnInPapers")
    public R queryTurnInPapers(){
        List<TurnInPapers> turnInPapers= examPaperLibraryService.queryTurnInPapers();
        return R.success(turnInPapers);
    }


    /**
     * 阅卷 主观题
     * **/
    @GetMapping("/readTheExam/{examId}/{quesInfoId}")
    public R  readTheExam(@RequestBody StudExam studExam){
//       boolean i=examQuesInfoService.insertIntoExamQuesInfo(quesInfo);
        boolean b = studExamService.addStudAnsoIntoStudExam(studExam);
        return R.success("评分成功");
    }


    /**
     *阅卷   进行中的考试（已经提交的） 已经结束的考试
     * 按人批阅 按题目批阅
     * 打分 写评语
     * 主观题可查询答案跟参考答案的相似度 优秀答案转发给所有学生讨论
     * 查询题目批阅情况做图表分析
     * 导出考试附件
     * **/
}
