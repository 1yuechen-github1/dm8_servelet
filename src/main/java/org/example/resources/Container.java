package org.example.resources;

import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.custom.IntOrString;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.apis.AutoscalingV1Api;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.*;
import io.kubernetes.client.util.Yaml;
import org.example.config.k8sConfig.K8sInfo;
import org.example.utils.MD5Util;
import org.example.utils.YamlUtil;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class Container {
    private AppsV1Api appsV1Api;
    private CoreV1Api coreV1Api;
    private AutoscalingV1Api autoscalingV1Api;

    public Container(AppsV1Api appsV1Api, CoreV1Api coreV1Api, AutoscalingV1Api autoscalingV1Api) {
        this.appsV1Api = appsV1Api;
        this.coreV1Api = coreV1Api;
        this.autoscalingV1Api = autoscalingV1Api;
    }

    /**
     * 为学生创建指定容器
     * @param yamlContext
     * @param courseName
     * @param className
     * @param studentName
     * @param task
     * @throws ApiException
     */
    public void creatContainerForYaml(String yamlContext, String courseName, String className, String studentName, String task) throws ApiException {
        String courseMD5 = MD5Util.hashString(courseName);
        String classMD5 = MD5Util.hashString(className);
        String studentMD5 = MD5Util.hashString(studentName);
        String taskMD5 = MD5Util.hashString(task);
        String baseName = courseMD5 +
                "-" +
                classMD5 +
                "-" +
                studentMD5+
                "-" +
                taskMD5;
        V1Pod pod = null;
        V1Service service = null;
        V1PersistentVolumeClaim pvc = null;
        V1OwnerReference v1OwnerReference = null;

        Map<String, KubernetesObject> resMap = YamlUtil.loadYaml(yamlContext);
        for (String s : resMap.keySet()) {
            if ("pod".equals(s)) pod = (V1Pod) resMap.get(s);
            else if ("service".equals(s)) service = (V1Service) resMap.get(s);
            else if ("pvc".equals(s)) pvc = (V1PersistentVolumeClaim) resMap.get(s);
        }

        if (pod != null) {
            HashMap<String, String> labels = new HashMap<>();
            labels.put("app", baseName);
            labels.put("course", courseMD5);
            labels.put("class", classMD5);
            labels.put("task", taskMD5);
            pod.getMetadata().name(baseName + "-pod").setLabels(labels);
            if (pvc != null) {
                pod.getSpec().getVolumes().get(0).setPersistentVolumeClaim(new V1PersistentVolumeClaimVolumeSource().claimName(baseName + "-pvc"));
            }
            V1Pod resPod = coreV1Api.createNamespacedPod(K8sInfo.NAMESPACE, pod, null, null, null, null);
            System.out.println(resPod);
            String podUid = resPod.getMetadata().getUid();

            if (pvc != null) {
                pvc.getMetadata().setName(baseName + "-pvc");
                v1OwnerReference = new V1OwnerReference()
                        .apiVersion("v1")
                        .kind("Pod")
                        .name(baseName + "-pod")
                        .uid(podUid);
                pvc.getMetadata().setOwnerReferences(Collections.singletonList(v1OwnerReference));
                coreV1Api.createNamespacedPersistentVolumeClaim(K8sInfo.NAMESPACE, pvc, null, null, null, null);
            }

            //创建service
            if (service != null) {
                service.getMetadata().setName(baseName + "-sv");
                service.getSpec().setSelector(Map.of("app", baseName));
                //设置owner
                if (v1OwnerReference == null) {
                    v1OwnerReference = new V1OwnerReference()
                            .apiVersion("v1")
                            .name(baseName + "-pod")
                            .kind("Pod")
                            .uid(podUid);
                }
                service.getMetadata().setOwnerReferences(Collections.singletonList(v1OwnerReference));
                for (V1ServicePort port : service.getSpec().getPorts()) {
                    port.setTargetPort(new IntOrString(Integer.parseInt(port.getTargetPort().toString())));
                }
                System.out.println(service);
                System.out.println(Yaml.dump(service).toString());
                coreV1Api.createNamespacedService(K8sInfo.NAMESPACE, service, null, null, null, null);
            }

        }

    }

    /**
     * 应用环境yaml文件，为当前学生创建容器
     * @param yamlContext
     * @param className
     * @param courseName
     * @param studentName
     * @return
     */
    public String applyYamlCreatContainer(String yamlContext, String courseName, String className, String studentName, String task) {
        String appName = courseName + "-" + className + "-" + studentName;
        V1Pod pod = null;
        V1Service service = null;
        V1PersistentVolumeClaim pvc = null;
        V1OwnerReference v1OwnerReference = null;


        Map<String, KubernetesObject> resMap = YamlUtil.loadYaml(yamlContext);
        for (String s : resMap.keySet()) {
            if ("pod".equals(s)) pod = (V1Pod) resMap.get(s);
            else if ("service".equals(s)) service = (V1Service) resMap.get(s);
            else if ("pvc".equals(s)) pvc = (V1PersistentVolumeClaim) resMap.get(s);
        }



        try {
            if (pod != null) {
                //创建pod
                HashMap<String, String> labels = new HashMap<>();
                labels.put("app", appName);
                labels.put("course", courseName);
                labels.put("class", className);
                labels.put("task", task);
                pod.getMetadata().name(appName+"-pod").setLabels(labels);
                if (pvc != null) {
                    pod.getSpec().getVolumes().get(0).setPersistentVolumeClaim(new V1PersistentVolumeClaimVolumeSource().claimName(appName + "-pvc"));
                }
                V1Pod resPod = coreV1Api.createNamespacedPod(K8sInfo.NAMESPACE, pod, null, null, null, null);
                System.out.println(resPod);
                String podUid = resPod.getMetadata().getUid();

                //创建pvc
                if (pvc != null) {
                    pvc.getMetadata().name(appName + "-pvc");
                    //设置owner
                    v1OwnerReference = new V1OwnerReference()
                            .apiVersion("v1")
                            .name(appName+"-pod")
                            .kind("Pod")
                            .uid(podUid);
                    pvc.getMetadata().setOwnerReferences(Collections.singletonList(v1OwnerReference));
                    System.out.println(pvc);
                    coreV1Api.createNamespacedPersistentVolumeClaim(K8sInfo.NAMESPACE, pvc, null, null, null, null);

                }

                //创建service
                if (service != null) {
                    service.getMetadata().name(appName + "-sv");
                    service.getSpec().setSelector(Map.of("app", appName));
                    //设置owner
                    if (v1OwnerReference == null) {
                        v1OwnerReference = new V1OwnerReference()
                                .apiVersion("v1")
                                .name(appName + "-pod")
                                .kind("Pod")
                                .uid(podUid);
                    }
                    service.getMetadata().setOwnerReferences(Collections.singletonList(v1OwnerReference));
                    System.out.println(service);
                    coreV1Api.createNamespacedService(K8sInfo.NAMESPACE, service, null, null, null, null);

                }
            }


        } catch (ApiException e) {
            throw new RuntimeException(e);
        }

        return "环境创建成功";
    }

    /**
     * 删除该科目中班级学生的所有容器
     * @param courseName
     * @param className
     * @return
     */
    public boolean deleteContainers(String courseName, String className, String task) throws ApiException {
        String courseMD5 = MD5Util.hashString(courseName);
        String classMD5 = MD5Util.hashString(className);
        String taskMD5 = MD5Util.hashString(task);
        String selector = "course="+courseMD5+",class="+classMD5+",task="+taskMD5;
        System.out.println(selector);
            V1PodList podList = coreV1Api.listNamespacedPod(K8sInfo.NAMESPACE, null, null, null, null, selector, null, null, null, null, null, null);
            System.out.println("delete pod:-------------------------------------------");
            System.out.println(podList.getItems().size());

            for (V1Pod item : podList.getItems()) {
                System.out.println(item.getMetadata().getName());
                coreV1Api.deleteNamespacedPod(item.getMetadata().getName(), K8sInfo.NAMESPACE, null, null, null, null, null, null);
            }
        return true;
    }
}
