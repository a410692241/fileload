package com.wei.fileload.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;

@Controller
public class FileContrller {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;


    @RequestMapping("/")
    public String hello(Model model){
        return "HelloThymeleaf";

    }
    @RequestMapping("/submit")
    @ResponseBody
    public void submit(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("----图片开始上传----");
        //正常文件上传,如果上传大小有限制,务必在app.yml上进行
        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), "mp3", null);

        //图片上传到FastDFS并保存缩略图
//        StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), "jpg", null);

        System.err.println("图片上传的路径是:"+storePath);
        System.err.println("fullpath:"+storePath.getFullPath());
        System.err.println("group:"+storePath.getGroup());
        System.err.println("path:"+storePath.getPath());
    }
}
