package hzy.service;

import com.github.pagehelper.Page;
import hzy.entity.Office;

/**
 * IOfficeSer interface
 *
 * @author hzy
 * @date 2018/01/15
 */
public interface IOfficeSer extends IBaseSer<Office>{

    /**
     * 根据医院id查询科室信息
     * @param record
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<Office> selectOfficeHospitalId(Office record, int currentPage, int pageSize);
}
