package org.example.utils;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1PersistentVolumeClaim;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1Service;
import org.example.config.k8sConfig.K8sInfo;

public class Utils {
    private static CoreV1Api coreV1Api = new CoreV1Api();


    public static V1Pod existingPod(String podName){
        try {
            return coreV1Api.readNamespacedPod(podName, K8sInfo.NAMESPACE, null);
        } catch (ApiException e) {
            return null;
        }
    }

    public static V1Service existingService(String serviceName){
        try {
            return coreV1Api.readNamespacedService(serviceName, K8sInfo.NAMESPACE, null);
        } catch (ApiException e) {
            return null;
        }
    }

    public static V1PersistentVolumeClaim existingPVC(String pvcName){
        try {
            return coreV1Api.readNamespacedPersistentVolumeClaim(pvcName, K8sInfo.NAMESPACE, null);
        } catch (ApiException e) {
            return null;
        }
    }
}
