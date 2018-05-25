package com.example.jpaTest.repository;

import com.example.jpaTest.model.Left;
import com.example.jpaTest.model.Middle;
import com.example.jpaTest.model.Right;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MiddleRepository extends Repository<Middle, Integer> {

    Middle save(Middle middle);

    Middle findMiddleById(Integer id);

    Middle findMiddleByLeftSAndRightS(Left left, Right right);

    List<Middle> findAll();
}
