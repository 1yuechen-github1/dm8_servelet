package org.example.Controller.K8sApi;

import io.kubernetes.client.openapi.ApiException;
import org.example.resources.FileSys;
import org.example.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RestController
@RequestMapping("/dirs")
public class FileSysController {
    @Autowired
    private FileSys fileSys;

    @PostMapping
    public void getDirs(@RequestParam String path, @RequestParam String podName) throws IOException, ApiException {
//        String podName = MD5Util.getPodName(body.get("course"), body.get("class"), body.get("student"), body.get("task"));
//        System.out.println(podName);
        fileSys.getDirs(podName, path);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam String path,
                             @RequestParam String podName) throws IOException {
        String name = file.getOriginalFilename();
        byte[] bytes = new byte[(int) file.getSize()];
        System.out.println(file.getBytes().length);
        InputStream inputStream = file.getInputStream();
        if (inputStream.read(bytes) == file.getSize()) {
//            String podName = MD5Util.getPodName(course, className, student, task);
            if (fileSys.uploadFile(podName, bytes, path + "/" + name) == -1) {
                return "上传成功";
            }
        }

        return "无法上传该文件";

    }
}
