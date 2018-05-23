package com.example.jpaTest.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Middle implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leftS")
    private Left leftS;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rightS")
    private Right rightS;

    private String middleS;

}
