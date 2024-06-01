package org.example.Controller;

import org.example.Service.ObjectService;
import org.example.Service.StudentObjectService;
import org.example.Service.StudentService;
import org.example.Service.UserService;
import org.example.common.R;
import org.example.config.Base64Config;
import org.example.entity.Object;
import org.example.entity.Student;
import org.example.entity.StudentObject;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 处理学生请求
 * **/
@RestController
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentObjectService studentObjectService;

    @Autowired
    private ObjectService objectService;

    /**
     * 提交试卷
     * 1.提交选择题
     *
     * 2，提交判断题
     *
     * 3.提交主观题
     * **/

    /**
     *查询考试成绩（学习记录）
     * **/

    /***
     * 智能画像
     * **/

    /**
     * 根据智能画像给出学习建议
     * **/

    /**
     * 通讯录（查询同班同学）
     * **/
    @GetMapping("/queryStudentByClassRoom/{clssRoom}")
    public R<List<Student>> queryStudentByClassRoom(@PathVariable String clssRoom){
        List<Student> students= studentService.queryStudentByClassRoom(clssRoom);
        ArrayList<Student> students1=new ArrayList<>();
        for (Student student : students) {
            int userId = student.getUserId();
            User user = userService.getUserById(userId);
            student.setEmail(user.getEmail());
            student.setPhone(user.getPhone());
            student.setRealName(user.getRealName());
            student.setSex(user.getSex());
            students1.add(student);
        }
        return R.success(students1);
    }

    /**
     * 加入课程
     * **/
    @GetMapping("/joinTheClass/{userId}/{subjectId}")
    public R joinTheClass(@PathVariable Integer userId, @PathVariable Integer subjectId) {
        List<StudentObject> studentObjects = studentObjectService.queryStudentObjectsByuserId(userId);
        for (StudentObject studentObject : studentObjects) {
            int objectId = studentObject.getObjectId();
            if (objectId == subjectId) {
                return R.error("已经加入课程，请勿重复加入");
            }
        }
        try {
            boolean i = studentObjectService.joinTheClass(userId, subjectId);
            if (i) {
                return R.success("加入课程成功");
            }
        } catch (Exception e) {
            if (e.getCause() != null && e.getCause() instanceof dm.jdbc.driver.DMException) {
                // 检查是否违反引用约束的特定异常
                if (e.getCause().getMessage().contains("违反引用约束[CONS134218918]")) {
                    return R.error("该课程不存在");
                }
            }
            // 其他异常
            return R.error("加入班级失败");
        }

        return R.error("加入班级失败");
    }


    /**
     * 退出课程
     * **/
    @GetMapping("/leaveTheCorse/{userId}/{courseId}")
    public R leaveTheCorse(@PathVariable Integer userId,@PathVariable Integer courseId ){
        boolean b = studentObjectService.delStudentCourseByCourseId(userId, courseId);
        if (b==true){
            return R.success("退出课程成功");
        }
        return R.error("已经退出成功，请勿重复退出");
    }

    /**
     * 查询学生个人信息
     * **/
    @GetMapping("/getUserByUserName/{userName}")
    public R<User> queryStudentByUserId(@PathVariable String userName){
        User userByUserName = userService.getUserByUserName(userName);
        return R.success(userByUserName);
    }


    /**
     * 修改学生个人资料
     * **/
    @PostMapping("/updateStudent")
    public R updateStudent(@RequestBody User user){
        R <String> base64Image1 = null;
        //根据user_id更新users表数据
        //修改更新时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取系统当前时间
        Date date = new Date();
        // 使用SimpleDateFormat对象将时间格式化为指定格式
        String currentTime = sdf.format(date);
        user.setCreateTime(currentTime);
        //修改个人头像
        String base64Image = user.getImage();
        String fileName = UUID.randomUUID().toString() + ".jpeg";
        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/images/" + fileName;
        String imagePath = "/images/" + fileName;
        if (base64Image!=null){
            base64Image1= Base64Config.decodeBase64Image(base64Image, filePath);
            user.setImage(imagePath);
        }
        boolean i= userService.updateUserByUserId(user);
        if (i == true) {
            return R.success(userService.getUserById(user.getId()));
        }
        return R.error("修改失败");
    }

    /**
     * 学生课程（我已经选好的）
     * **/
    @GetMapping("/getSubjectByUserId/{userId}")
    public R getSubjectByUserId(@PathVariable int userId){
        List<StudentObject> studentObjects = studentObjectService.queryStudentObjectsByuserId(userId);
       ArrayList<Object> objectArrayList=new ArrayList<>();
       if (studentObjects!=null){
           for (StudentObject studentObject : studentObjects) {
               int objectId = studentObject.getObjectId();
               Object object = objectService.queryByObjectId(objectId);
               objectArrayList.add(object);
           }
           return R.success(objectArrayList);
       }
      return R.success("未加入课程");
    }
}
