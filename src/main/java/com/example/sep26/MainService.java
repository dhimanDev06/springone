package com.example.sep26;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sep26.userRepo;

@Service
public class MainService {
	
	@Autowired
	private userRepo usersrepo;
	
	@Autowired
	private educationRepo courseRepo;
	
	@Autowired
	private UserEducationRepo userEduRepo;
	
	public Optional<Users> findAlluser(){
//		return usersrepo.findAll();
		return usersrepo.findById(1);
	}
	
	public List<Usereducation> getAlluserlist(){
		return userEduRepo.findAll();
	}
	
	public Users saveUser(Users u) {
		usersrepo.save(u);
		return u;
	}
	
	
	public Usereducation saveCourse(Usereducation course) {
		courseRepo.save(course);
		return course;
	}
	public List<Usereducation> findAllcourse(){
		return courseRepo.findAll();
	}
}
