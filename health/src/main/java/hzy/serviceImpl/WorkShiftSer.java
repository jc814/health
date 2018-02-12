
package hzy.serviceImpl;


import hzy.dao.ScheduleMapper;
import hzy.dao.WorkShiftMapper;
import hzy.entity.Schedule;
import hzy.entity.WorkShift;
import hzy.service.IWorkShiftSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public int insertRecord(WorkShift record) {
        int flag = 0;
        //添加班次信息
        try {
            workShiftMapper.insert(record);
            //添加时间表信息
            for(Schedule schedule : record.getScheduleList()){
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
}
