package com.gong.securitydemosecond.filter;

import com.gong.securitydemosecond.controller.ValidateCodeController;
import com.gong.securitydemosecond.domain.ImageCode;
import com.gong.securitydemosecond.exception.ValidateCodeException;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GEEX616
 * @create 2019-09-11 13:05
 * @desc
 **/
@Data
public class ValidateCodeFilter extends OncePerRequestFilter {
    private AuthenticationFailureHandler authenticationFailureHandler;
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("当前的请求方式为：{}"+request.getMethod());
        logger.info("当前的请求路径为："+request.getRequestURI());
        //判断是否是登陆且是否为post请求,如果是的话需要进行图形验证码进行校验
        if (StringUtils.equals("/authentication/form", request.getRequestURI())
                && StringUtils.equalsIgnoreCase(request.getMethod(), "POST")) {
            try {
                //对输入的图形验证码进行校验
                validate(new ServletWebRequest(request));
            } catch (ValidateCodeException ex) {
                //认证失败调用之前写的认证失败的逻辑
                authenticationFailureHandler.onAuthenticationFailure(request, response, ex);
                return;
            }
        }
        //走到这里说明已经校验成功,对请求放行
        filterChain.doFilter(request, response);
    }

    /**
     * 对输入的图形验证码的校验逻辑
     *
     * @param request
     * @throws ServletRequestBindingException
     */
    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        //1.从session中取出ImageCode对象
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request,
                ValidateCodeController.SESSION_KEY);
        //2.获取请求中传过来的图形验证码字符串
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");

        //3.判断传过来的图形验证码字符串和session中存的是否相同
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }

        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }

        if (codeInSession.isExpried()) {
            sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
            throw new ValidateCodeException("验证码已过期");
        }

        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }
        //4.走到这里说明校验已经通过,校验通过后该验证码就没啥用了,所以可以删除session中的ImageCode对象了
        sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
    }

}
