package hzy.service;

import hzy.entity.Hospital;

import java.util.List;

/**
 * IHospitalSer interface
 *
 * @author hzy
 * @date 2018/01/15
 */
public interface IHospitalSer {
    /**
     * 根据条件查找所有医院
     * @param record
     * @return
     */
    public List<Hospital> selectAllRecord(Hospital record);

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
}
