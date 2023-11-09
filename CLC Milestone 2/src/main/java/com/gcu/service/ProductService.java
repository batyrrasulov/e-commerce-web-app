package com.gcu.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.DataAccessInterface;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

@Service
public class ProductService {
	
	@Autowired 
	private DataAccessInterface<ProductEntity> service;
	
	public List<ProductModel> findAll()
	{
		List<ProductEntity> entities = service.findAll();
		List<ProductModel> products = new ArrayList<ProductModel>();
		for(ProductEntity entity: entities)
		{
			products.add(new ProductModel(entity.getProductID(),entity.getName(),entity.getQuantity(),entity.getDescription(),entity.getPrice(),entity.getCategory()));
		}
		return products;
	}
	
	public ProductModel findbyId(long id)
	{
		ProductEntity entity = service.findbyId(id);
		return new ProductModel(entity.getProductID(),entity.getName(),entity.getQuantity(),entity.getDescription(),entity.getPrice(),entity.getCategory());
	}
	
	public boolean create(ProductModel product)
	{
		ProductEntity entity = new ProductEntity(product.getId(),product.getName(),product.getQuantity(),product.getPrice(),product.getDescription(),product.getCategory());
		return service.create(entity);
	}
	public boolean update(ProductModel product)
	{
		ProductEntity entity = new ProductEntity(product.getId(),product.getName(),product.getQuantity(),product.getPrice(),product.getDescription(),product.getCategory());
		return service.update(entity);
	}
	public boolean delete(ProductModel product)
	{
		ProductEntity entity = new ProductEntity(product.getId(),product.getName(),product.getQuantity(),product.getPrice(),product.getDescription(),product.getCategory());
		return service.delete(entity);
	}
	public List<ProductModel> getProductsByCategory(String category) {
       
        List<ProductEntity> entities = service.getProductsByCategory(category);

        List<ProductModel> products = new ArrayList<>();
        for (ProductEntity entity : entities) {
            products.add(new ProductModel(entity.getProductID(), entity.getName(), entity.getQuantity(),
                    entity.getDescription(), entity.getPrice(), entity.getCategory()));
        }
        return products;
    }
}
