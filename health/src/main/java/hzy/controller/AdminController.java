package hzy.controller;

import hzy.entity.Admin;
import hzy.service.IAdminSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

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
            result = new Result(true, one);
        }else{
            result = new Result(false);
        }
        return result;
    }
}
