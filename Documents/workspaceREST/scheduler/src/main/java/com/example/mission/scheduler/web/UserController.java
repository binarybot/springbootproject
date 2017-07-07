package com.example.mission.scheduler.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.mission.scheduler.auth.domain.User;
import com.example.mission.scheduler.auth.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/","/login"},method=RequestMethod.GET,produces="application/json")
	public  String login(){
		//String modelAndView = "Welcome to login page";
		return "login page";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public void registration(){
		//User user = new User();
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String createNewUser(@Valid User user, BindingResult bindingResult){
		User userExist = userService.findUserByEmail(user.getEmail());
		
		if(bindingResult.hasErrors() & !bindingResult.hasFieldErrors("roles")){
			System.out.println(bindingResult.getAllErrors());
			return "{ Content: form has error }";
		}
		
		userService.addUser(user);
		
		return "redirect:/result";
	}
	
	@RequestMapping(value="/user/{firstName}",method=RequestMethod.GET)
	public List<User> getUser(@PathVariable String firstName){
		System.out.println("***********************");
		List<User> user = userService.findUserByfirstName(firstName);
		if(!user.equals(null)){
			System.out.println("null object returned");
		}
		return user;
		}
	
	@RequestMapping(value="/user/mail/{email}",method=RequestMethod.GET)
	public User getUserMail(@PathVariable String email){
		System.out.println("***********************");
		User user = userService.findUserByEmail(email);
		if(!user.equals(null)){
			System.out.println("not null object returned" + user.getEmail());
		}else{
			System.out.println("not get object");
		}
		return user;
		}
}
