
package hzy.serviceImpl;


import hzy.dao.DoctorMapper;
import hzy.entity.Doctor;
import hzy.service.IDoctorSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DoctorSer class
 *
 * @author hzy
 * @date 2018/01/13
 */
@Service
public class DoctorSer extends BaseSer<Doctor> implements IDoctorSer {

    @Autowired
    private DoctorMapper doctorMapper;
}
