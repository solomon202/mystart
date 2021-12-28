package com.example.solit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.solit.entity.ProductType;

import java.util.List;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {

}
