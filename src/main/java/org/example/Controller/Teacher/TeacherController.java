package org.example.Controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.Dto.ClassDto;
import org.example.Service.*;
import org.example.common.CustomException;
import org.example.common.R;
import org.example.config.Base64Config;
import org.example.config.DateConfig;
import org.example.entity.*;
import org.example.entity.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 处理教师端逻辑
 * **/
@RestController
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private ObjectService objectService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExamService examService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private StudentObjectService studentObjectService;

    @Autowired
    private QuesInfoService quesInfoService;

    @Autowired
    private ExamQuesInfoService examQuesInfoService;

    @Autowired
    private StudentService studentService;


    /**
     * 新建课程
     * 可上传课程图片
     * **/
    @PostMapping("/createCourse/{userId}")
    public R<String> createCourse(@RequestBody Object object,@PathVariable int userId) {
        // 解析前端传递的数据
        String name = object.getObjectName();
        Object queryByObject = objectService.queryByObject(name);
        if (queryByObject!=null){
            return R.error("该课程已经存在");
        }
        String major = object.getMajor();
        String base64Image = object.getImagePath();
        // 去掉开头的 "data:image/jpeg;base64,"
        if (base64Image.startsWith("data:image/image/jpeg;base64,")) {
            base64Image = base64Image.substring("data:image/image/jpeg;base64,".length());
        } else if (base64Image.startsWith("data:image/jpeg;base64,")){
            base64Image = base64Image.substring("data:image/jpeg;base64,".length());
        } else if (base64Image.startsWith("data:image/png;base64,")){
        base64Image = base64Image.substring("data:image/jpeg;base64,".length());
    }
        // 生成UUID作为文件名
        String fileName = UUID.randomUUID().toString() + ".jpeg";
        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/images/" + fileName;
        String imagePath = "/images/" + fileName;
//        String a="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";
        try {
            // 将 Base64 字符串解码为字节数组
            byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

            // 创建一个输出流，将字节数组写入到文件中
            OutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(decodedBytes);
            outputStream.close();
            Teacher teacher = teacherService.queryTeacherByUserId(userId);
            int teacherId = teacher.getTeacherId();
            // 调用服务创建课程，并传递图片路径
            int result = objectService.createCourse(name, major, imagePath,teacherId);

            if (result != 0) {
                return R.success("新建课程成功");
            } else {
                return R.error("新建课程失败");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return R.error("图片Base64解码失败");
        } catch (IOException e) {
            e.printStackTrace();
            return R.error("图片处理失败");
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("未知错误");
        }
    }

    /**
     *将学生加入到课程
     */
    @PostMapping("/addStudent/{courseName}")
    public R<String> addStudent(@PathVariable String courseName, @RequestBody List<Student> Students) {
        //判断object表是否存在这个课程，如果不存在就告诉前端不存在该课程
       Object object =objectService.queryByObject(courseName);
        if(object==null){
            return R.error("不存在该课程，请重新输入");
        }
        //根据courseName得到object的id，把object_id和students_id存入object_student表
        int objectId = object.getId();
        for (Student student : Students) {
            User user = userService.getUserByUserName(student.getUserName());
            String status = user.getStatus();
            //1是学生，0是教师
            if (user==null || status.equals("0")){
                return R.error("该学生学号不存在");
            } else if (student.getUserId()!=user.getId()) {
                return R.error("学号和学生姓名不匹配");
            }
            int userId = student.getUserId();
            objectService.addStudent(objectId, userId);
        }
        return R.success("完成学生加入到课程");
    }


    /**
     * 查询已经开设的课程
     * **/
    @GetMapping ("/{userId}")
    public R<List<Object>> queryAll(@PathVariable int userId ){
        //根据userid查询teacher表得到teacherId
       Teacher teacher = teacherService.queryTeacherByUserId(userId);
            if (teacher!=null){
                int teacherId = teacher.getTeacherId();
                List<Object> objects= objectService.queryByObjectByTeacherId(teacherId);
                return R.success(objects);
        }
       return R.error("还没有加入课程");
    }

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
     *修改课程
     * **/
    @PostMapping("/updateSubject")
    public R updateSubject(@RequestBody Object object){
        int objectId = object.getId();
        R <String> base64Image1 = null;
        //修改学科表信息，
        String base64Image = object.getImagePath();
        String fileName = UUID.randomUUID().toString() + ".jpeg";
        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/images/" + fileName;
        String imagePath = "/images/" + fileName;
        if (base64Image!=null){
            base64Image1= Base64Config.decodeBase64Image(base64Image, filePath);
            object.setImagePath(imagePath);
        }

        boolean i=objectService.updateSubject(object);
//        Object object1 = objectService.queryByObjectId(object.getId());
        if(object!=null){
            return R.success("修改成功");
        }
        return R.error("修改失败");
    }

    /**
     * 修改课程内学生信息
     * **/
    public R<String> updateStudentCourse(){
        //感觉好像不用做，后面补充吧
        return null;
    }

    /**
     * 删除加入课程的学生
     * **/
    @PostMapping("/delStudentCourse/{courseId}")
    public R<String> delStudentCourse(@PathVariable int courseId, @RequestBody List<Integer> userIds) {
        boolean allDeleted = true; // 追踪操作是否全部成功
        for (Integer userId : userIds) {
            boolean deleted = studentObjectService.delStudentCourseByCourseId(courseId, userId);
            if (!deleted) {
                allDeleted = false; // 如果有任何一次操作失败，则标记为false
                break; // 如果出现了失败，可以提前退出循环，因为不需要继续尝试删除
            }
        }
        if (allDeleted) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    /**
     * 删除课程
     * **/
    @GetMapping("/delSubject/{subjectId}")
    public R delSubject(@PathVariable int subjectId){
        boolean delled = objectService.delObjectBysubjectId(subjectId);
        if (delled!=false){
            return R.success("删除成功");
        }
        return R.error("删除成功");
    }

    /**
     * 查询加入课程的学生
     * **/
    @GetMapping("/queryAllStudentObject")
    public R<List<StudentObject>> queryListStudentObject(){
        List<StudentObject> studentObjects= studentObjectService.queryAllStudentObject();
        return R.success(studentObjects);
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
//        String type = quesInfo.getType();
//        System.out.println(type);
//        boolean success = true;
//        if (type.equals("选择题")) {
//            success= choiceQuesService.deletechoiceQuesByQuesInfoId(QuesInfoId);
//        } else if (type.equals("判断题")) {
//            success= trueFalseService.deleteTrueFalseQuesByQuesInfoId(QuesInfoId);
//        }else if(type.equals("主观题")){
//            //删除主观题
//            success= subjecQuesService.deleteSubjecQuesByQuesInfoId(QuesInfoId);
//        }
//        if (!success) {
//            throw new CustomException("已经删除该数据");
//        }
//
        boolean i4= quesInfoService.deleteQuestionIndoByQuesInfoId(QuesInfoId);
        return R.success("已经删除"+quesInfo.getTopicContent());
    }


    /**
     * 查询教师所加入的班级
     * **/
    @GetMapping("/queryClassByUserId/{userId}")
    public R queryClassByUserId(@PathVariable int userId){
        //得到班级列表
        List<ClassDto> classRooms = classRoomService.queryByTeacherId(userId);
//        每个班级列表有多个课程
        for (ClassDto classRoom : classRooms) {
            //一个班级列表有多个学科（一个老师给多个学科授课）
            List<Student> students = studentService.queryStudentByClassRoom(classRoom.getClassName());
            classRoom.setSum(students.size());
            //每个班级对应的学科列表
            int teacherId = classRoom.getTeacherId();
            String className= classRoom.getClassName();
            List<Object> objectList = objectService.queryByObjectByTeacherIdAndClass(teacherId,className);
//            for (Object object : objectList) {
//                object.setSum(students.size());
//            }
            classRoom.setSubjectName(objectList);
//            classRoom.setSum(students.size());
        }

        if (classRooms==null){
            return R.error("还没有开设班级，请先开设班级");
        }
        return R.success(classRooms);
    }

    /**
     * 在班级内找到对应的学生
     * **/
    @GetMapping("/queryStudentByClassName/{classRoom}")
    public R queryStudentByClassName(@PathVariable String classRoom){
        List<Student> students = studentService.queryStudentByClassRoom(classRoom);
        HashMap<String,String> hashMap=new HashMap<>();
        ArrayList<Student> arrayList=new ArrayList<>();
        for (Student student : students) {
            int userId = student.getUserId();
            User user = userService.getUserById(userId);
            student.setRealName(user.getRealName());
            student.setSex(user.getSex());
            student.setPhone(user.getPhone());
            arrayList.add(student);
        }
        return R.success(arrayList);
    }

    /**
     * 把题目加入到试卷（试题量，分数比例）
     * 前端给一个试卷总数，题目的id，每个题的分数
     * **/
    @PostMapping("/addQuesInfoIntoExam")
    public R addQuesInfoIntoExam(@RequestBody List<ExamQuesInfo> examQuesInfoList){
        for (ExamQuesInfo quesInfo : examQuesInfoList) {
            boolean i= examQuesInfoService.addQuesInfoIntoExam(quesInfo);
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
     * 新建考试
     * **/
    @PostMapping("/PostTheExam")
    public R<String> PostTheExam(@RequestBody Exam exam){
        //1.接收前端请求得到数据（试卷名字，题目，学生数量）
        Teacher teacher= teacherService.queryTeacherByTeacherId(exam.getCreateTeacher());
        Object subject=objectService.queryByObjectId(exam.getSubjectId());
        if (teacher==null || subject==null){
            return R.error("没有该教师或者这门课");
        }
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
     * 查询学生交卷（未交卷）情况
     * 多种方式查询 按照班级 全部
     * **/
    public R queryTurnInPapers(){
        return null;
    }

    /**
     *阅卷   进行中的考试（已经提交的） 已经结束的考试
     * 按人批阅 按题目批阅
     * 打分 写评语
     * 主观题可查询答案跟参考答案的相似度 优秀答案转发给所有学生讨论
     * 查询题目批阅情况做图表分析
     * 导出考试附件
     * **/


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
