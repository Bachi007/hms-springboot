package com.hms.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hms.model.user;
import com.hms.repository.userRepository;

@Service
public class myuserDetailsService implements UserDetailsService {

	@Autowired
	private userRepository userepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		user u1=userepo.findByUserName(username);
		
		return new org.springframework.security.core.userdetails
				.User(u1.getUserName(), u1.getUserPassword(), new ArrayList<>());
		
	}

}
