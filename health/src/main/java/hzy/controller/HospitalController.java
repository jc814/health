package hzy.controller;

import hzy.service.IHospitalSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hospital")
/**
 * HospitalController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class HospitalController {
    @Autowired
    private IHospitalSer hospitalSer;
}
