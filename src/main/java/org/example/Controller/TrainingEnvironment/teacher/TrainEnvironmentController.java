package org.example.Controller.TrainingEnvironment.teacher;

import lombok.extern.slf4j.Slf4j;
import org.example.Mapper.TrainingEnvironmentMapper;
import org.example.common.R;
import org.example.entity.TeacherTrainingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Controller
@RequestMapping("/training1")
public class TrainEnvironmentController {

    @Autowired
    private TrainingEnvironmentMapper trainingEnvironmentMapper;

    /**
     * 教师 创建实训
     * **/
    @PostMapping()
    public R createPracticalTraining(@RequestBody TeacherTrainingEnvironment trainingEnvironment){
       boolean i= trainingEnvironmentMapper.createPracticalTraining(trainingEnvironment);
       log.info("创建实训是否成功{}",i);
       return R.success("创建实训成功");
    }
}
