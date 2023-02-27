package com.github.spacenail.market.Model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private Integer price;

}
