package com.example.jpaTest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.olingo.odata2.api.annotation.edm.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@EdmEntityType(name = "Product")
@EdmEntitySet(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EdmKey
    @EdmProperty
    private Integer id;

    @EdmProperty
    private String name;

    @ManyToOne(optional = false)
    @EdmNavigationProperty(name = "ProductCategory", toType = ProductCategory.class)
    @JoinColumn(name = "productCategory")
    private ProductCategory productCategory;
}
