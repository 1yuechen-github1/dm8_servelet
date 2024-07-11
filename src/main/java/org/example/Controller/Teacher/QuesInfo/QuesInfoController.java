package org.example.Controller.Teacher.QuesInfo;


import org.example.Service.ExamQuesInfoService;
import org.example.Service.QuesInfoService;
import org.example.Service.StudentObjectService;
import org.example.common.R;
import org.example.entity.ExamQuesInfo;
import org.example.entity.QuesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Controller
@RequestMapping("/teacher")
public class QuesInfoController {

    @Autowired
    private QuesInfoService quesInfoService;

    @Autowired
    private ExamQuesInfoService examQuesInfoService;

    /**
     * 题库新增题目
     * **/
    @PostMapping("/addQuesInfo")
    public R addQuesInfo(@RequestBody QuesInfo quesInfo){
        //设立上传时间
        // 创建一个SimpleDateFormat对象，用于格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取系统当前时间
        Date date = new Date();
        // 使用SimpleDateFormat对象将时间格式化为指定格式
        String currentTime = sdf.format(date);
        quesInfo.setUploadTime(currentTime);
        boolean i= quesInfoService.addQuesInfo(quesInfo);
        if (i!=false){
            return R.success("新增题目成功");
        }
        return  R.error("新增题目失败");
    }


    /**
     * 查询题库（选择题，判断题，主观题）
     * **/
    @GetMapping("/queryAllQuestionsByPager/{size}/{pageNum}")
    public R queryAllQuestions(@PathVariable int size, @PathVariable int pageNum){
        int offset = (pageNum - 1) * size;
        List<QuesInfo> quesInfoList=  quesInfoService.queryAllQuestionsByPager(offset,size);
        return R.success(quesInfoList)
                .add("pageNum", pageNum)
                .add("size", size);
    }


    /**
     * 删除题库题目
     * **/
    @Transactional
    @GetMapping("/deleteQuesInfo/{QuesInfoId}")
    public R deleteQuesInfo(@PathVariable int QuesInfoId){
        QuesInfo quesInfo = quesInfoService.queryQuestionInfoByQuesInfoId(QuesInfoId);
        if(quesInfo==null){
            return  R.error("已经删除该数据");
        }
        boolean i4= quesInfoService.deleteQuestionIndoByQuesInfoId(QuesInfoId);
        return R.success("已经删除"+quesInfo.getTopicContent());
    }


    /**
     * 题库新增题目+把题目加入试卷
     * **/
    @Transactional
    @PostMapping("/addQuesInfoAndExam")
    public R addQuesInfoAndExam(@RequestBody QuesInfo quesInfo,
                                @RequestParam int examId,
                                @RequestParam int score){
        ExamQuesInfo quesInfo1=new ExamQuesInfo();
        //设立上传时间
        // 创建一个SimpleDateFormat对象，用于格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取系统当前时间
        Date date = new Date();
        // 使用SimpleDateFormat对象将时间格式化为指定格式
        String currentTime = sdf.format(date);
        quesInfo.setUploadTime(currentTime);
//        boolean i= quesInfoService.addQuesInfo(quesInfo);
        boolean i = quesInfoService.insertQuesIntoQuestionBank(quesInfo);
        quesInfo1.setQuestionId(quesInfo.getId()+1);
        quesInfo1.setUserId(quesInfo.getTeacherId());
        quesInfo1.setExamId(examId);
        quesInfo1.setType(quesInfo.getType());
        quesInfo1.setScore(score);
        quesInfo1.setUserId(quesInfo.getTeacherId());
        boolean i2= examQuesInfoService.addQuesInfoIntoExam1(quesInfo1);
        ArrayList<QuesInfo> quesInfos=new ArrayList<>();
        if (i==true && i2 ==true){
            List<ExamQuesInfo> examQuesInfos = examQuesInfoService.queryExamByExamId(examId);
//            for (ExamQuesInfo examQuesInfo : examQuesInfos) {
////                int questionId = examQuesInfo.getQuestionId();
//                QuesInfo quesInfo2 = quesInfoService.queryQuestionInfoByQuesInfoId(questionId);
//                quesInfos.add(quesInfo2);
//            }
//
//            return R.success(quesInfos);
            return R.success("新增成功");

        }
        return R.error("新增失败");
    }


    /**
     * 把题目加入到试卷（试题量，分数比例） 手动组卷
     * 前端给一个试卷总数，题目的id，每个题的分数
     * **/
    @PostMapping("/addQuesInfoIntoExam")
    public R addQuesInfoIntoExam(@RequestBody List<ExamQuesInfo> examQuesInfoList){
        for (ExamQuesInfo quesInfo : examQuesInfoList) {
            boolean i= examQuesInfoService.addQuesInfoIntoExam1(quesInfo);
        }
        return R.success("加入成功");
    }



    /**
     * 手动组卷，预览试卷内容
     * **/
    @GetMapping("/queryExamByExamId/{examId}")
    public R queryExamByExamId(@PathVariable int examId){
        List<ExamQuesInfo> examQuesInfos= examQuesInfoService.queryExamByExamId(examId);
        ArrayList<QuesInfo> quesInfos=new ArrayList<>();
        for (ExamQuesInfo quesInfo : examQuesInfos) {
            int questionId = quesInfo.getQuestionId();
            QuesInfo quesInfo1 = quesInfoService.queryQuestionInfoByQuesInfoId(questionId);
            quesInfos.add(quesInfo1);
        }
        return R.success(quesInfos);
    }

    /**
     * 随机组卷
     * 未测试
     * **/
    @Transactional
    @GetMapping("/randomGroupVolumes")
    public R randomGroupVolumes(@RequestParam int subjQues,
                                @RequestParam int trueFalse,
                                @RequestParam int mutipleQues,
                                @RequestParam int examId){
        ExamQuesInfo examQuesInfo=new ExamQuesInfo();
        ArrayList<QuesInfo> quesInfos =new ArrayList<>();
        List<QuesInfo> quesInfo= quesInfoService.randomSubjQues(subjQues);
        for (QuesInfo info : quesInfo) {
            examQuesInfo.setExamId(examId);
            examQuesInfo.setType("主观题");
            examQuesInfo.setScore(0);
            examQuesInfo.setQuestionId(info.getId());
            examQuesInfoService.addQuesInfoIntoExam(examQuesInfo);
            quesInfos.add(info);
        }
        List<QuesInfo> quesInfoList= quesInfoService.randomTrueFalsejQues(trueFalse);
        for (QuesInfo info : quesInfoList) {
            examQuesInfo.setExamId(examId);
            examQuesInfo.setType("判断题");
            examQuesInfo.setQuestionId(info.getId());

            examQuesInfoService.addQuesInfoIntoExam(examQuesInfo);
            quesInfos.add(info);
        }
        List<QuesInfo> quesInfoList1=quesInfoService.randomMutipleQues(mutipleQues);
        for (QuesInfo info : quesInfoList1) {
            examQuesInfo.setExamId(examId);
            examQuesInfo.setType("选择题");

            examQuesInfo.setQuestionId(info.getId());
            examQuesInfoService.addQuesInfoIntoExam(examQuesInfo);
            quesInfos.add(info);
        }
        return R.success(quesInfos);
    }

    /**
     * 根据课程id查询所有题目
     * **/
    @GetMapping("/queryAllQues")
    public R queryAllQues(@RequestParam int subjectId){
       List<QuesInfo> quesInfos= quesInfoService.queryAllQues( subjectId);
       return R.success(quesInfos);
    }

    /**
     * 从题库加题目进试卷
     **/
//    @PostMapping("/addQuesIntoExam")
//    public R addQuesIntoExam(@RequestBody ExamQuesInfo examQuesInfo){
//        examQuesInfoService.addQuesInfoIntoExam()
//    }

}
