package org.example.resources;

import io.kubernetes.client.Copy;
import io.kubernetes.client.Exec;
import io.kubernetes.client.openapi.ApiException;
import org.example.config.k8sConfig.K8sInfo;
import org.example.pojo.Directory;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class FileSys {
    public FileSys() {}

    public ArrayList<Directory> getDirs(String podName, String path){
        Exec exec = new Exec();
        ArrayList<Directory> directories = new ArrayList<>();
        Process process = null;

        try {
            process = exec.exec(K8sInfo.NAMESPACE, podName, new String[]{"/bin/sh", "-c", "ls -l " + path + " | grep -v '^total'"}, true, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] dir = line.split("\\s+");
                if (dir[0].charAt(0) == '-') {
                    directories.add(new Directory(dir[8], true));
                }else {
                    directories.add(new Directory(dir[8]));
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        for (Directory directory : directories) {
            System.out.println(directory.toString());
        }
        return directories;
    }

    public int uploadFile(String podName, byte[] bytes, String path) {
        Copy copy = new Copy();
        try {
//            System.out.println("开始上传");
//            copy.copyFileToPod(K8sInfo.NAMESPACE, podName, null, bytes, Paths.get(path));
//            return true;
            Future<Integer> future = copy.copyFileToPodAsync(K8sInfo.NAMESPACE, podName, null, bytes, Paths.get(path));
            Integer i = future.get(1, TimeUnit.SECONDS);
            System.out.println(i);
            return i;

        } catch (ApiException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

    }
}
