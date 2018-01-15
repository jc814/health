package hzy.controller;

import hzy.service.IPersonSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("person")
/**
 * PersonController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class PersonController {
    @Autowired
    private IPersonSer personSer;
}
