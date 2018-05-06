package hello.controllers;

import hello.pojo.Greeting;
import hello.pojo.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws InterruptedException {
//        Thread.sleep(1000);
        return new Greeting("Hello," + message.getName() + "!");
    }

    @RequestMapping({"/", "/index"})
    public ModelAndView indexPage(){
        return new ModelAndView("greetings.html");
    }
}
