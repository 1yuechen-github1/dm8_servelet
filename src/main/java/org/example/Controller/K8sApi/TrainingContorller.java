package org.example.Controller.K8sApi;

import lombok.extern.slf4j.Slf4j;
import org.example.Mapper.TrainingEnvironmentMapper;
import org.example.Service.TrainingEnvironmentService;
import org.example.common.R;
import org.example.entity.TeacherTrainingEnvironment;
import org.example.entity.TrainingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/training")
public class TrainingContorller {

    @Autowired
    private TrainingEnvironmentService trainingEnvironmentService;

    String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/pic/";


    /**
     * 创建实训
     * @param content 实训内容以多图片形式上传
     * @param title
     * @param courseId
     * @param teacherId
     * @param environmentId
     * @param startTime
     * @param endTime
     * @param type
     * @return
     */
    @PostMapping
    public R create(@RequestParam List<MultipartFile> content, @RequestParam String title,
                    @RequestParam Integer courseId, @RequestParam Integer teacherId,
                    @RequestParam Integer environmentId, @RequestParam String startTime,
                    @RequestParam String endTime, @RequestParam String type) {
        for (MultipartFile multipartFile : content) {
            try {
                // 保存文件
                saveFile(multipartFile, uploadDir);
            } catch (IOException e) {
                log.error("Failed to save file: {}", multipartFile.getOriginalFilename(), e);
                return R.error("文件保存失败: " + multipartFile.getOriginalFilename());
            }
        TeacherTrainingEnvironment trainingEnvironment =new TeacherTrainingEnvironment();
        trainingEnvironment.setTitle(title);
        trainingEnvironment.setType(type);
        trainingEnvironment.setTeacherId(teacherId);
        trainingEnvironment.setCourseId(courseId);
        trainingEnvironment.setEnvironmentId(environmentId);
        trainingEnvironment.setStartTime(startTime);
        trainingEnvironment.setEndTime(endTime);
        trainingEnvironment.setContent("pic/"+multipartFile.getOriginalFilename());
        //插入实训----------------------------------------------------
        boolean i= trainingEnvironmentService.createPracticalTraining(trainingEnvironment);
        log.info( multipartFile.getOriginalFilename()+"{}创建实训是否成功{}",i);
        }return R.error("创建成功");
    }

    private void saveFile(MultipartFile file, String uploadDir) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("文件为空");
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();

        // 目标路径
        Path path = Paths.get(uploadDir + fileName);

        // 检查目录是否存在，不存在则创建
        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }

        // 保存文件
        Files.write(path, file.getBytes());
    }

    /**
     * 查找实训
     * @param courseId
     * @param trainingId
     * @param type
     * @return
     */
    @GetMapping
    public R select(@RequestParam(required = false) Integer courseId, @RequestParam(required = false) Integer trainingId,
                    @RequestParam(required = false) String type) {

        //查找实训------------------------------------------------------
        TeacherTrainingEnvironment trainingEnvironment=trainingEnvironmentService.getAllTeacherTrainingEnvironment(courseId,trainingId,type);
        if (trainingEnvironment!=null){
            return R.success(trainingEnvironment);
        }
        //查询全部实训
        else {
            List<TeacherTrainingEnvironment> teacherTrainingEnvironments= trainingEnvironmentService.getAllTeacherTrainingEnvironments();
            return R.success(teacherTrainingEnvironments);
        }
    }

    /**
     * 支持修改实训标题、类型、状态（取消、重新发布）
     * 未开始实训支持修改开始时间和结束时间、环境
     * 已开始实训支持修改结束时间
     * 不支持修改实训内容
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestParam int trainingId, @RequestParam(required = false)  String title,
                    @RequestParam(required = false)  int environmentId, @RequestParam(required = false)  String startTime,
                    @RequestParam(required = false)  String endTime, @RequestParam(required = false) String type) {
        TeacherTrainingEnvironment trainingEnvironment=new TeacherTrainingEnvironment();
        trainingEnvironment.setId(trainingId);
        trainingEnvironment.setTitle(title);
        trainingEnvironment.setEnvironmentId(environmentId);
        trainingEnvironment.setStartTime(startTime);
        trainingEnvironment.setEndTime(endTime);
        trainingEnvironment.setType(type);
        boolean i= trainingEnvironmentService.updateTeacherTrainingEnvironment(trainingEnvironment);
        if (i==true){
            return R.success("更新成功");
        }
        return R.error("更新失败");
    }

    /**
     * 返回实训内容图片
     * @param photoId
     * @return
     */
    @GetMapping("/training/{photoId}")
    public byte[] getContent(@PathVariable Integer photoId) {

        return null;
    }

    /**
     * 获取当前实训的所有作业提交情况
     * @param trainingId
     * @return
     */
    @GetMapping("/achievement")
    public R getAchievement(@RequestParam Integer trainingId) {

        return R.error("");
    }

    /**
     * 提交实训作业
     * @param files
     * @param trainingId
     * @param studentId
     * @return
     */
    @PostMapping("/achievement/submit")
    public R submit(@RequestParam List<MultipartFile> files, @RequestParam Integer trainingId,
                    @RequestParam Integer studentId) {

        return R.error("");
    }

    /**
     * 返回提交的作业内容
     * @param submitId
     * @return
     */
    @GetMapping("/achievement/show")
    public R show(@RequestParam Integer submitId) {

        return R.error("");
    }

    /**
     * 打分
     * @param submitId
     * @param score
     * @return
     */
    @PostMapping("/achievement/score")
    public R score(@RequestParam Integer submitId, @RequestParam Integer score) {

        return R.error("");
    }
}
