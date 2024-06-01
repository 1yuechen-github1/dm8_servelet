package org.example.Controller.Student.StudExamPaperLibrary;


import org.example.Service.ExamQuesInfoService;
import org.example.Service.QuesInfoService;
import org.example.Service.StudExamService;
import org.example.common.R;
import org.example.entity.ExamQuesInfo;
import org.example.entity.QuesInfo;
import org.example.entity.StudExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
@RequestMapping("/student")
public class ExamPaperLibraryController {

    @Autowired
    private ExamQuesInfoService examQuesInfoService;

    @Autowired
    private QuesInfoService quesInfoService;

    @Autowired
    private StudExamService studExamService;

    /**
     * 学生进入答题页面（选择+主观题）
     * **/
    @GetMapping("/queryExamPaperLibraryByExamId/{examId}")
    public R queryExamPaperLibraryByExamId(@PathVariable int examId){
        List<ExamQuesInfo> quesInfos = examQuesInfoService.queryExamByExamId(examId);
        ArrayList<QuesInfo> examQuesInfos=new ArrayList<>();
        for (ExamQuesInfo quesInfo : quesInfos) {
            int questionId = quesInfo.getQuestionId();
            QuesInfo quesInfo1 = quesInfoService.queryQuestionInfoByQuesInfoId(questionId);
            examQuesInfos.add(quesInfo1);
        }
        return R.success(examQuesInfos);
    }


    /**
     * 阅卷（客观题）
     * **/
    @GetMapping("/queryObjectiveQuestions/")
    public R queryObjectiveQuestions(@PathVariable List<QuesInfo> quesInfos){
        ArrayList<QuesInfo> quesInfos1=new ArrayList<>();
        for (QuesInfo quesInfo : quesInfos) {
            QuesInfo quesInfo1 = quesInfoService.queryQuestionInfoByQuesInfoId(quesInfo.getQuesInfoId());
            quesInfos1.add(quesInfo1);
        }
        return R.success(quesInfos1);
    }

    /**
     * 学生提交答题
     * **/
    @PostMapping("/addStudAnsoIntoStudExam")
    public R addStudAnsoIntoStudExam(@RequestBody List<StudExam> studExams){
        for (StudExam studExam : studExams) {
            boolean i=studExamService.addStudAnsoIntoStudExam(studExam);
        }
        return R.success("提交成功");
    }

    /**
     *查询考试成绩（学习记录）
     * **/


}
