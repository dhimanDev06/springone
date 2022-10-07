package com.example.sep26;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	private MainService ms;
	
	
	@GetMapping("/alluser")
	public ResponseEntity <Users> getAlluser() {
		Users xx = ms.findAlluser().get();
		return new ResponseEntity<>(xx, HttpStatus.OK);
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity <List<Usereducation>> getAlluserlist() {
		List<Usereducation> xx = ms.getAlluserlist();
		return new ResponseEntity<>(xx, HttpStatus.OK);
	}
	
	@PostMapping("/adduser")
	public Users saveUser(@RequestBody Users u) {
		return  ms.saveUser(u);
	}
	
	
	@GetMapping("/allcourse")
	public ResponseEntity<List<Usereducation>> getAllcourse() {
		List<Usereducation> xx = ms.findAllcourse();
		return new ResponseEntity<>(xx, HttpStatus.OK);
	}
	
	@PostMapping("/addcourse")
	public Usereducation saveUser(@RequestBody Usereducation course) {
		return ms.saveCourse(course);
	}
}
