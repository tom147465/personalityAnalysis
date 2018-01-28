package com.zz.web310.repo;

import com.zz.web310.entity.Moment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Moment 管理 moment 这个实体
// Integer 指的是  Moment 中 PK 的类型
public interface IMomentRepo extends JpaRepository<Moment, Integer>{

    List<Moment> findByTitle(String title);

    List<Moment> findByContent(String title);

//    JpaRepository<Memont> findByTitleAndContentOrderByTimestampDesc
//
// -> 切割字段 title content timestamp
//
//    <Memont> 表 memont
//    findBy = where
//
//    select 字段(title content)
//    from 表（memont）
//    where
//    参数（?1  ?2）
//    order by
//    timestamp desc

//    @Query(value = "SELECT * from  moment where title = ?1 and title = ?2", nativeQuery = true)
//    List<Moment> findCu(String title1, String title2);
}
