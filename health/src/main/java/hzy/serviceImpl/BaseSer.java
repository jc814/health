package hzy.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hzy.dao.BaseMapper;
import hzy.service.IBaseSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 泛型公用方法
 *
 * @author hzy
 * @date 2018/02/01
 */
@Service
public class BaseSer<T> implements IBaseSer<T>{

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public Page<T> selectAllRecord(T record, int currentPage, int pageSize) {
        Page<T> page = PageHelper.startPage(currentPage, pageSize);
        baseMapper.selectAllRecord(record);
        return page;
    }

    @Override
    public int updateRecordById(T record) {
        int result = baseMapper.updateByPrimaryKeySelective(record);
        return result;
    }

    @Override
    public int insertRecord(T record) {
        int result = baseMapper.insert(record);
        return result;
    }

    @Override
    public int deleteRecord(Integer id) {
        int result = baseMapper.deleteByPrimaryKey(id);
        return result;
    }
}
