
package hzy.serviceImpl;


import hzy.dao.HospitalMapper;
import hzy.entity.Hospital;
import hzy.service.IHospitalSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Hospital> selectAllRecord(Hospital record) {
        List<Hospital> result = hospitalMapper.selectAllRecord(record);
        return result;
    }
}
