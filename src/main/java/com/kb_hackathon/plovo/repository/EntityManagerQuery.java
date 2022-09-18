package com.kb_hackathon.plovo.repository;


import com.kb_hackathon.plovo.domain.Mountain;
import com.kb_hackathon.plovo.dto.*;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EntityManagerQuery {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MonthAndWeightRes> MonthAndWeightRes(Long mountain_id) {

        JpaResultMapper result = new JpaResultMapper();
        Query query = entityManager.createNativeQuery("select MONTH(ur.date) as month, abs(SUM(ur.weight)) as weight from user_record ur left join plovo p on p.id = ur.plovo_id left join mountain m on m.id = p.mountain_id where m.id =:mountain_id and ur.date BETWEEN DATE_ADD(NOW(), INTERVAL -6 MONTH ) AND NOW() GROUP BY MONTH(ur.date);")
                .setParameter("mountain_id", mountain_id);
        List<MonthAndWeightRes> list = result.list(query, MonthAndWeightRes.class);
        return list;
    }

    public List<GetMountainRes> mRecommend() {
        JpaResultMapper result = new JpaResultMapper();
        Query query = entityManager.createNativeQuery("SELECT m.m_name as mName, m.main_img as mImage, p.weight as weight, p.current_weight as distance, p.current_weight as time FROM mountain m left join plovo p on m.id = p.mountain_id ORDER BY p.weight DESC LIMIT 5");
        List<GetMountainRes> mountainRes = result.list(query, GetMountainRes.class);
        return mountainRes;
    }

    public List<GetMountainRes> mfindBymName(String mName){
        JpaResultMapper result = new JpaResultMapper();
//        Query query = entityManager.createNativeQuery("SELECT m.m_name, m.main_img, p.weight FROM mountain m left join plovo p on m.id = p.mountain_id");
        Query query = entityManager.createNativeQuery("SELECT m.m_name as mName, m.main_img as mImage, p.weight as weight, p.current_weight as distance, p.current_weight as time FROM mountain m left join plovo p on m.id = p.mountain_id WHERE m.m_name like :mName")
                .setParameter("mName", "%"+mName+"%");
        List<GetMountainRes> getMountainRes = result.list(query, GetMountainRes.class);
        return getMountainRes;
    }

    public List<TimeAndWeightRes> timeAndWeight(Long user_id) {
        JpaResultMapper result = new JpaResultMapper();
        Query query = entityManager.createNativeQuery("SELECT MONTH(u.date) as month, SUM(HOUR(u.time)*60 + MINUTE(u.time)) as time, SUM(u.weight) as weight FROM user_record u WHERE u.user_id =:user_id and u.date BETWEEN DATE_ADD(NOW(),INTERVAL -6 MONTH) AND NOW() GROUP BY MONTH(u.date) ORDER BY MONTH(u.date) DESC LIMIT 6;")
                .setParameter("user_id", user_id);
        List<TimeAndWeightRes> timeAndWeightRes = result.list(query, TimeAndWeightRes.class);
        return timeAndWeightRes;
    }

//    public List<MountainRes> recentPlog() {
//        JpaResultMapper result = new JpaResultMapper();
//        Query query = entityManager.createNativeQuery("SELECT m.m_name as mName, m.main_img as mImage, u.weight as weight FROM user_record u left outer join plovo p on u.plovo_id = p.id left join mountain m on p.mountain_id = m.id ORDER BY u.date DESC LIMIT 3;");
//        List<MountainRes> getMountainRes = result.list(query, MountainRes.class);
//        return getMountainRes;
//    }

    public List<GetMountainRes> recentPlog() {
        JpaResultMapper result = new JpaResultMapper();
        Query query = entityManager.createNativeQuery("SELECT m.m_name as mName, m.main_img as mImage, u.weight as weight, m.distance as distance, u.time as time FROM user_record u left outer join plovo p on u.plovo_id = p.id left join mountain m on p.mountain_id = m.id ORDER BY u.date DESC LIMIT 3;");
        List<GetMountainRes> getMountainRes = result.list(query, GetMountainRes.class);
        return getMountainRes;
    }

    public List<BestPloggerRes> bestPlogger() {
        JpaResultMapper result = new JpaResultMapper();
        Query query = entityManager.createNativeQuery("SELECT u.username, u.profile_img FROM user_record ur JOIN user u ON ur.user_id = u.id GROUP BY u.id ORDER BY COUNT(*) DESC LIMIT 6;");
        List<BestPloggerRes> bestPloggerRes = result.list(query, BestPloggerRes.class);
        return bestPloggerRes;
    }

    public List<PlogMountainInfoRes> recentPlogInfo(String mName) {
        JpaResultMapper result = new JpaResultMapper();
        Query query = entityManager.createNativeQuery("SELECT m.m_name as mName, u.end_image as uploadImg, u.weight as weight, m.distance as distance, u.time as time, user.profile_img as userProfile FROM user_record u left outer join user on user.id=u.user_id left outer join plovo p on u.plovo_id = p.id left join mountain m on p.mountain_id = m.id WHERE m.m_name=:mName ORDER BY u.date DESC LIMIT 5;")
                .setParameter("mName", mName);
        List<PlogMountainInfoRes> plogMountainInfoRes = result.list(query, PlogMountainInfoRes.class);

        return plogMountainInfoRes;
    }

    public List<UserUploadImgRes> userUploadImg(Long user_id) {
        JpaResultMapper result = new JpaResultMapper();
        Query query = entityManager.createNativeQuery("SELECT u.end_image as uploadImg, u.date as date, m.distance as distance, u.time as time, u.weight as weight, m.m_name as mName, user.profile_img as profileImg FROM user_record u left outer join user on u.user_id=user.id left outer join plovo p on u.plovo_id=p.id left outer join mountain m on p.mountain_id=m.id WHERE u.user_id =:user_id")
                .setParameter("user_id", user_id);;
        List<UserUploadImgRes> userUploadImgRes = result.list(query, UserUploadImgRes.class);
        return userUploadImgRes;
    }

}
