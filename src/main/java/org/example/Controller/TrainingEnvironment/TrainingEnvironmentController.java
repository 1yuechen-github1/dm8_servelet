package org.example.Controller.TrainingEnvironment;

import lombok.extern.slf4j.Slf4j;
import org.example.Mapper.TrainingEnvironmentMapper;
import org.example.common.R;
import org.example.entity.TrainingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Controller
@RequestMapping("/yaml1")
public class TrainingEnvironmentController {

    @Autowired
    private TrainingEnvironmentMapper trainingEnvironmentMapper;

    /**
     * 获取当前存在环境接口
     * **/
    @GetMapping()
    public R getAllTrainingEnvironment(){
        List<TrainingEnvironment> allTrainingEnvironment = trainingEnvironmentMapper.getAllTrainingEnvironment();
//        for (TrainingEnvironment environment : allTrainingEnvironment) {
//            System.out.println(environment);
//        }
        return R.success(allTrainingEnvironment);
    }

    /**
     *管理员上传yaml环境接口
     *
    **/
    @PostMapping("/upload")
    public R insertIntoTrainingEnvironment(@RequestBody TrainingEnvironment trainingEnvironment){
       boolean i= trainingEnvironmentMapper.insertIntoTrainingEnvironment(trainingEnvironment);
       return R.success("新建环境成功");
    }

    /**
     * 删除环境
     * **/
    @GetMapping("/delete")
    public R delTrainingEnvironment(@RequestParam int id){
       boolean i= trainingEnvironmentMapper.delTrainingEnvironment(id);
       return R.success("删除成功");
    }

    /**
     * 更改环境信息
     * **/
    @PostMapping("/update")
    public R updateTrainingEnvironment(@RequestBody TrainingEnvironment trainingEnvironment){
        boolean i=trainingEnvironmentMapper.updateTrainingEnvironment(trainingEnvironment);
        log.info("更改环境信息是否成功: {}", i);
        return R.success("修改成功");
    }


}
