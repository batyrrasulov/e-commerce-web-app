package com.gcu.data;

import java.util.*;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductRepository;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {

	
	private ProductRepository productRepository;
    private final JdbcTemplate jdbcTemplate;

    public ProductDataService(ProductRepository productRepository, DataSource dataSource) {
        this.productRepository = productRepository;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
		Optional<ProductEntity> optionalProductDB = productRepository.findById(product.getProductID());
		
		if(optionalProductDB.isEmpty())
			return false;
		
		ProductEntity productDB = optionalProductDB.get();
		
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
	@Override
	public List<ProductEntity> getProductsByCategory(String category) {
	    try {
	        System.out.println("Fetching products for category: " + category);
	        String query = "SELECT * FROM products WHERE category = ?";
	        List<ProductEntity> products = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ProductEntity.class), category);
	        System.out.println("Fetched products: " + products);
	        return products;
	    } catch (Exception e) {
	        System.err.println("Error fetching products by category: " + e.getMessage());
	        e.printStackTrace();
	        return Collections.emptyList();
	    }
	}

}
