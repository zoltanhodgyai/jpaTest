package com.example.jpaTest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.olingo.odata2.api.annotation.edm.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@EdmEntityType(name = "ProductCategory")
@EdmEntitySet(name = "ProductCategories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EdmKey
    @EdmProperty
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @EdmNavigationProperty(name = "Products", toType = Product.class)
    private List<Product> products;

    @EdmProperty
    private String name;
}
