
package hzy.serviceImpl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hzy.dao.ManageMapper;
import hzy.dao.ScheduleMapper;
import hzy.dao.WorkShiftMapper;
import hzy.entity.Manage;
import hzy.entity.Schedule;
import hzy.entity.WorkShift;
import hzy.service.IWorkShiftSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * WorkShiftSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkShiftSer extends BaseSer<WorkShift> implements IWorkShiftSer {
    @Autowired
    private WorkShiftMapper workShiftMapper;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private ManageMapper manageMapper;

    @Override
    public int insertRecord(WorkShift record) {
        int flag = 0;
        //添加班次信息
        try {
            workShiftMapper.insert(record);
            //添加时间表信息
            for(Schedule schedule : record.getSchedules()){
                schedule.setWid(record.getId());
                scheduleMapper.insert(schedule);
            }
            flag = 1;
        }
        catch (Exception e){
            e.printStackTrace();
            flag = 0;
        }
        return flag;
    }

    @Override
    public Page<WorkShift> selectAllRecord(WorkShift record, int currentPage, int pageSize) {
        Manage manage = null;
        Page<WorkShift> page = PageHelper.startPage(currentPage, pageSize);
        workShiftMapper.selectAllRecord(record);
        for(WorkShift w : page.getResult()){
            List<Schedule> scheduleList = scheduleMapper.selectByWid(w.getId());
            manage = new Manage();
            manage.setWid(w.getId());
            List<Manage> manageList = manageMapper.selectAllRecord(manage);
            if(manageList != null && manageList.size() > 0){
                w.setInUsed(true);
            } else {
                w.setInUsed(false);
            }
            w.setSchedules(scheduleList);
            w.setScheduleCount(scheduleList.size());
        }
        return page;
    }

    @Override
    public int updateRecordById(WorkShift record) {
        int result = 0;
        try {
            scheduleMapper.deleteByWid(record.getId());
            workShiftMapper.updateByPrimaryKeySelective(record);
            //添加时间表信息
            for(Schedule schedule : record.getSchedules()){
                schedule.setWid(record.getId());
                scheduleMapper.insert(schedule);
            }
            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    @Override
    public int deleteRecord(Integer id){
        int flag = 0;
        try {
            scheduleMapper.deleteByWid(id);
            workShiftMapper.deleteByPrimaryKey(id);
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
