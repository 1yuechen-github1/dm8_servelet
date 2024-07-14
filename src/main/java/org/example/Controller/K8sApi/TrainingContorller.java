package org.example.Controller.K8sApi;

import org.example.common.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.annotation.MultipartConfig;
import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingContorller {
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
            //处理图片内容
        }

        //插入实训----------------------------------------------------

        return R.error("创建失败");
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

        return R.error("");
    }

    /**
     * 支持修改实训标题、类型、状态（取消、重新发布）
     * 未开始实训支持修改开始时间和结束时间、环境
     * 已开始实训支持修改结束时间
     * 不支持修改实训内容
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestParam Integer trainingId, @RequestParam String title,
                    @RequestParam Integer environmentId, @RequestParam String startTime,
                    @RequestParam String endTime, @RequestParam String type) {

        return R.error("");
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
