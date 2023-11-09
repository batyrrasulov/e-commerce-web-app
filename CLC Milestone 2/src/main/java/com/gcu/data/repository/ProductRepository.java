package com.gcu.data.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.gcu.data.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> 
{
    List<ProductEntity> findByCategory(String category);

}
