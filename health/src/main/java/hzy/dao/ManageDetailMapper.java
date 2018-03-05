package hzy.dao;

import hzy.entity.ManageDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageDetailMapper extends BaseMapper<ManageDetail>{
    /**
     * 判断记录是否存在
     * @param mid
     * @return
     */
    int isExist(Integer mid);

    /**
     * 查找单条记录
     * @param mid
     * @param time
     * @return
     */
    ManageDetail selectRecordByTime(@Param("mid") Integer mid, @Param("time") String time);
}