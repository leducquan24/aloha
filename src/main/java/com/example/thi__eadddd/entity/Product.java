package com.example.thi__eadddd.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private  long productID;
    private String productName;
    private String description;
    private Date dateOfMan;
    private double price;

}
