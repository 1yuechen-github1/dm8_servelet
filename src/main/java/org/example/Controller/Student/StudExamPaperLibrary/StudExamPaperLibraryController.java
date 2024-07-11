package org.example.Controller.Student.StudExamPaperLibrary;


import lombok.extern.slf4j.Slf4j;
import org.example.Service.ExamQuesInfoService;
import org.example.Service.QuesInfoService;
import org.example.Service.StudExamService;
import org.example.common.R;
import org.example.entity.Exam;
import org.example.entity.ExamQuesInfo;
import org.example.entity.QuesInfo;
import org.example.entity.StudExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@Controller
@RequestMapping("/student")
public class StudExamPaperLibraryController {

    @Autowired
    private ExamQuesInfoService examQuesInfoService;

    @Autowired
    private QuesInfoService quesInfoService;

    @Autowired
    private StudExamService studExamService;

    /**
     * 学生进入答题页面（选择+主观题）
     * 设置用户id在exam_question表
     * **/
    @GetMapping("/queryExamPaperLibraryByExamId/{examId}")
    public R queryExamPaperLibraryByExamId(@PathVariable int examId,
                                           @RequestParam int userId){
        R<ArrayList<QuesInfo>> arrayListR = examQuesInfoService.queryExamPaperLibraryByExamId(examId,userId);
        System.out.println(arrayListR);
//        log.info();
        return arrayListR;
    }

    /**
     * 学生做题逻辑
     * **/
//    public R StudFinishQues(){
//
//    }

    /**
     * 学生提交答题
     * **/
    @PostMapping("/addStudAnsoIntoStudExam")
    public R addStudAnsoIntoStudExam(@RequestBody ExamQuesInfo examQuesInfo){
       boolean i=studExamService.addStudAnsoIntoStudExam(examQuesInfo);
        System.out.println(examQuesInfo);
       if (i==true){
           return R.success("提交成功");
       }
       return R.error("提交失败");
    }

    /**
     * 学生查询每一题的内容
     * **/
    @GetMapping("/queryEveryQues")
    public ExamQuesInfo queryEveryQues(@RequestParam int quertionId,
                                   @RequestParam int userId){
        ExamQuesInfo examQuesInfo = examQuesInfoService.queryEveryQues(quertionId, userId);
        log.info("examQuesInfo", examQuesInfo);
        return examQuesInfo;
    }


    /**
     * 学生查询已经发布的考试
     * **/
    @GetMapping("/queryAllExams")
    public R queryAllExams(@RequestParam String className,
                           @RequestParam int subjectId){
       List<Exam>  enumList= studExamService.queryExamByExamIdAndCourseId(className,subjectId);
        return R.success(enumList);
    }

    /**
     *查询考试成绩（学习记录）
     * **/
    public R queryExamScore(){
        return null;
    }

}
