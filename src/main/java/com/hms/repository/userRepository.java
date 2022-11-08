package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hms.model.user;

public interface userRepository extends JpaRepository<user,Integer> {

	
	@Transactional 
	@Modifying
	@Query(value="update user set user_phone=:userphone where user_id=:userid")
	int updatePhone(int userid,String userphone);
	
	@Transactional 
	@Modifying
	@Query(value="update user set user_room_room_id=:roomid where user_id=:userid")
	int allotRoom(int userid,int roomid);
	
	
	
	@Query(value="select * from user where user_id=?1",nativeQuery=true)
	user findByUserId(int userid);
	
	
}
