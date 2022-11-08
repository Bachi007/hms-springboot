package com.hms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dto.userDTO;
import com.hms.exception.globalException;
import com.hms.model.user;
import com.hms.serviceImpl.userServiceImpl;

@RestController
@RequestMapping("/user")
public class userController {

	@Autowired
	private userServiceImpl service;
	
	@GetMapping("/get")
	public ResponseEntity<List<user>> getUsers(){	
		List<user> userList=service.getUser();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<user> addUsers(@RequestBody @Valid userDTO u1){
		
		return new ResponseEntity<>(service.addUser(u1),HttpStatus.ACCEPTED);
		
	}

	@PutMapping("/update")
	public ResponseEntity<user> updateUser(@RequestBody @Valid userDTO u1){
		return new ResponseEntity<>(service.updateUser(u1),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable int userid) throws globalException{
		
		String status=service.deleteUser(userid);
		if(status!=null) {
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/phone/{id}/{phone}")
	
	public ResponseEntity<String> updatePhone(@PathVariable int id,@PathVariable String phone) throws globalException{
		
		return new ResponseEntity<>(service.updatePhone(id, phone),HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
}
