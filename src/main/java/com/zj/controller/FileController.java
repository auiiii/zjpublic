package com.zj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class FileController {

    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public String upload(MultipartFile file) {

        try {
            System.out.println(file.getOriginalFilename());
            file.transferTo(new File("/E:/pic/" + file.getOriginalFilename()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success.jsp";
    }


    @RequestMapping(value="/download", method=RequestMethod.GET)
    public String download(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition","attachment;filename=a.jpg");
        response.setContentType("image/jpeg");
        FileInputStream inputStream = new FileInputStream("/E:/pic/2.jpg");
        OutputStream writer  = response.getOutputStream();
        byte[] b = new byte[1024];
        int length = 0;
        while((length=inputStream.read(b,0,b.length))>0)
        {
            writer.write(b);
            writer.flush();
        }
        inputStream.close();
        writer.close();
        return "success.jsp";
    }


}
