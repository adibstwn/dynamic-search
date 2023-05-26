package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo productRepo;
    @Override
    public List<Product> getAllByIdentity(int pages, int maxRow, String name, String desc, Integer qty) {
        Pageable pageable = PageRequest.of(pages - 1, maxRow);
        Page page = productRepo.findAll((Specification<Product>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
//            if(name!=null) {
//                predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("name"), "%"+name+"%")));
//            }
//            if (desc != null){
//                predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("description"), "%"+desc+"%")));
//            }
            if(name!=null || desc != null) {
                predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("name"), "%" + name + "%"),
                        criteriaBuilder.like(root.get("description"), "%" + desc + "%"),criteriaBuilder.greaterThan(root.get("qty"), qty)));
            }
//            if (qty > 0){
//                predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThan(root.get("qty"), qty)));
//            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        }, pageable);

        page.getTotalElements();        // get total elements
        page.getTotalPages();           // get total pages
        Integer ad = null;
        return page.getContent();       // get List of Product
    }
}
