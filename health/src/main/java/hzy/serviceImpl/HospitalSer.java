
package hzy.serviceImpl;


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
public class HospitalSer extends BaseSer<Hospital> implements IHospitalSer {

    @Autowired
    private HospitalMapper hospitalMapper;
}
