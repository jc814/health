
package hzy.serviceImpl;


import hzy.dao.ManageDetailMapper;
import hzy.dao.ManageMapper;
import hzy.dao.WorkShiftMapper;
import hzy.entity.Manage;
import hzy.entity.ManageDetail;
import hzy.entity.WorkShift;
import hzy.service.IManageSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * ManageSer class
 *
 * @author hzy
 * @date 2018/01/15
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ManageSer extends BaseSer<Manage> implements IManageSer {
    @Autowired
    private ManageMapper manageMapper;

    @Autowired
    private WorkShiftMapper workShiftMapper;

    @Autowired
    private ManageDetailMapper manageDetailMapper;

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
                manageMapper.deleteByDid(deleteId,wid);
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
    public int manageCreate() {
        int result = 0;
        ManageDetail manageDetail = null;
        int []weeks = new int[7];
        List<Manage> manageList = manageMapper.selectRecordGroupById();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for(Manage m : manageList){
                Calendar calendar = Calendar.getInstance();
                calendar.setFirstDayOfWeek(Calendar.MONDAY);
                calendar.add(Calendar.MONTH, 0);
                calendar.set(Calendar.DAY_OF_MONTH,1);
                Manage manage = manageMapper.selectByPrimaryKey(m.getId());
                WorkShift workShift = workShiftMapper.selectByPrimaryKey(manage.getWid());
                if(workShift == null || m.getDids() == null || "".equals(m.getDids())){
                    return 0;
                }
                ManageDetail md = manageDetailMapper.selectRecordByTime(m.getId(),sdf.format(calendar.getTime()));
                if(md == null){
                    weeks[1] = workShift.getMon() == null ? 0 : workShift.getMon();
                    weeks[2] = workShift.getTue() == null ? 0 : workShift.getTue();
                    weeks[3] = workShift.getWed() == null ? 0 : workShift.getWed();
                    weeks[4] = workShift.getThu() == null ? 0 : workShift.getThu();
                    weeks[5] = workShift.getFri() == null ? 0 : workShift.getFri();
                    weeks[6] = workShift.getSat() == null ? 0 : workShift.getSat();
                    weeks[0] = workShift.getSun() == null ? 0 : workShift.getSun();


                    //当月有几天
                    int dayCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                    for (int i = 0; i < dayCount; i++){
                        manageDetail = new ManageDetail();
                        manageDetail.setMid(manage.getId());
                        manageDetail.setWid(workShift.getId());
                        manageDetail.setTime(calendar.getTime());
                        //当月第一天周几
                        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1  ;
                        manageDetail.setStatus(weeks[week]);
                        manageDetailMapper.insert(manageDetail);
                        calendar.add(Calendar.DATE, 1);
                    }
                }
            }
            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }

        return result;
    }

}
