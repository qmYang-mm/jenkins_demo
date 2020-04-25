package com.msg.duanxin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
//import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class sendSms {

    @Autowired
    private HttpServletRequest httpRequest;

    @RequestMapping("/sendSms")
    @ResponseBody
    public Object sendSms(String number) {
        try {
            JSONObject json = null;
            //生成6位验证码
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            //发送短信
            ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com","103591","76b77ac8-1c31-426c-a987-98b48571ce2a");
            String result = client.send(number, "您的验证码为:" + verifyCode + "，该码有效期为5分钟，该码只能使用一次！短信签名");
            json = JSONObject.parseObject(result);
            if(json.getIntValue("code") != 0)//发送短信失败
                return "fail";
            //将验证码存到session中,同时存入创建时间
            //以json存放，这里使用的是阿里的fastjson
            HttpSession session = httpRequest.getSession();
            json = new JSONObject();
            json.put("verifyCod0e", verifyCode);
            json.put("createTime", System.currentTimeMillis());
            // 将认证码存入SESSION
            httpRequest.getSession().setAttribute("verifyCode", json);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("accpect")
    @ResponseBody
    public String accept(){
        System.out.println("成功");
        return "chenggong";
    }

}
