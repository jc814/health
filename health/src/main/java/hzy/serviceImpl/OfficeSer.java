
package hzy.serviceImpl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hzy.dao.OfficeMapper;
import hzy.entity.Office;
import hzy.service.IOfficeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OfficeSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
public class OfficeSer extends BaseSer<Office> implements IOfficeSer  {
    @Autowired
    private OfficeMapper officelMapper;

    @Override
    public Page<Office> selectOfficeHospitalId(Office record, int currentPage, int pageSize) {
        Page<Office> page = PageHelper.startPage(currentPage, pageSize);
        officelMapper.selectOfficeHospitalId(record);
        return page;
    }
}
