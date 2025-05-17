package com.hust.demo.model;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private String id;
    private String productName;
    private long price;
    private int quantity;
    private String description;
}
