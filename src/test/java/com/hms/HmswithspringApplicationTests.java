package com.hms;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hms.exception.globalException;
import com.hms.serviceImpl.userServiceImpl;

@SpringBootTest
class HmswithspringApplicationTests {

	@Autowired
	private userServiceImpl service;
	
	@Test
	void testDelete()throws globalException {
		
		var expected="deleted";
			var actual=service.deleteUser(4);
			assertSame(expected,actual);
		
		
		
		

		
	}

}
