package com.hms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.hms.model.room;
import com.hms.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class userDTO {

	@NotNull(message="user id cannot be null")
	private int userId;
	@NotNull(message="user name cannot be null")
	private String userName;
	@Pattern(regexp="[a-zA-Z0-9@#]{6,15}")
	private String userPassword;
	@Pattern(regexp="[0-9]{10}")
	private String userPhone;
	@Email
	private String userEmail;
	@NotNull(message="role cannot be empty")
	private String userRole;
	@Min(1000)
	@Max(6000)
	private int userFee;
	
	private room userRoom;
}
