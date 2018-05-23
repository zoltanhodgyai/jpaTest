package com.example.jpaTest.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
class MiddleKey implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "leftS")
    private Left left;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rightS")
    private Right right;
}
