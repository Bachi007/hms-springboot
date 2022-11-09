package com.hms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dto.userDTO;
import com.hms.exception.globalException;
import com.hms.model.user;
import com.hms.repository.userRepository;
import com.hms.service.userService;
import com.hms.util.valueMapper;

@Service
public class userServiceImpl implements userService {

	@Autowired
	
	private userRepository userrepo;
	
	
	//adding user to db
	public user addUser(userDTO u1) {
		user u2=valueMapper.convertoUser(u1);
		return userrepo.save(u2);
	}
	//retriving users from db
	public List<user> getUser(){
		return userrepo.findAll();
	}
	//update user
	public user updateUser(userDTO u1) {
		user u2=valueMapper.convertoUser(u1);
		return userrepo.save(u2);
	}
	//delete the user
	public String deleteUser(int userid) throws globalException
	{
		user u2=userrepo.findByUserId(userid);
		if(u2!=null) {
			userrepo.deleteById(userid);
			return "deleted";
		}
		else {
			throw new globalException("user not found");
		}
	}
	@Override
	public String updatePhone(int userid, String phone) throws globalException {
		
		int st=userrepo.updatePhone(userid, phone);
		if(st==1) {
			return "updated!...";
		}
		else {
			throw new globalException("something went wrong");
		}
	}
	@Override
	public String allotRoom(int userid, int roomid) throws globalException {
		int st=userrepo.allotRoom(userid, roomid);
		if(st==1) {
			return "Room Alloted to "+userid;
		}
		else {
			throw new globalException("something went wrong");
		}
	}
	@Override
	public String updateFee(int userid, int userfee) throws globalException {
		int st=userrepo.updateFee(userid, userfee);
		if(st==1) {
			return "Fee Updated to "+userid;
		}
		else {
			throw new globalException("something went wrong");
		}

	}
}
