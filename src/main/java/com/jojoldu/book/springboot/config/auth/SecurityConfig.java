package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 기능 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable()
                .and()
                    .authorizeRequests()//url별 권한 관리 설정(antMatchers의 시작점)
                    .antMatchers("/","/css/**","/image/**","/js/**","/h2-console/**") // 권한 관리대상 지정
                        .permitAll()
                    .antMatchers("/api/v1/**")
                        .hasRole(Role.USER.name())
                    .anyRequest() //설정된 값 이외 나머지 URL
                        .authenticated() // 인증된 사용자만 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()// OAuth2 로그인 기능 설정
                        .userInfoEndpoint()//로그인 성공 이후의 설정
                            .userService(customOAuth2UserService);
    }
}
