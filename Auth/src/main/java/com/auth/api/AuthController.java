package com.auth.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.vo.LoginVo;

@RestController
public class AuthController {

	
	@PostMapping(path="/")
	public ResponseEntity<Void> login2( LoginVo login) {
	
		System.out.println(login.getEmail());
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	
	}
	

	@GetMapping(path="/test")
	public ResponseEntity<Void> login3() {
	
		System.out.println("gd");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	
	}
}
