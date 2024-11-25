package com.mycompany.mvcproject.controller;

import com.mycompany.mvcproject.domain.SendEmailRequest;
import com.mycompany.mvcproject.service.EmailServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/email")
public class EmailController {

    // 필드 주입
 //   @Autowired
 //   private EmailServiceClient emailServiceClient;
    private final EmailServiceClient emailServiceClient;

    @Autowired //생성자 주입: 권장
    public EmailController(EmailServiceClient emailServiceClient){
        this.emailServiceClient = emailServiceClient;
    }

//    @Autowired // 세터 주입
//    public void setEmailServiceClient(EmailServiceClient emailServiceClient){
//        this.emailServiceClient = emailServiceClient;
//    }

    // http://localhost:8080/email/sendEmail
    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail() {
        SendEmailRequest sendEmailRequest = generateEmailRequest();
        emailServiceClient.sendEmail(sendEmailRequest);
        return "Success";
    }

    public SendEmailRequest generateEmailRequest(){
        // 간단한 이메일 요청 객체 생성
        SendEmailRequest request = new SendEmailRequest();
        request.setToAddress("test@example.com");
        request.setSubject("test subject");
        request.setBody("This is a test email.....");
        return request;
    }
}
