package com.phantom.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
@Entity
@Table(name="MANUFACTURER")
@NamedQueries({
        @NamedQuery(name = "Manufacturer.findNameById",
        query = "SELECT m.name FROM Manufacturer m WHERE m.id = :id "),
        @NamedQuery(name = "Manufacturer.findById",
        query = "SELECT m FROM Manufacturer m WHERE m.id = :id")
})
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Product> products;

    public boolean addProduct(Product product){
        if (products == null){
            products = new HashSet<>();
        }
        return products.add(product);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
