package hzy.controller;

import hzy.service.IDoctorSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("doctor")
/**
 * DoctorController class
 *
 * @author hzy
 * @date 2018/1/13
 */
public class DoctorController {
    @Autowired
    private IDoctorSer doctorSer;
}
