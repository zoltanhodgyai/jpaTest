package com.example.jpaTest.model;

import lombok.Data;
import org.apache.olingo.odata2.api.annotation.edm.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EdmEntityType(name = "Middle")
@EdmEntitySet(name = "Middles")
public class Middle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EdmKey
    @EdmProperty
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "leftS")
    @EdmNavigationProperty(name = "Left", toType = Left.class)
    private Left leftS;

    @ManyToOne(optional = false)
    @JoinColumn(name="rightS")
    @EdmNavigationProperty(name = "Right", toType = Right.class)
    private Right rightS;

    @EdmProperty
    private String middleS;

}
