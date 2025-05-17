package com.hust.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Search {
    private String searchString;
    private int categoryID;
    private long priceFrom;
    private long priceTo;
    private int pageIndex;
    private int pageSize;
}
