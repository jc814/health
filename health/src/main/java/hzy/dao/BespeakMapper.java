package hzy.dao;

import hzy.entity.Bespeak;

public interface BespeakMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bespeak record);

    int insertSelective(Bespeak record);

    Bespeak selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bespeak record);

    int updateByPrimaryKey(Bespeak record);
}