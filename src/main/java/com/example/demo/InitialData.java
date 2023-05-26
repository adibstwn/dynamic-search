//package com.example.demo;
//
//import com.example.demo.model.Product;
//import com.example.demo.repository.ProductRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//@Component
//public class InitialData {
//    @Autowired
//    ProductRepo productRepo;
//    @EventListener
//    public void appReady(ApplicationReadyEvent event) {
//        List<Product> products = Arrays.asList(
//                new Product((long)1,"electronic", "desc elect", 20),
//                new Product((long)2,"health care", "desc health", 30),
//                new Product((long)3,"sports", "desc sport", 40),
//                new Product((long)4,"food and drink", "desc food", 50),
//                new Product((long)5,"fashion", "desc fashion", 60)
//        );
//        productRepo.saveAll(products);
//    }
//}
