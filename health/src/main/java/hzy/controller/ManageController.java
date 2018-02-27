package hzy.controller;

import com.github.pagehelper.Page;
import hzy.entity.Manage;
import hzy.service.IManageSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.NumberUtils;
import utils.Result;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("manage")
/**
 * DoctorController class
 *
 * @author hzy
 * @date 2018/1/15
 */
public class ManageController {
    @Autowired
    private IManageSer manageSer;

    @RequestMapping("selectAllRecord")
    @ResponseBody
    public Result selectAllRecord(Manage record, int currentPage, int pageSize){
        Result result;
        try{
            Page<Manage> page = manageSer.selectAllRecord(record, currentPage, pageSize);
            result = new Result(true, page, page.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            result = new Result(false);
        }
        return result;
    }

    @RequestMapping(value = "/updateRecordById", method = RequestMethod.POST)
    @ResponseBody
    private int updateRecordById(Manage record){
        int result = manageSer.updateRecordById(record);
        return result;
    }

    @RequestMapping(value = "/insertRecord", method = RequestMethod.POST)
    @ResponseBody
    private int insertRecord(Integer wid, String delDoctors){
        int result = 0;
        Manage manage = null;
        List<Integer> manages = new ArrayList<Integer>();
        if(NumberUtils.isNumber(delDoctors)){
            String []personList = delDoctors.split(",");
            for(String doctorId : personList){
                manages.add(Integer.parseInt(doctorId));
            }
            result = manageSer.judgeOption(wid, manages);
        }else{
            result = 0;
        }
        return result;
    }

    @RequestMapping(value = "/deleteRecord", method = RequestMethod.POST)
    @ResponseBody
    private int deleteRecord(Integer id){
        int result = manageSer.deleteRecord(id);
        return result;
    }
}
