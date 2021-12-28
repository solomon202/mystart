package com.example.solit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.solit.entity.Product;
import com.example.solit.entity.ProductType;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findByProductType(ProductType productType);

}
