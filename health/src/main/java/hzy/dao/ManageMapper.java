package hzy.dao;

import hzy.entity.Manage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ManageMapper interface
 *
 * @author hzy
 * @date 2018/01/13
 */
@Repository
public interface ManageMapper extends BaseMapper<Manage> {
    /**
     * 根据医生id删除记录
     * @param did
     * @param wid
     * @return
     */
    int deleteByDid(@Param("did") Integer did, @Param("wid") Integer wid);

    /**
     * 查找所有记录（根据id分类）
     * @return
     */
    List<Manage> selectRecordGroupById();

    /**
     * 根据wid删除记录
     * @param wid
     * @return
     */
    int deleteByWid(Integer wid);

}