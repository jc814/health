
package hzy.serviceImpl;


import hzy.dao.PersonMapper;
import hzy.service.IPersonSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PersonSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
public class PersonSer implements IPersonSer {
    @Autowired
    private PersonMapper personMapper;
}
