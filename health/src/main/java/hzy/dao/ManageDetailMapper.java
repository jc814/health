package hzy.dao;

import hzy.entity.ManageDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageDetailMapper extends BaseMapper<ManageDetail>{
    /**
     * 判断
     * @param mid
     * @return
     */
    int isExist(Integer mid);
}