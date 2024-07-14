package org.example.utils;


import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.openapi.models.V1PersistentVolumeClaim;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1Service;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class YamlUtil {
    private static Yaml yaml;

    public YamlUtil(Yaml yaml) {
        YamlUtil.yaml = yaml;
    }

    /**
     * 判断由前端上传的yaml内容是否符合格式和k8s对象内容
     * @param yamlContext 前端json字符串
     */
    public static boolean isYaml(String yamlContext) {
        return !YamlUtil.loadYaml(yamlContext).isEmpty();
    }


    /**
     * yaml字符串转k8s资源
     * @param yamlContext yaml字符串
     * @return 根据yaml转换成pod、service、pvc对象，如果存在定义则放进map对象中返回
     */
    public static Map<String, KubernetesObject> loadYaml(String yamlContext) {
        HashMap<String, KubernetesObject> map = new HashMap<>();
        Iterable<Object> objects = yaml.loadAll(yamlContext);

        List<Object> objectList = new ArrayList<>();
        objects.forEach(objectList::add);

        for (Object doc : objectList) {
            if (doc instanceof Map<?, ?>) {
                Map<String, Object> docMap = (Map<String, Object>) doc;
                if (docMap.containsKey("kind") && "Pod".equals(docMap.get("kind"))) {
                     map.put("pod", yaml.loadAs(yaml.dump(docMap), V1Pod.class));
                } else if (docMap.containsKey("kind") && "Service".equals(docMap.get("kind"))) {
                    map.put("service", yaml.loadAs(yaml.dump(docMap), V1Service.class));
                } else if (docMap.containsKey("kind") && "PersistentVolumeClaim".equals(docMap.get("kind"))) {
                    map.put("pvc", yaml.loadAs(yaml.dump(docMap), V1PersistentVolumeClaim.class));
                }
            }
        }

        return map;
    }
}