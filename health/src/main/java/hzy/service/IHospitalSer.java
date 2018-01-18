package hzy.service;

import com.github.pagehelper.Page;
import hzy.entity.Hospital;

/**
 * IHospitalSer interface
 *
 * @author hzy
 * @date 2018/01/15
 */
public interface IHospitalSer {
    /**
     * 根据条件查找所有医院(分页)
     * @param record
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page<Hospital> selectAllRecord(Hospital record, int currentPage, int pageSize);

    /**
     * 根据id更新记录
     * @param record
     * @return
     */
    int updateRecordById(Hospital record);

    /**
     * 添加一条新记录
     * @param record
     * @return
     */
    int insertRecord(Hospital record);

    /**
     * 删除一条新记录
     * @param id
     * @return
     */
    int deleteRecord(Integer id);
}
