package com.kb_hackathon.plovo.repository;

import com.kb_hackathon.plovo.dto.MonthAndWeightRes;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.data.repository.query.Param;
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
        Query query = entityManager.createNativeQuery("select MONTH(ur.date) as month, SUM(ur.weight) as weight from user_record ur left join plovo p on p.id = ur.plovo_id left join mountain m on m.id = p.mountain_id where m.id =:mountain_id and ur.date BETWEEN DATE_ADD(NOW(), INTERVAL -6 MONTH ) AND NOW() GROUP BY MONTH(ur.date);")
                .setParameter("mountain_id", mountain_id);
        List<MonthAndWeightRes> list = result.list(query, MonthAndWeightRes.class);
        return list;
    }
}
