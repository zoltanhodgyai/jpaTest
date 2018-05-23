package com.example.jpaTest.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class Middle {

    @EmbeddedId
    private MiddleKey leftKey;

    String middleS;

}
