package hzy.controller;

import hzy.service.IScheduleSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("schedule")
/**
 * ScheduleController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class ScheduleController {
    @Autowired
    private IScheduleSer scheduleSer;
}
