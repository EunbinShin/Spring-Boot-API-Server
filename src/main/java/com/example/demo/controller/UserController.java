package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.User;
import com.example.demo.repository.UserJpaRepo;

@Controller
public class UserController {

		@Autowired
		UserJpaRepo userJpaRepo;
	
		@PostMapping("/user")
		public User save() {
			User user = User.builder()
					.email("test@naver.com")
					.name("테스트")
					.build();
			
			return userJpaRepo.save(user);
		}
		
		@GetMapping("/findUser/{name}")
		@ResponseBody
		public User findUserByName(@PathVariable String name) {
			return userJpaRepo.findByName(name);
		}
}
