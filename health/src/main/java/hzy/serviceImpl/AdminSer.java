
package hzy.serviceImpl;


import hzy.dao.AdminMapper;
import hzy.entity.Admin;
import hzy.service.IAdminSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AdminSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
public class AdminSer extends BaseSer<Admin> implements IAdminSer {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectAdminByNameAndPsd(Admin admin) {
        return adminMapper.selectAdminByNameAndPsd(admin);
    }
}
