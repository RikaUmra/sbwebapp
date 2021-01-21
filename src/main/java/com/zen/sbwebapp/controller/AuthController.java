package com.zen.sbwebapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {

	@PostMapping("/auth")
	public boolean check(@RequestBody User user) {
		if(user.getLogin().equals("John") && user.getPassword().equals("123"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
