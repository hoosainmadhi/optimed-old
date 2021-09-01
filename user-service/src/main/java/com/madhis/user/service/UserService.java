package com.madhis.user.service;

import com.madhis.user.VO.Department;
import com.madhis.user.VO.ResponseTemplateVO;
import com.madhis.user.entity.User;
import com.madhis.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate; 
	
	public User saveUser(User user) {
		log.info("inside saveUser of UserService");
		return userRepository.save(user);
	}

	public User getUserByUserId(Long userId) {
		log.info("inside getUserByUserId of UserService");
		return  userRepository.getById(userId);
	}

	public ResponseTemplateVO getUserWithDepartment(long userId) {
		log.info("inside getUserWithDepartment of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user  = userRepository.findByUserId(userId);
	        System.out.println("user = " + user);	
		//rest call to get department 
		Department department = 
			restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),Department.class);
		vo.setUser(user);
		vo.setDepartment(department);

		return vo;
	}
	
}
