package com.example.jpaTest.repository;

import com.example.jpaTest.model.Right;
import org.springframework.data.repository.Repository;

public interface RightRepository extends Repository<Right, Integer> {

    Right save(Right right);

    Right findRightById(Integer id);
}
