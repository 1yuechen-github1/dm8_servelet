package org.example.Controller.Teacher.ClassesRoom;


import org.example.Dto.ClassDto;
import org.example.Service.ClassRoomService;
import org.example.Service.ObjectService;
import org.example.Service.StudentService;
import org.example.Service.UserService;
import org.example.common.R;
import org.example.entity.Object;
import org.example.entity.Student;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@Controller
@RequestMapping("/teacher")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ObjectService objectService;

    @Autowired
    private UserService userService;



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
}
