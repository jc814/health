package hzy.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utils.JsonUtils;
import utils.JwtUtils;
import utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 校验token的方法
 * 
 * @author hzy
 * @date 2016/10/31
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String authorization =  httpServletRequest.getHeader("Authorization");
        Result result = JwtUtils.verifyToken(authorization);
        // 在response中添加返回参数
        httpServletResponse.setContentType("application/json");
        PrintWriter out = httpServletResponse.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonOfRST = JsonUtils.toJson(result);
        out.print(jsonOfRST);
        out.flush();
        // 判断result中success的值，验证失败返回false
        if(result.getSuccess()){
            return true;
        }else{
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
