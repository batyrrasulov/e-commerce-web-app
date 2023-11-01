package com.gcu.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.gcu.data.entity.UserEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserEntity user = new UserEntity();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("FirstName"));
        user.setLastName(rs.getString("LastName"));
        user.setEmail(rs.getString("Email"));
        user.setPhoneNumber(rs.getString("PhoneNumber"));
        user.setUsername(rs.getString("Username"));
        user.setPassword(rs.getString("Password"));
        return user;
    }
}
