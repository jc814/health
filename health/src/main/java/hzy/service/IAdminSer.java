package hzy.service;

import hzy.entity.Admin; /**
 * IAdminSer interface
 *
 * @author hzy
 * @date 2018/01/15
 */
public interface IAdminSer {

    /**
     * 管理员的登录
     * @param admin
     * @return
     */
    Admin selectAdminByNameAndPsd(Admin admin);
}
