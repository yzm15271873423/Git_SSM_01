package com.yzm.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: yzm
 * @Date: 2021/5/20 - 05 - 20 - 16:57
 * @Description: com.yzm.controller
 * @version: 1.0
 */
@Controller
public class FileController {

    private final static String FILESERVER="http://127.0.0.1:8090/upload/";

    @ResponseBody
    @RequestMapping("fileUpload")
    public Map<String,String> fileUpload(MultipartFile headPhoto, HttpServletRequest req) throws IOException {
        Map<String,String> map = new HashMap<>();

        //控制文件大小
        /*if (headPhoto.getSize()>1024*50){
            map.put("message","上传文件大小不能超过50kb");
            return map;
        }*/

        //指定文件储存目录 为我们项目部署名下的目录
       /* String realPath = req.getServletContext().getRealPath("/upload");
        File dir = new File(realPath);*/
        //如果目录不存在就创建目录
       /* if(!dir.exists()){
            dir.mkdirs();
        }*/
        //获取文件名
        String filename = headPhoto.getOriginalFilename();

        //避免文件名冲突,使用UUID替换文件名
        String uuid = UUID.randomUUID().toString();
        //获取扩展名
        String extendsname = filename.substring(filename.lastIndexOf("."));

        //判断文件扩展名是否是.jpg类型
       /* if(!extendsname.equals(".jpg")){
            map.put("message","上传的文件必须是.jgp文件");
            return map;
        }*/

        //新的扩展名
        String newFileName = uuid+extendsname;
        //创建 sun公司提供的jersey包中的client对象
        Client client = Client.create();
        WebResource resource = client.resource(FILESERVER + newFileName);
        //文件保存到另一个服务器上
        resource.put(String.class,headPhoto.getBytes());

        //上传成功后，把文件的名字和文件的类型返回给浏览器
        map.put("message","上传成功");
        map.put("newName",newFileName);
        map.put("filetype",headPhoto.getContentType());

        return map;
    }

    @RequestMapping("fileDownload.do")
    public void fileDownload(String photo, String filetype, HttpServletResponse resp) throws IOException {
        //设置响应头
        //告诉浏览器将数据保存在磁盘上，不要直接解析
        resp.setHeader("Content-Disposition","attachment;filename="+FILESERVER);
        //告诉浏览器下载的文件类型
        resp.setContentType(filetype);
        //获取一个文件输入流
        InputStream inputStream = new URL(FILESERVER + photo).openStream();
        //获取一个指向浏览器的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //向浏览器响应数据
        IOUtils.copy(inputStream,outputStream);

    }

}
















