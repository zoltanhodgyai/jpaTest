package com.example.jpaTest.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
class MiddleKey implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leftS")
    private Left leftS;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rightS")
    private Right rightS;
}
