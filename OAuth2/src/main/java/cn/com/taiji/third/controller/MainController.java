package cn.com.taiji.third.controller;


import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cn.com.taiji.third.domain.Msg;
import cn.com.taiji.third.service.SmsCodeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 主页控制器.
 */
@Controller

public class MainController {
	
	@Autowired
    SmsCodeService smsCodeService;
//    @Autowired
//    MobileSendMessage mobileSendMessage;
    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，用户名或者密码错误！");
        return "login";
    }

    @GetMapping("/403")
    public String accesssDenied() {
        return "403";
    }

    //邮箱验证
    @GetMapping("/code/email")
    public void createEmailCode(HttpServletRequest request, HttpServletResponse response, String mobile){
        String code = RandomStringUtils.randomNumeric(6);
        System.out.println("您输入的邮箱为："+mobile);
        send(mobile,code);
        smsCodeService.setCode(code);
        
    }
    @GetMapping("/code/clearSms")
    public void clearSmsCode(HttpServletRequest request, HttpServletResponse response){
        smsCodeService.setCode("");
    }
    @Autowired
    JavaMailSender jms;


    public void send(String setTo,String Code){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("1358080913@qq.com");
        //接收者
        mainMessage.setTo(setTo);
        //发送的标题
        mainMessage.setSubject("验证码");
        //发送的内容
        mainMessage.setText("您的验证码为："+Code);
        jms.send(mainMessage);

    }

}
