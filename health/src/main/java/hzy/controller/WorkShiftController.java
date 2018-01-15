package hzy.controller;

import hzy.service.IWorkShiftSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("workShift")
/**
 * WorkShiftController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class WorkShiftController {
    @Autowired
    private IWorkShiftSer workShiftSer;
}
