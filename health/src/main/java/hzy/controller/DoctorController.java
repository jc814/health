package hzy.controller;

import com.github.pagehelper.Page;
import hzy.entity.Doctor;
import hzy.service.IDoctorSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

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

    @RequestMapping("selectAllRecord")
    @ResponseBody
    public Result selectAllRecord(Doctor record, int currentPage, int pageSize){
        Result result;
        try{
            Page<Doctor> page = doctorSer.selectAllRecord(record, currentPage, pageSize);
            result = new Result(true, page, page.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            result = new Result(false);
        }
        return result;
    }

    @RequestMapping(value = "/updateRecordById", method = RequestMethod.POST)
    @ResponseBody
    private int updateRecordById(Doctor record){
        int result = doctorSer.updateRecordById(record);
        return result;
    }

    @RequestMapping(value = "/insertRecord", method = RequestMethod.POST)
    @ResponseBody
    private int insertRecord(Doctor record){
        int result = doctorSer.insertRecord(record);
        return result;
    }

    @RequestMapping(value = "/deleteRecord", method = RequestMethod.POST)
    @ResponseBody
    private int deleteRecord(Integer id){
        int result = doctorSer.deleteRecord(id);
        return result;
    }
}
