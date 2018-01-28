package com.zz.web310.repo;

import com.zz.web310.entity.Moment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Moment 管理 moment 这个实体
// Integer 指的是  Moment 中 PK 的类型
public interface IMomentRepo extends JpaRepository<Moment, Integer>{

    List<Moment> findByTitle(String title);

    List<Moment> findByContent(String title);
}
