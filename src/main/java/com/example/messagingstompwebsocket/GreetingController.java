package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")  //hello로 메세지가 보내질 경우 greeting 메소드 실행
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {  //메세지가 HelloMessage에 바인딩 됨
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}