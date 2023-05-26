package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllByIdentity(int page, int maxRow, String name, String desc, Integer qty);
}
