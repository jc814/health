package hzy.service;

import hzy.entity.WorkShift;

/**
 * IWorkShiftSer interface
 *
 * @author hzy
 * @date 2018/01/15
 */
public interface IWorkShiftSer extends IBaseSer<WorkShift>{

    /**
     * 插入班次信息（包括插入时间表）
     * @param record
     * @return
     */
    @Override
    int insertRecord(WorkShift record);

}
