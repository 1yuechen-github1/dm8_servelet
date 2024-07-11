package org.example.Controller.Teacher;


import org.example.Service.*;
import org.example.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * 处理教师端逻辑
 * **/
@RestController
@Controller
@RequestMapping("/teacher")
public class TeacherController {


    @Autowired
    private ClassRoomService classRoomService;


    /**
     * 删除班级
     * **/
    @GetMapping("/delClass/{classId}")
    public R<String> delClass(@PathVariable int classId){
        boolean i= classRoomService.delClassByClassId(classId);
        if (i==true){
            return R.success("删除成功");
        }
        return R.error("已经删除该班级");
    }


    /**
     * 把选择题加入到题库(不做)
     * **/
    //@Transactional 注解就可以确保该方法中的所有数据库操作要么全部成功，要么全部失败，从而保持数据一致性。
//    @Transactional
//    @PostMapping("/insertChoiceQuesIntoQuestionBank")
//    public R insertChoiceQuesIntoQuestionBank(@RequestBody List<ChoiceQues> choiceQues){
//        QuesInfo quesInfo = new QuesInfo();
//        for (ChoiceQues choiceQue : choiceQues) {
//            quesInfo.setType(choiceQue.getType());
//            quesInfo.setLevel(choiceQue.getLevel());
//            quesInfo.setCourseId(choiceQue.getCourseId());
//            quesInfo.setTeacherId(choiceQue.getTeacherId());
//            // 创建一个SimpleDateFormat对象，用于格式化时间
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            // 获取系统当前时间
//            Date date = new Date();
//            // 使用SimpleDateFormat对象将时间格式化为指定格式
//            String currentTime = sdf.format(date);
//            quesInfo.setUploadTime(currentTime);
//            quesInfo.setTopicContent(choiceQue.getTopicContent());
//            boolean i= quesInfoService.insertQuesIntoQuestionBank(quesInfo);
//            choiceQue.setQuestionId(quesInfo.getQuesInfoId());
//            boolean i2= choiceQuesService.insertChoiceQuesIntoQuestionBank(choiceQue);
//            if (!i || !i2) {
//                // 如果 i 或 i2 是 false，返回失败响应并退出循环
//                return R.error("加入到题库失败");
//            }
//        }
//        return R.success("加入到题库成功");
//    }

    /**
     * 把判断题加入到题库（不做）
     * **/
//    @Transactional
//    @PostMapping("/insertTrueOrFalseintoQuestionBank")
//    public R insertTrueOrFalseintoQuestionBank(@RequestBody List<TrueFalse> trueFalses){
//        QuesInfo quesInfo = new QuesInfo();
//        for (TrueFalse trueFalse : trueFalses) {
//            quesInfo.setType(trueFalse.getType());
//            quesInfo.setLevel(trueFalse.getLevel());
//            quesInfo.setCourseId(trueFalse.getCourseId());
//            quesInfo.setTeacherId(trueFalse.getTeacherId());
//            // 创建一个SimpleDateFormat对象，用于格式化时间
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            // 获取系统当前时间
//            Date date = new Date();
//            // 使用SimpleDateFormat对象将时间格式化为指定格式
//            String currentTime = sdf.format(date);
//            quesInfo.setUploadTime(currentTime);
//            quesInfo.setTopicContent(trueFalse.getTopicContent());
//            boolean i= quesInfoService.insertQuesIntoQuestionBank(quesInfo);
//            trueFalse.setQuestionId(quesInfo.getQuesInfoId());
//            boolean i2 = trueFalseService.insertTrueOrFalseintoQuestionBank(trueFalse);
//            if (!i || !i2) {
//                // 如果 i 或 i2 是 false，返回失败响应并退出循环
//                return R.error("加入到题库失败");
//            }
//        }
//        return R.success("加入到题库成功");
//    }


    /**
     * 把主观题加入到题库（不做）
     * **/
//    @Transactional
//    @PostMapping("/insertSubjecQuesintoQuestionBank")
//    public R insertSubjecQuesintoQuestionBank(@RequestBody List<SubjecQues> subjecQues){
//        QuesInfo quesInfo = new QuesInfo();
//        for (SubjecQues ques : subjecQues) {
//            quesInfo.setType(ques.getType());
//            quesInfo.setLevel(ques.getLevel());
//            quesInfo.setCourseId(ques.getCourseId());
//            quesInfo.setTeacherId(ques.getTeacherId());
//            // 创建一个SimpleDateFormat对象，用于格式化时间
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            // 获取系统当前时间
//            Date date = new Date();
//            // 使用SimpleDateFormat对象将时间格式化为指定格式
//            String currentTime = sdf.format(date);
//            quesInfo.setUploadTime(currentTime);
//            quesInfo.setTopicContent(ques.getTopicContent());
//            boolean i= quesInfoService.insertQuesIntoQuestionBank(quesInfo);
//            ques.setQuestionId(quesInfo.getQuesInfoId());
//            boolean i2 = subjecQuesService.insertSubjecQuesintoQuestionBank(ques);
//            if (!i || !i2) {
//                // 如果 i 或 i2 是 false，返回失败响应并退出循环
//                return R.error("加入到题库失败");
//            }
//        }
//        return R.success("加入到题库成功");
//    }








    /**
     * 试卷word（pdf tif）导入修改格式
     * **/

    /**
     * 监考学生 是否切屏 考试剩余时间提醒
     * **/


    /**
     * 查看学生个人信息（实训情况，考试情况）
     * **/

    /**
     * 根据学生个人信息给出学生画像（学习建议）
     * **/


    /**
     * 建立实训环境，定时回收
     * **/


}
