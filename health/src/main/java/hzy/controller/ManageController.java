package hzy.controller;

import hzy.service.IManageSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manage")
/**
 * DoctorController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class ManageController {
    @Autowired
    private IManageSer manageSer;
}
