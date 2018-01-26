package hzy.controller;

import hzy.entity.Admin;
import hzy.service.IAdminSer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

import java.security.Key;

@Controller
@RequestMapping("admin")
/**
 * AdminController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class AdminController {
    @Autowired
    private IAdminSer adminSer;

    @RequestMapping("adminLogin")
    @ResponseBody
    public Result adminLogin(Admin admin){
        Result result ;
        Admin one = adminSer.selectAdminByNameAndPsd(admin);
        if(one != null){
            Key key = MacProvider.generateKey();
            //产生令牌
            String token = Jwts.builder()
                    .setSubject(one.getName())
                    .signWith(SignatureAlgorithm.HS512, key)
                    .compact();
            result = new Result(true, one);
            result.setToken(token);
        }else{
            result = new Result(false);
        }
        return result;
    }
}
