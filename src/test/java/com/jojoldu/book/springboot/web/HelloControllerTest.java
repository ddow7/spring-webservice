package com.jojoldu.book.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // JUnit에 내장된 실행자 외에 다른 실행자를 실행, 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) // 스프링 테스트 어노테이션, Web(MVC)에 집중하게 해줌
public class HelloControllerTest {

    @Autowired // 빈 주입
    private MockMvc mvc; // 웹 API 테스트시 사용, MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청
            .andExpect(status().isOk()) // 체이닝을 통해 mvc.perform 결과를 검증, 200,404 등의 상태 점검
            .andExpect(content().string(hello)); // mvc.perform 결과를 검증, 응답 본문 내용 검증
    }
}
