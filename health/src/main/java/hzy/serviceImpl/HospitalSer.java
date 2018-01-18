
package hzy.serviceImpl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hzy.dao.HospitalMapper;
import hzy.entity.Hospital;
import hzy.service.IHospitalSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HospitalSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
public class HospitalSer implements IHospitalSer {
    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    public Page<Hospital> selectAllRecord(Hospital record, int currentPage, int pageSize) {
        Page<Hospital> page = PageHelper.startPage(currentPage, pageSize);
        hospitalMapper.selectAllRecord(record);
        return page;
    }

    @Override
    public int updateRecordById(Hospital record) {
        int result = hospitalMapper.updateByPrimaryKeySelective(record);
        return result;
    }

    @Override
    public int insertRecord(Hospital record) {
        int result = hospitalMapper.insert(record);
        return result;
    }

    @Override
    public int deleteRecord(Integer id) {
        int result = hospitalMapper.deleteByPrimaryKey(id);
        return result;
    }
}
