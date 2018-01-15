package hzy.dao;

import hzy.entity.Manage;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manage record);

    int insertSelective(Manage record);

    Manage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manage record);

    int updateByPrimaryKey(Manage record);
}