package com.yibuyiyin.restful.config;

import com.alibaba.fastjson.JSON;
import com.yibuyiyin.restful.enums.common.error.ErrorInfo;
import com.yibuyiyin.restful.model.common.ResultModel;
import lombok.var;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 拦截无session访问
 *
 * @author peng.yu
 */
@Configuration
class SessionCofig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SecurityInterceptor())
//                //排除拦截
//                .excludePathPatterns("/user/login")
//                .excludePathPatterns("/user/logout")
//
//                //拦截路径
//                .addPathPatterns("/**");
    }

    @Configuration
    public class SecurityInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
            HttpSession session = request.getSession();
            if (session.getAttribute(session.getId()) != null){
                return true;
            }
            var ret = new ResultModel();
            ret.setStatus(HttpStatus.UNAUTHORIZED);
            ret.failure(ErrorInfo.UNAUTHORIZED);
            response.getWriter().write(JSON.toJSONString(ret));
            return false;
        }
    }
}
