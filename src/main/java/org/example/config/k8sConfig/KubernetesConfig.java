package org.example.config.k8sConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.apis.AutoscalingV1Api;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class KubernetesConfig {



    @Bean
    public ApiClient apiClient() throws IOException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("kubeconfig");
        ApiClient apiClient = null;
        if (resourceAsStream != null) {
            apiClient = Config.fromConfig(resourceAsStream);
        }else {
            apiClient = Config.defaultClient();
        }

        io.kubernetes.client.openapi.Configuration.setDefaultApiClient(apiClient);
        return apiClient;
    }

    @Bean
    public AppsV1Api appsV1Api(ApiClient apiClient) {
        return new AppsV1Api(apiClient);
    }

    @Bean
    public CoreV1Api coreV1Api(ApiClient apiClient) {
        return new CoreV1Api(apiClient);
    }

    @Bean
    public AutoscalingV1Api autoscalingV1Api(ApiClient apiClient) {
        return new AutoscalingV1Api(apiClient);
    }

    @Bean
    public Yaml yaml() {
        return new Yaml();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().create();
    }

}
