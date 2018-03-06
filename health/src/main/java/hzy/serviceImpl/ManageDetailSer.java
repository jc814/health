
package hzy.serviceImpl;


import hzy.dao.ManageDetailMapper;
import hzy.entity.ManageDetail;
import hzy.service.IManageDetailSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * ManageSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ManageDetailSer extends BaseSer<ManageDetail> implements IManageDetailSer {
    @Autowired
    private ManageDetailMapper manageDetailMapper;


    @Override
    public int deleteByMid(Integer mid) {
        int flag = 0;
        try {
            manageDetailMapper.deleteByMid(mid,new Date());
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
            flag = 0;
        }
        return flag;
    }
}
