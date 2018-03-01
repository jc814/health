
package hzy.serviceImpl;


import hzy.dao.ManageDetailMapper;
import hzy.entity.ManageDetail;
import hzy.service.IManageDetailSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ManageSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
@Transactional
public class ManageDetailSer extends BaseSer<ManageDetail> implements IManageDetailSer {
    @Autowired
    private ManageDetailMapper manageDetailMapper;

}
