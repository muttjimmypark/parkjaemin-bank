package studio.aroundhub.application.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

// 본 클래스가 포함하는 메서드들은 @ResponseBody를 붙인것처럼 ret값을 전송할수 있게된다
// @Controller + @ResponseBody = @RestController
@RestController
@RequestMapping("/v1") //동일 관심사를 다루는 컨트롤러라면 상위에서 명명할수 있음
@Slf4j
public class HelloController {

//    private final Logger logger = LoggerFactory.getLogger("HelloController");

    //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "hello world 예제", notes = "RestController, GetMapping을 처음 사용해보는 예제")
    @GetMapping("hello")
    public String hello() {
//        logger.info("hello method");
        log.info("hello method");
        return "Hello, World!";
    }

    @GetMapping("/hello/{text}")
    public String hello2(@PathVariable String text) {
        //log의 여러 활용 예시
//        logger.info(text);
//        logger.info("input data : {}", text);
//        logger.info("input data : {} {}", text, "text : " + text);
        log.info(text);
        log.info("input data : {}", text);
        log.info("input data : {} {}", text, "text : " + text);
        return "hello";
    }

    @PostMapping("/add")
    public String add(int amount) {

        // 입금 로직

        return "success";
    }

    @PostMapping("/v2/add") //버전을 상위경로에 명명하면, 이 메서드는 v2 컨트롤러로 가서 붙어야할듯
    public String add2(String accountType, int amount) {
        /**
         * 기능요구사항이 추가되어 버전업 하는 상황을 가정한 메서드
         */

        // 입금 로직

        return "success";
    }
}
