package com.jojoldu.book.springboot.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON을 반환하는 컨트롤러로 만들어준다.
public class HelloController {
    /* Get 요청을 받는 메소드
    "/hello" 요청이 오면 문자열 "hello"를 반환하게 된다.*/
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
