package hzy.dao;

import hzy.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ScheduleMapper interface
 *
 * @author hzy
 * @date 2018/01/13
 */
@Repository
public interface ScheduleMapper extends BaseMapper<Schedule> {

    /**
     * 根据班次id查询时间表
     * @param wid 班次id
     * @return
     */
    List<Schedule> selectByWid(int wid);

    /**
     * 根据班次id删除询时间表
     * @param wid 班次id
     * @return
     */
    int deleteByWid(int wid);
}