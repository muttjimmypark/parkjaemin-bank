package studio.aroundhub.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// 본 클래스가 포함하는 메서드들은 @ResponseBody를 붙인것처럼 ret값을 전송할수 있게된다
// @Controller + @ResponseBody = @RestController
@RestController
public class HelloController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("hello")
    public String hello() {
        return "Hello, World!";
    }
}
