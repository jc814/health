package hzy.service;

import hzy.entity.Manage;

import java.util.List;

/**
 * IManageSer interface
 *
 * @author hzy
 * @date 2018/01/15
 */
public interface IManageSer extends IBaseSer<Manage>{
    /**
     * 插入数据（多条）
     * @param wid
     * @param record
     * @return
     */
    int insertManyRecord(Integer wid, List<Integer> record);

    /**
     * 判断并执行增删
     * @param wid
     * @param doctorsId
     * @return
     */
    int judgeOption(Integer wid, List<Integer> doctorsId);
}
