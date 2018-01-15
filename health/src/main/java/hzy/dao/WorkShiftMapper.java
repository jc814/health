package hzy.dao;

import hzy.entity.WorkShift;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkShiftMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkShift record);

    int insertSelective(WorkShift record);

    WorkShift selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkShift record);

    int updateByPrimaryKey(WorkShift record);
}