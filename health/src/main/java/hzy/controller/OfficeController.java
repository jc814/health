package hzy.controller;

import com.github.pagehelper.Page;
import hzy.entity.Office;
import hzy.service.IOfficeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.JwtUtils;
import utils.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * OfficeController class
 *
 * @author hzy
 * @date 2018/1/15
 */
@Controller
@RequestMapping("office")
public class OfficeController {
    @Autowired
    private IOfficeSer officeSer;

    @RequestMapping("selectOfficeHospitalId")
    @ResponseBody
    public Result selectOfficeHospitalId(Office record, int currentPage, int pageSize){
        Result result;
        try{
            Page<Office> page = officeSer.selectOfficeHospitalId(record, currentPage, pageSize);
            result = new Result(true, page, page.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            result = new Result(false);
        }
        return result;
    }

    @RequestMapping(value = "/updateRecordById", method = RequestMethod.POST)
    @ResponseBody
    private int updateRecordById(Office record){
        int result = officeSer.updateRecordById(record);
        return result;
    }

    @RequestMapping(value = "/insertRecord", method = RequestMethod.POST)
    @ResponseBody
    private int insertRecord(Office record, HttpServletRequest req){
        String token = req.getHeader("Authorization");
        Integer type = JwtUtils.getType(token);
        Integer hid = JwtUtils.getHid(token);
        if(type != null && type.intValue() == 0){
            record.setHid(hid);
        }
        int result = officeSer.insertRecord(record);
        return result;
    }

    @RequestMapping(value = "/deleteRecord", method = RequestMethod.POST)
    @ResponseBody
    private int deleteRecord(Integer id){
        int result = officeSer.deleteRecord(id);
        return result;
    }
}
