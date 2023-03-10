package com.example.mysqlDemo.Service;

import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileManagementService {
	@Autowired
    private final UserRepository userRepo;
	
	public ProfileManagementService(UserRepository userRepo){
		this.userRepo= userRepo;
    }
	
	// http method
	public User getUser(String username){
        Optional<User> optionalUser = retrieveUser(username);
        User user = optionalUser.orElse(new User());
        return user;
    }	
	
	// for post 
	public String addUser(String name, String email, String homeAddress, String username, String password ){
		
		User newUser = new User();
		newUser.setEmail(email);
		newUser.setHomeAddress(homeAddress);
		newUser.setName(name);
		newUser.setUsername(username);
		newUser.setPassword(password);
		
		userRepo.save(newUser);
		return "saved";
    }
	
	// helper method
	// for get
	public Optional<User> retrieveUser(String username) {
	    return userRepo.findById(username);
	}
	
	
	public void saveUser() {
		
		
	}
	

	
	
 
}