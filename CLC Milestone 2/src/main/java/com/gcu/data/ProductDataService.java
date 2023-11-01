package com.gcu.data;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductRepository;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {

	
	private ProductRepository productRepository;
	
	public ProductDataService (ProductRepository productRepository, DataSource dataSource)
	{
		this.productRepository = productRepository;
	}
	
	
	public List<ProductEntity> findAll() {
		List<ProductEntity> products = new ArrayList<ProductEntity>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	
	public ProductEntity findbyId(long id) {
		Optional<ProductEntity> result = productRepository.findById(id);
		
		if(result.isPresent())
			return result.get();
		
		return null;
	}	

	
	public boolean create(ProductEntity product) {
		if(product == null)
			return false;
		productRepository.save(product);
		return true;
	}

	
	public boolean update(ProductEntity product) {
		ProductEntity productDB = productRepository.findById(product.getProductID()).get();
		
		if(productDB == null)
			return false;
		
		if (product.getName() != null && product.getName() != "") {
            productDB.setName(product.getName());
        }
		if (product.getDescription() != null && product.getDescription() != "") {
            productDB.setDescription(product.getDescription());
        }
		if (product.getCategory() != null && product.getCategory() != "") {
            productDB.setCategory(product.getCategory());
        }
		
        productDB.setQuantity(productDB.getQuantity()+product.getQuantity());
        
        if(product.getPrice() != 0)
        {
        	productDB.setPrice(product.getPrice());
        }
		productRepository.save(productDB);
		return true;
	}

	
	public boolean delete(ProductEntity product) {
		if(product == null)
			return false;
		productRepository.delete(product);
		return true;
	}

}
