package hzy.service;

import hzy.entity.ManageDetail;

/**
 * IManageSer interface
 *
 * @author hzy
 * @date 2018/01/15
 */
public interface IManageDetailSer extends IBaseSer<ManageDetail>{

    /**
     * 通过mid删除从今天起的记录
     * @param mid
     * @return
     */
    int deleteByMid(Integer mid);
}
