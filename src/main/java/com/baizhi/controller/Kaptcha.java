package com.baizhi.controller;


import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class Kaptcha {
    @Autowired
    private Producer producer;
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response){
        //使用kaptcha验证码工具生成文本内容
        String text = producer.createText();
        //将内容放到作用于中
        session.setAttribute("code",text);
        //使用kaptcha验证码工具生成图片内容
        BufferedImage image = producer.createImage(text);
        try {
            //把生成的图片以流的方式发送给客户端
            ImageIO.write(image,"jpg",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
