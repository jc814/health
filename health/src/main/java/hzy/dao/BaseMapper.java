package hzy.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * BaceMapper interface
 *
 * @author hzy
 * @date 2018/01/15
 */
@Repository
public interface BaseMapper<T> {
    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 全字段添加记录
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 可选字段添加记录
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 根据主键查找一条记录
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 根据主键可选字段更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据主键全字段更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);

    /**
     * 根据条件查询所有记录
     * @param record
     * @return
     */
    List<T> selectAllRecord(T record);
}
