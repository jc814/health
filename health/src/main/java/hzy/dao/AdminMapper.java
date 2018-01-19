package hzy.dao;

import hzy.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * AdminMapper interface
 *
 * @author hzy
 * @date 2018/01/18
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin>{

    /**
     * 管理员的登录
     * @param admin
     * @return
     */
    Admin selectAdminByNameAndPsd(Admin admin);
}