package com.example.jpaTest.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Embeddable
public class Middle implements Serializable {

    @EmbeddedId
    private MiddleKey key;

    private String middleS;

}
