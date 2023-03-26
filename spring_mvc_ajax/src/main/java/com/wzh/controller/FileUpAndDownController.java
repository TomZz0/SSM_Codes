package com.wzh.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author wzh
 * @date 2023年03月25日 14:26
 * Description:
 * 文件下载
 * ResponseEntity<byte[]>控制器方法的返回值 表示响应到浏览器的完整的相应报文
 * 控制器方法如果返回为空 则会跳转到以@RequestMapping("/test/down")中的值为逻辑视图
 * 的页面
 * 文件上传
 * form表单必须设置属性enctype="multipart/form-date" 表示以二进制的形式上传
 * 表单必须以post方式请求
 */
@Controller
public class FileUpAndDownController {
    @RequestMapping("/test/up")
    //SpringMVC封装上传的文件成一个MultipartFile对象
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        //获取要上传文件的文件名
        String filename = photo.getOriginalFilename();
        //获取上传文件的后缀名 .xxx
        String hzName = filename.substring(filename.lastIndexOf("."));
        //获取uuid
        String uuid = UUID.randomUUID().toString();
        //拼接一个新的文件名
        filename = uuid + hzName;
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取当前工程下photo目录的真实路径
        String photoPath = servletContext.getRealPath("photo");
        //创建路径对应的File对象
        File file = new File(photoPath);
        //如果不存在 创建目录
        if (!file.exists()) file.mkdir();
        //创建上传目录
        String finalPath = photoPath + File.separator + filename;
        //上传文件
        photo.transferTo(new File(finalPath));
        return "success";
    }

    @RequestMapping("/test/download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws
            IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        //  将传入的值拼接在D:\SpringGoods\2022SSM\ssm_stu\spring_mvc_ajax
        //  \target\spring_mvc_ajax-1.0-SNAPSHOT后边
        String realPath = servletContext.getRealPath("img");
        // File.separator是路径分隔符 不清楚是/或\时 可以使用
        realPath = realPath + File.separator + "1.JPG";
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }
}
