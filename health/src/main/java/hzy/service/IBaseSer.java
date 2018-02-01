package hzy.service;

import com.github.pagehelper.Page;

/**
 * 所有service接口基类，定义基本增删改查方法
 *
 * @author hzy
 * @date 2018/02/01
 */
public interface IBaseSer<T> {
    /**
     * 根据条件查找所有记录(分页)
     * @param record
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page<T> selectAllRecord(T record, int currentPage, int pageSize);

    /**
     * 根据id更新记录
     * @param record
     * @return
     */
    int updateRecordById(T record);

    /**
     * 添加一条新记录
     * @param record
     * @return
     */
    int insertRecord(T record);

    /**
     * 删除一条新记录
     * @param id
     * @return
     */
    int deleteRecord(Integer id);
}
