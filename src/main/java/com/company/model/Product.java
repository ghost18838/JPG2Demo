package com.company.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String title;
    @NonNull
    private double cost;
    @NonNull
    private String description;
    @NonNull
    private String mainImagePath;
    @NonNull
    private int isActive;

    @OneToMany(mappedBy = "product")
    Set<ProductSale> productSales;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ManufacturerID")
    private Manufacturer manufacturer;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", varchar='" + title + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", mainImagePath='" + mainImagePath + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
