package hzy.controller;

import hzy.service.IOfficeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("office")
/**
 * OfficeController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class OfficeController {
    @Autowired
    private IOfficeSer officeSer;
}
