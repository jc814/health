
package hzy.serviceImpl;


import hzy.dao.WorkShiftMapper;
import hzy.service.IWorkShiftSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * WorkShiftSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
public class WorkShiftSer implements IWorkShiftSer {
    @Autowired
    private WorkShiftMapper workShiftMapper;
}
