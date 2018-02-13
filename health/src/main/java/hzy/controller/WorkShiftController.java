package hzy.controller;

import com.github.pagehelper.Page;
import hzy.entity.Schedule;
import hzy.entity.WorkShift;
import hzy.service.IWorkShiftSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.NumberUtils;
import utils.Result;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
    private int insertRecord(WorkShift record, String times, String days){
        int successNum;
        Result result = workShiftInstall(record, times, days);
        if(result.getSuccess()){
            successNum = workShiftSer.insertRecord(record);
        }else{
            return 0;
        }
        return successNum;
    }

    @RequestMapping(value = "/deleteRecord", method = RequestMethod.POST)
    @ResponseBody
    private int deleteRecord(Integer id){
        int result = workShiftSer.deleteRecord(id);
        return result;
    }

    public Result workShiftInstall(WorkShift record, String times, String days){
        Result result;
        boolean flag = true;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        List<Schedule> scheduleList = new ArrayList<Schedule>();
        Short on = 1;
        String[] timesArr = times.split(",");
        try{
            for(int i=0; i<timesArr.length; i++){
                Schedule schedule = new Schedule();
                if(i%2 == 1){
                    schedule.setStartTime(sdf.parse(timesArr[i]));

                }else{
                    schedule.setEndTime(sdf.parse(timesArr[i]));
                }
                scheduleList.add(schedule);
            }
            record.setSchedules(scheduleList);
        }catch (ParseException e) {
            flag = false;
            e.printStackTrace();
        }catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        if(NumberUtils.isNumber(days)){
            String[] tempDay = days.split(",");
            for(String day : tempDay){
                switch (Integer.parseInt(day)) {
                    case 1:
                        record.setMon(on);
                        break;
                    case 2:
                        record.setTue(on);
                        break;
                    case 3:
                        record.setWed(on);
                        break;
                    case 4:
                        record.setThu(on);
                        break;
                    case 5:
                        record.setFri(on);
                        break;
                    case 6:
                        record.setSat(on);
                        break;
                    case 7:
                        record.setSun(on);
                        break;
                    default:
                        break;
                }
            }
        }
        result = new Result(flag, record);
        return result;
    }
}
