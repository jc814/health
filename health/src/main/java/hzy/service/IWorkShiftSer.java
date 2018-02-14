package hzy.service;

import com.github.pagehelper.Page;
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

    /**
     * 查询班次信息（包括时间表）
     * @param record
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<WorkShift> selectAllRecord(WorkShift record, int currentPage, int pageSize);


}
