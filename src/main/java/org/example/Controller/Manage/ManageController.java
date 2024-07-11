package org.example.Controller.Manage;

import org.example.Service.ClassRoomService;
import org.example.Service.ObjectService;
import org.example.Service.StudentObjectService;
import org.example.common.R;
import org.example.entity.ClassRoom;
import org.example.entity.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.UUID;

@RestController
@Controller
@RequestMapping("/mange")
public class ManageController {
    @Autowired
    private ObjectService objectService;

    @Autowired
    private StudentObjectService studentObjectService;

    @Autowired
    private ClassRoomService classRoomService;

    /**
     * 修改班级具体情况
     * **/

    /**
     * 删除已经开设的班级
     * **/
    @GetMapping("/delClass/{subjectId}")
    public R<String> delClass(@PathVariable int subjectId){
        //删除学科表
        boolean i=objectService.delObjectBysubjectId(subjectId);
        // 根据学科表id删除学科（学生表）表记录
        boolean i2=studentObjectService.delObjectAndStudebtBysubjectId(subjectId);
        if (i==false || i2==false){
            return R.error("该课程已经删除");
        }
        return R.success("删除成功");
    }

    /**
     * 修改班级
     * **/
    public R<String> updateClass(){
        //接收班级表的数据
        return R.success("修改成功");
    }

    /**
     * 新增班级
     * **/
    @PostMapping("/createClassRoom")
    public R<String> createCourse(@RequestBody ClassRoom classRoom) {
        // 解析前端传递的数据
        String name = classRoom.getClassName();
        int teacherId = classRoom.getTeacherId();
        ClassRoom queryByObject = classRoomService.queryByClassName(name);
        if (queryByObject!=null){
            return R.error("该班级已经存在");
        }
        int result = classRoomService.createClassRoom(name, teacherId);

            if (result != 0) {
                return R.success("新建班级成功");
            } else {
                return R.error("新建班级失败");
            }
        }
    }




