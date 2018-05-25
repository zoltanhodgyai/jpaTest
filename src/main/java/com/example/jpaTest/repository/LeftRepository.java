package com.example.jpaTest.repository;

import com.example.jpaTest.model.Left;
import org.springframework.data.repository.Repository;

public interface LeftRepository extends Repository<Left, Integer> {

    Left save(Left left);

    Left findLeftById(Integer id);
}
