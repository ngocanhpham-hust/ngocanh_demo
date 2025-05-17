package com.hust.demo.controller;

import com.hust.demo.model.Category;
import com.hust.demo.model.Product;
import com.hust.demo.model.Search;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @PostMapping("/search")
    public List<Product> searchProduct (@RequestBody Search request){
        Product product1 = new Product();

        product1.setId("1");
        product1.setProductName("Macbook");
        product1.setPrice(45);
        product1.setQuantity(5);
        product1.setDescription("new version");

        Product product2 = new Product();
        product2.setId("2");
        product2.setProductName("IPhone 16");
        product2.setPrice(40);
        product2.setQuantity(5);
        product2.setDescription("Blue color");

        List<Product> listProduct = new ArrayList<>();
        listProduct.add(product1);
        listProduct.add(product2);
        return listProduct;
    }

    @GetMapping("/category")
    public List<Category> getCategory () {
        Category category1 = new Category();
        category1.setId(1);
        category1.setCategoryName("Electronic");

        Category category2 = new Category();
        category2.setId(2);
        category2.setCategoryName("Fashion");

        List<Category> listCategory = new ArrayList<>();
        listCategory.add(category1);
        listCategory.add(category2);
        return listCategory;
    }

}
