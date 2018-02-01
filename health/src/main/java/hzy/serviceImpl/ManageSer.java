
package hzy.serviceImpl;


import hzy.dao.ManageMapper;
import hzy.entity.Manage;
import hzy.service.IManageSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ManageSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
public class ManageSer extends BaseSer<Manage> implements IManageSer {
    @Autowired
    private ManageMapper manageMapper;
}
