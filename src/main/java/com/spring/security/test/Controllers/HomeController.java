package com.spring.security.test.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/home","/"})
public class HomeController {
	
	
	
	@GetMapping({"","/normal"})
	public ResponseEntity<String>normalUser(){
		return ResponseEntity.ok("yes, i am normal user");
				
		
		
	}
	

	@GetMapping("/admin")
	public ResponseEntity<String>adminUser(){
		return ResponseEntity.ok("Yes, i am admin user");
		
	}
	

	@GetMapping("/public")
	public ResponseEntity<String>publicUser(){
		return ResponseEntity.ok("Yes, i am public user");
		
	}

	
	

}
