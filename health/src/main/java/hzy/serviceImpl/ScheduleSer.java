
package hzy.serviceImpl;


import hzy.dao.ScheduleMapper;
import hzy.entity.Schedule;
import hzy.service.IScheduleSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ScheduleSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
public class ScheduleSer extends BaseSer<Schedule> implements IScheduleSer {
    @Autowired
    private ScheduleMapper scheduleMapper;
}
