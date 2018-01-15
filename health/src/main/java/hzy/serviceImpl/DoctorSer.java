
package hzy.serviceImpl;


import hzy.dao.DoctorMapper;
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
public class DoctorSer implements IDoctorSer {

    @Autowired
    private DoctorMapper doctorMapper;
}
