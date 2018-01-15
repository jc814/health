package hzy.controller;

import hzy.service.ILogSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("log")
/**
 * LogController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class LogController {
    @Autowired
    private ILogSer logSer;
}
