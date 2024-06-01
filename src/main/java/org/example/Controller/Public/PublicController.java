package org.example.Controller;

import org.example.Service.ClassRoomService;
import org.example.Service.StudentService;
import org.example.Service.TeacherService;
import org.example.Service.UserService;
import org.example.common.R;
import org.example.entity.ClassRoom;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.web.util.UriUtils;

/**
 * 处理学生，老师公共请求
 * **/
@RestController
@Controller
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassRoomService classRoomService;


    /**
     * 用户登录
     * **/
    @PostMapping("/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user){
        //1、将页面提交的密码password进行md5加密处理
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        //2、根据页面提交的用户名username查询数据库
        String userName = user.getUserName();
        //根据唯一标识userName查询数据库
        User user1 = userService.getUserByUserName(userName);
        //3、如果没有查询到则返回登录失败结果
        if(user1 == null){
            return R.error("登录失败");
        }
        //4、密码比对，如果不一致则返回登录失败结果
        if(!user1.getPassword().equals(password)){
            return R.error("登录失败");
        }
        //5.1登录成功
        //判断是学生还是教师
        String position = user1.getPosition();
        if ( position!=null){
            if(position.equals("教师")){
                //根据user1的id查询student表
                Teacher teacher =teacherService.queryTeacherByUserId(user1.getId());
                teacher.setId(user1.getId());
                teacher.setPassword(user1.getPassword());
                teacher.setUserName(user1.getUserName());
                teacher.setEmail(user1.getEmail());
                teacher.setSex(user1.getSex());
                teacher.setImage(user1.getImage());

                teacher.setPhone(user1.getPhone());
                teacher.setStatus(user1.getStatus());
                teacher.setCreateTime(user1.getCreateTime());
                teacher.setRealName(user1.getRealName());
                teacher.setPosition(user1.getPosition());
                teacher.setIdCard(user1.getIdCard());
                if (teacher==null){
                    return R.error("不存在该教师");
                }
                return R.success(teacher);
            }
            else {
                Student student =studentService.queryStudentByUserId(user1.getId());
                student.setId(user1.getId());
                student.setPassword(user1.getPassword());
                student.setUserName(user1.getUserName());
                student.setEmail(user1.getEmail());
                student.setSex(user1.getSex());
                student.setImage(user1.getImage());
//                student.setClassroom();

                student.setPhone(user1.getPhone());
                student.setStatus(user1.getStatus());
                student.setCreateTime(user1.getCreateTime());
                student.setRealName(user1.getRealName());
                student.setPosition(user1.getPosition());
                student.setIdCard(user1.getIdCard());
                if (student==null){
                    return R.error("不存在该学生");
                }
                return R.success(student);
            }
        }
        else {
            Student student =studentService.queryStudentByUserId(user1.getId());
            student.setId(user1.getId());
            student.setPassword(user1.getPassword());
            student.setUserName(user1.getUserName());
            student.setEmail(user1.getEmail());
            student.setSex(user1.getSex());
            student.setImage(user1.getImage());

            student.setPhone(user1.getPhone());
            student.setStatus(user1.getStatus());
            student.setCreateTime(user1.getCreateTime());
            student.setRealName(user1.getRealName());
            student.setPosition(user1.getPosition());
            student.setIdCard(user1.getIdCard());
            if (student==null){
                return R.error("不存在该学生");
            }
            return R.success(student);
        }
    }

    /**
     * 用户注册
     * **/
    @Transactional
    @PostMapping("/register")
    public R<String> register(@RequestBody User user) {
        User userByUserName = userService.getUserByUserName(user.getUserName());
        if (userByUserName == null) {
            String password = user.getPassword();
            // 对密码进行 MD5 加密
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            user.setPassword(password);
            // 如果不存在相同用户名的用户记录，则插入新用户记录
            int i = userService.insertUser(user);
            //写入数据进teacher表或者student表
            //useGeneratedKeys="true" keyProperty="id"
            //insertUser插入成功后把数据给到user对象
            String position = user.getPosition();
            if (position.equals("教师")){
               int i1= teacherService.addTeacher(user.getId());
            }else {
                int i2= studentService.addStudent(user.getId());
            }
            if (i != 0) {
                return R.success("用户注册成功");
            }
        }
        // 如果插入用户记录失败，则返回错误信息
        return R.error("用户名已重复");
    }

    /**
     * 用户退出
     * **/
    @GetMapping("/quit")
    public R quit(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false); // 获取当前会话，如果没有则返回null
        if (session != null) {
            session.invalidate(); // 使会话无效
        }
        return R.success("用户退出成功");
    }

    /**
     *查询所有班级
     * **/
    @GetMapping("/getAllClassroom")
    public R<List<ClassRoom>> getAllClassroom(){
       List<ClassRoom> classRooms  = classRoomService.getAllClassroom();
       return R.success(classRooms);
    }

    /**
     * 根据图片路径把图片写在前端
     *
     * @return
     **/
    @GetMapping("/getImage/images/{imagePath}")
    public ResponseEntity<Resource> getImage(@PathVariable String imagePath) {
        try {
            // Decode the path to handle spaces and special characters
            String decodedPath = System.getProperty("user.dir") + "/src/main/resources/static/images/" + imagePath;
//            String decodedPath = UriUtils.decode(imagePath, StandardCharsets.UTF_8);
            Path filePath = Paths.get(decodedPath).toAbsolutePath().normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                String contentType = getContentType(filePath);
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    private String getContentType(Path path) {
        try {
            return Files.probeContentType(path);
        } catch (IOException e) {
            return "application/octet-stream";
        }
    }


}
