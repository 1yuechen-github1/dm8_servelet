package org.example.Controller.Student.Subject;

import org.example.Service.*;
import org.example.common.R;
import org.example.entity.ClassRoom;
import org.example.entity.ClassRoomObject;
import org.example.entity.Object;
import org.example.entity.StudentObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
@RequestMapping("/student")
public class SubjectController {

    @Autowired
    private StudentObjectService studentObjectService;

    @Autowired
    private ObjectService objectService;

    @Autowired
    private ClassService classService;

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
