package com.github.spacenail.market.Model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Product.findById",
                query = "SELECT product FROM Product product WHERE product.id = :id"),
        @NamedQuery(name = "Product.findAll",
                query = "SELECT product FROM Product product")
})
public class Product {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private int price;
}
