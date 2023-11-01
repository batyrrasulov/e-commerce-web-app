package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.data.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> 
{
	
}
