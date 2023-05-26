package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/list")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int maxRow,
                                    @RequestParam(required = false) String name, @RequestParam(required = false) String desc,
                                    @RequestParam(required = false) Integer qty){
        return ResponseEntity.ok(this.productService.getAllByIdentity(page, maxRow, name, desc, qty));
    }
}
