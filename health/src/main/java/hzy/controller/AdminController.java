package hzy.controller;

import hzy.service.IAdminSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
