package com.gong.securitydemosecond.filter;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GEEX616
 * @create 2019-09-11 13:38
 * @desc  失败处理器
 **/
@Component(value = "myAuthenticationFailHandler")
public class MyAuthenticationFailHandler  extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
        log.info("登录失败:" + exception.getMessage());
        log.info("username=>" + request.getParameter("username"));

        super.onAuthenticationFailure(request, response, exception);


//        if (this.defaultFailureUrl == null) {
//            this.logger.debug("No failure URL set, sending 401 Unauthorized error");
//            response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
//        } else {
//            this.saveException(request, exception);
//            if (this.forwardToDestination) {
//                this.logger.debug("Forwarding to " + this.defaultFailureUrl);
//                request.getRequestDispatcher(this.defaultFailureUrl).forward(request, response);
//            } else {
//                this.logger.debug("Redirecting to " + this.defaultFailureUrl);
//                this.redirectStrategy.sendRedirect(request, response, this.defaultFailureUrl);
//            }
//        }

    }
}
