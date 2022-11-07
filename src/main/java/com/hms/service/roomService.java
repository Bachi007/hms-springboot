package com.hms.service;

import java.util.List;

import com.hms.dto.roomDTO;
import com.hms.exception.globalException;
import com.hms.model.room;

public interface roomService {

	public room addRoom(roomDTO r1);
	public List<room> getRoom();
	public room updateRoom(roomDTO r1);
	public String deleteRoom(int roomid) throws globalException;
	
}
