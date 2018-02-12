package hzy.controller;

import com.github.pagehelper.Page;
import hzy.entity.WorkShift;
import hzy.service.IWorkShiftSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

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

    @RequestMapping("selectAllRecord")
    @ResponseBody
    public Result selectAllRecord(WorkShift record, int currentPage, int pageSize){
        Result result;
        try{
            Page<WorkShift> page = workShiftSer.selectAllRecord(record, currentPage, pageSize);
            result = new Result(true, page, page.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            result = new Result(false);
        }
        return result;
    }

    @RequestMapping(value = "/updateRecordById", method = RequestMethod.POST)
    @ResponseBody
    private int updateRecordById(WorkShift record){
        int result = workShiftSer.updateRecordById(record);
        return result;
    }

    @RequestMapping(value = "/insertRecord", method = RequestMethod.POST)
    @ResponseBody
    private int insertRecord(WorkShift record){
        int result = workShiftSer.insertRecord(record);
        return result;
    }

    @RequestMapping(value = "/deleteRecord", method = RequestMethod.POST)
    @ResponseBody
    private int deleteRecord(Integer id){
        int result = workShiftSer.deleteRecord(id);
        return result;
    }
}
