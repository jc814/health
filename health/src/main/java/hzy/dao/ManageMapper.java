package hzy.dao;

import hzy.entity.Manage;
import org.springframework.stereotype.Repository;
/**
 * ManageMapper interface
 *
 * @author hzy
 * @date 2018/01/13
 */
@Repository
public interface ManageMapper extends BaseMapper<Manage> {
    /**
     * 根据医生id删除记录
     * @param did
     * @return
     */
    int deleteByDid(Integer did);
}