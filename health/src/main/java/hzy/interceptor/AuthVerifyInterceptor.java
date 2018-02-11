package hzy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 权限校验
 *
 * @author hzy
 * @date 2018/02/06
 */
public class AuthVerifyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String authorization =  httpServletRequest.getHeader("Authorization");
        Map<String,Integer> map =  JwtUtils.verifyAuth(authorization);
        // 普通管理员
        if(map.get("type").equals(0)){
            return true;
        //超级管理员
        }else if(map.get("type").equals(1)){
            return true;
        // 普通人员
        }else {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
