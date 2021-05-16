package com.company.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class ProductSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private Date saleDate;
    @NonNull
    private int quantity;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ProductID")
    private Product product;

    @Override
    public String toString() {
        return "ProductSale{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", quantity=" + quantity +
                '}';
    }
}
