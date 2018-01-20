package hzy.dao;

import hzy.entity.Office;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OfficeMapper interface
 *
 * @author hzy
 * @date 2018/01/13
 */
@Repository
public interface OfficeMapper extends BaseMapper<Office> {

    /**
     * 根据医院id查询科室信息
     * @param record
     * @return
     */
    List<Office> selectOfficeHospitalId(Office record);
}