package org.example.Controller.K8sApi;

import lombok.extern.slf4j.Slf4j;
import org.example.Mapper.TrainingEnvironmentMapper;
import org.example.Service.TrainingEnvironmentService;
import org.example.common.R;
import org.example.entity.TrainingEnvironment;
import org.example.utils.YamlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/yaml")
public class YamlController {

    @Autowired
    private TrainingEnvironmentService trainingEnvironmentService;

    String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/icon/";


    /**
     * 上传yaml环境
     * @param
     * @return
     */
    @PostMapping("/upload")
    public R upload(@RequestParam String environmentName,
                    @RequestParam String environmentIntroduction,
                    @RequestParam String content,
                    @RequestParam String creator,
                    @RequestParam MultipartFile icon) {
        //判断yaml内容是否合法
        if (!YamlUtil.isYaml(content)) {
            return R.error("yaml文件无法创建资源");
        }
        try {
            // 保存文件
            saveFile(icon, uploadDir);
        } catch (IOException e) {
            log.error("Failed to save file: {}", icon.getOriginalFilename(), e);
            return R.error("文件保存失败: " + icon.getOriginalFilename());
        }

        TrainingEnvironment trainingEnvironment =new TrainingEnvironment();
        trainingEnvironment.setEnvironmentName(environmentName);
        trainingEnvironment.setEnvironmentIntroduction(environmentIntroduction);
        trainingEnvironment.setContent(content);
        trainingEnvironment.setCreator(creator);
        trainingEnvironment.setIcon("pic/"+icon.getOriginalFilename());
        //调用service上传到数据库----------------------------------------
        boolean i= trainingEnvironmentService.insertIntoTrainingEnvironment(trainingEnvironment);
        if (i==true){
            return R.success("上传成功");
        }
        return R.error("上传失败");
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
     * 获取环境内容，环境id为空时返回所有环境对象
     * @param environmentId 环境id
     * @return
     */
    @GetMapping
    public R getEnvironmentList(@RequestParam(value = "environmentId", required = false) Integer environmentId) {
        if (environmentId != null) {
            //返回该id的单个环境对象--------------------------------------------------------
            TrainingEnvironment trainingEnvironment= trainingEnvironmentService.getTrainingEnvironmentById(environmentId);
            return R.success(trainingEnvironment);
        }
        else {
            //返回所有环境对象列表------------------------------------------------------
            List<TrainingEnvironment> allTrainingEnvironment = trainingEnvironmentService.getAllTrainingEnvironment();
            return R.success(allTrainingEnvironment);
        }
    }

    /**还未debug
     * 更改环境信息
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestBody TrainingEnvironment trainingEnvironment) {
        //修改环境数据--------------------------------------------------------
        boolean i=trainingEnvironmentService.updateTrainingEnvironment(trainingEnvironment);
        log.info("更改环境信息是否成功: {}", i);
        if (i==true){
            return R.success("修改成功");
        }return R.error("修改失败");
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public R delete(@RequestParam int id) {
        //删除环境------------------------------------------------------
        boolean i= trainingEnvironmentService.delTrainingEnvironment(id);
        if (i==true){
            return R.success("删除成功");
        }return R.error("删除失败");
    }
}
