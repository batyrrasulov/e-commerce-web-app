package com.gcu.data.mapper;

import java.sql.*;
import org.springframework.jdbc.core.RowMapper;
import com.gcu.data.entity.ProductEntity;

public class ProductRowMapper implements RowMapper<ProductEntity> {	
	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNumber) throws SQLException
	{
		return new ProductEntity(rs.getLong("ProductID"),rs.getString("Name"), rs.getInt("Quantity"), rs.getFloat("Price"),rs.getString("Description"),rs.getString("Category"));
	}
}
