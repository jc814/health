package hzy.dao;

import hzy.entity.WorkShift;

public interface WorkShiftMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkShift record);

    int insertSelective(WorkShift record);

    WorkShift selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkShift record);

    int updateByPrimaryKey(WorkShift record);
}