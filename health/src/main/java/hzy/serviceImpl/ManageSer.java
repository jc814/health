
package hzy.serviceImpl;


import hzy.dao.ManageMapper;
import hzy.entity.Manage;
import hzy.service.IManageSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * ManageSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
@Transactional
public class ManageSer extends BaseSer<Manage> implements IManageSer {
    @Autowired
    private ManageMapper manageMapper;

    @Override
    public int insertManyRecord(Integer wid, List<Integer> doctorIds) {
        int flag;
        Manage manage = null;
        try {
            for(Integer did : doctorIds){
                manage = new Manage();
                manage.setWid(wid);
                manage.setDid(did);
                manageMapper.insertSelective(manage);
            }
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
            flag = 0;
        }
        return flag;
    }

    @Override
    public int judgeOption(Integer wid, List<Integer> doctorsId) {
        int flag;
        try {
            List<Integer> oldDoctorsId = new ArrayList<Integer>();
            Manage manage = new Manage();
            manage.setWid(wid);
            List<Manage> manageList = manageMapper.selectAllRecord(manage);
            for (Manage m : manageList){
                oldDoctorsId.add(m.getDid());
            }
            List<Integer> insertList = new ArrayList<Integer>(doctorsId);
            List<Integer> notDoList = new ArrayList<Integer>(doctorsId);
            List<Integer> deleteList = new ArrayList<Integer>(oldDoctorsId);
            //不变的did记录
            notDoList.retainAll(oldDoctorsId);
            //删除的did记录
            deleteList.removeAll(notDoList);
            //添加的did记录
            insertList.removeAll(notDoList);
            //删除操作
            for(Integer deleteId : deleteList){
                manageMapper.deleteByDid(deleteId);
            }
            //添加操作
            insertManyRecord(wid,insertList);
            flag = 1;
        } catch (Exception e) {
            flag = 0;
        }
        return flag;
    }

    @Override
    public int manageCreate(Integer wid, List<Integer> doctorsId) {
        return 0;
    }

}
