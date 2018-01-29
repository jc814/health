package hzy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utils.JsonUtils;
import utils.JwtUtils;
import utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * TokenInterceptor class
 * 
 * @author hzy
 * @date 2016/10/31
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String authorization =  httpServletRequest.getHeader("Authorization");
        if(authorization == null || "".equals(authorization)){
            return true;
        }
        Result result = JwtUtils.verifyToken(authorization);
        PrintWriter pw = httpServletResponse.getWriter();
        pw.write(JsonUtils.toJson(result));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
