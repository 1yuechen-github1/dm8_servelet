package org.example.Controller.K8sApi;

import io.kubernetes.client.openapi.models.V1Pod;
import org.example.common.R;
import org.example.resources.Container;
import org.example.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/container")
public class ContainerContraller {
    @Autowired
    Container container;
    @GetMapping("/check")
    public R check(@RequestParam Integer courseId, @RequestParam Integer classId,
                   @RequestParam Integer studentId, @RequestParam Integer trainingId) {

        //检查容器是否存在 不存在则创建
        if (Utils.existingPod(courseId.toString(), classId.toString(), studentId.toString(), trainingId.toString()) == null) {
            //根据实训id查找yaml--------------------------------------------------------

            //创建环境
//            container.creatContainerForYaml();

            return R.success("");
        }

        return R.error("");
    }
}
