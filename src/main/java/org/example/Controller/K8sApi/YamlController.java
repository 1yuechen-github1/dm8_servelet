package org.example.Controller.K8sApi;

import org.example.common.R;
import org.example.utils.YamlUtil;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/yaml")
public class YamlController {
    /**
     * 上传yaml环境
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public R upload(MultipartHttpServletRequest request) {
        String Name = request.getParameter("environmentName");
        String Introduction = request.getParameter("environmentIntroduction");
        String creator = request.getParameter("creator");
        String content = request.getParameter("content");
        //判断yaml内容是否合法
        if (!YamlUtil.isYaml(content)) {
            return R.error("yaml文件无法创建资源");
        }

        try {
            Part icon = request.getPart("icon");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        //调用service上传到数据库----------------------------------------

        return R.success(null);
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

            return null;
        }
        //返回所有环境对象列表------------------------------------------------------

        return null;
    }

    /**
     * 更改环境信息
     * @return
     */
    @PostMapping("/update")
    public R update() {
        //修改环境数据--------------------------------------------------------

        return R.error("修改失败");
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public R delete(@RequestParam Integer id) {
            //删除环境------------------------------------------------------

        return R.error("删除失败");
    }
}
