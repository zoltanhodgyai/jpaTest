package com.example.jpaTest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.olingo.odata2.api.annotation.edm.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "LeftTable")
@EdmEntityType(name = "Left")
@EdmEntitySet(name = "Lefts")
public class Left implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EdmKey
    @EdmProperty
    private Integer id;

    @EdmProperty
    private String leftS;

    @OneToMany(cascade = CascadeType.ALL)
    @EdmNavigationProperty(name = "Middles", toType = Middle.class)
    private List<Middle> middles;
}
