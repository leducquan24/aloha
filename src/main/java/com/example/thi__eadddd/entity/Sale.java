package com.example.thi__eadddd.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {
    private long saleId;
    private String saleManId;
    @JoinColumn(name = "productID")
    private Product product;
}
