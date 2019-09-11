package com.gong.securitydemosecond.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author GEEX616
 * @create 2019-09-11 13:36
 * @desc  成功处理器
 **/
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler  extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        System.out.println("自定义成功处理逻辑--------------------------");

        //创建一个SecurityContext对象，并且设置上一步得到的Authentication
        SecurityContextHolder.getContext().setAuthentication(authentication);
        HttpSession session = request.getSession();

        //将上一部得到的SecurityContext对象放入session中。到此，自定义用户信息的处理已经完成
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        System.out.println("--------------结束认证");
        System.out.println("将用户信息存储在session中");

        super.setDefaultTargetUrl("/index"); // 设置默认登陆成功的跳转地址
        super.onAuthenticationSuccess(request, response, authentication);

    }

}
