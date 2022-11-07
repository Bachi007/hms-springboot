package com.hms.util;

import com.hms.dto.roomDTO;
import com.hms.dto.userDTO;
import com.hms.model.room;
import com.hms.model.user;

public class valueMapper {

	
	public static user convertoUser(userDTO u1) {
		user u2=new user(u1.getUserId(), u1.getUserName(),u1.getUserPassword(),u1.getUserPhone(),u1.getUserEmail(),u1.getUserRole(),u1.getUserFee(),u1.getUserRoom());
		
		return u2;	
	}
	
	public static room convertoRoom(roomDTO r1) {
		
		room r2=new room(r1.getRoomId(),r1.getRoomName(),r1.getRoomType());
		return r2;
	}
	
	
}
