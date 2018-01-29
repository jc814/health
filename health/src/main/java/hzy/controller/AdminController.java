package hzy.controller;

import hzy.dto.AdminDTO;
import hzy.entity.Admin;
import hzy.service.IAdminSer;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.ConvertClass;
import utils.JwtUtils;
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
            String tokenName = JwtUtils.createMd5(JwtUtils.encrypt(one.getId(),one.getName()));
            AdminDTO adminDTO = ConvertClass.PojoToDto(one, AdminDTO.class);
            adminDTO.setNameForToken(tokenName);
            Key key = MacProvider.generateKey();
            //产生令牌
            String token = JwtUtils.createToken(one.getName(), adminDTO);
            result = new Result(true, one);
            result.setToken(token);
        }else{
            result = new Result(false);
        }
        return result;
    }
}
