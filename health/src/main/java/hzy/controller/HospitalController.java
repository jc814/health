package hzy.controller;

import com.github.pagehelper.Page;
import hzy.entity.Hospital;
import hzy.service.IHospitalSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    private Map<String, Object> selectAllRecord(Hospital record, int currentPage, int pageSize){
        Page<Hospital> result = hospitalSer.selectAllRecord(record, currentPage, pageSize);
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("data", result);
        map.put("number", result.getTotal());
        return map;
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
