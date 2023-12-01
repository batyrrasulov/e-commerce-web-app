package com.gcu.service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.*;
import com.gcu.model.UserStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	private UserDataService service;
	
	@Autowired
	private UserStatus userStatus;

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		UserEntity user = service.findByUsername(username);
		
		if(user!=null)
		{
			System.out.println(new BCryptPasswordEncoder().encode(user.getPassword()));
			List<GrantedAuthority>authorities = new ArrayList<GrantedAuthority>();
			if(user.isAdmin())
				authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			else 
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else
		{
			throw new UsernameNotFoundException("username not found");
		}
	}
}
