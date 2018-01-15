
package hzy.serviceImpl;


import hzy.dao.OfficeMapper;
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
public class OfficeSer implements IOfficeSer {
    @Autowired
    private OfficeMapper officelMapper;
}
