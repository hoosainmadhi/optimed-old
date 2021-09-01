package com.madhis.user.controller;

import com.madhis.user.VO.ResponseTemplateVO;
import com.madhis.user.entity.User;
import com.madhis.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	//save user
	@PostMapping("/")
	public User saveUser(@RequestBody User user){
		log.info("inside saveUser of UserController");
		return userService.saveUser(user);
	}

	//get user with department
	@GetMapping("{id}")
	public  ResponseTemplateVO getUserWithDepartment(@PathVariable("id")Long userId){
		System.out.println("userId = " + userId);
		log.info("inside getUserWithDepartment of UserController");
		return userService.getUserWithDepartment(userId);
	} 
	
}
