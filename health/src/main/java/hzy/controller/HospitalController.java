package hzy.controller;

import com.github.pagehelper.Page;
import hzy.entity.Hospital;
import hzy.service.IHospitalSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

@Controller
@RequestMapping("/hospital")
/**
 * HospitalController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class HospitalController {
    @Autowired
    private IHospitalSer hospitalSer;

    @RequestMapping("/selectAllRecord")
    @ResponseBody
    private Result selectAllRecord(Hospital record, int currentPage, int pageSize){
        Result result = null;
        try{
            Page<Hospital> page = hospitalSer.selectAllRecord(record, currentPage, pageSize);
            result = new Result(true, page, page.getTotal());
        }catch (Exception e){
            result = new Result(false);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/updateRecordById", method = RequestMethod.POST)
    @ResponseBody
    private int updateRecordById(Hospital record){
        int result = hospitalSer.updateRecordById(record);
        return result;
    }

    @RequestMapping(value = "/insertRecord", method = RequestMethod.POST)
    @ResponseBody
    private int insertRecord(Hospital record){
        int result = hospitalSer.insertRecord(record);
        return result;
    }

    @RequestMapping(value = "/deleteRecord", method = RequestMethod.POST)
    @ResponseBody
    private int deleteRecord(Integer id){
        int result = hospitalSer.deleteRecord(id);
        return result;
    }
}
