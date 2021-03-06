
package hzy.serviceImpl;


import hzy.dao.LogMapper;
import hzy.entity.Log;
import hzy.service.ILogSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LogSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
public class LogSer extends BaseSer<Log> implements ILogSer {
    @Autowired
    private LogMapper logMapper;
}
