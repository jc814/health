package hzy.controller;

import hzy.service.IBespeakSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bespeak")
/**
 * BespeakController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class BespeakController {
    @Autowired
    private IBespeakSer bespeakSer;
}
