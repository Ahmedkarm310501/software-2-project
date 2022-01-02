package com.example.demo.Controlers;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Services.*;

import Entites.*;


@RestController
@RequestMapping(value="AccountControler")
public class AccountControler {
	Account system = Account.getInstance();
	Response response=new Response();
	
	@PostMapping("/Account/registerUser/{username}/{password}/{number}/{email}/{birthday}")
	public Response registerUser(@PathVariable String username,@PathVariable String password,
			@PathVariable String number,@PathVariable String email,
			@PathVariable String birthday){
		user User = new user(username, password, number, email, birthday, system);
		if(AccountService.registerUser(User)) {
			response.setMessage("User added successfuly");
			response.setStatus(true);
		}else {
			response.setMessage("User already exist");
			response.setStatus(false);
		}
		return response;
	}
	@GetMapping("/m")
	public ArrayList<String> m() {
		ArrayList<String>a=new ArrayList();
		a.add("ahmed");
		a.add("mohamed");
		return a;
	}
	
	@PostMapping("/Account/registerdriver/{username}/{password}/{number}/{email}/{driving_licence}/{national_id}")
	public Response registerDriver(@PathVariable("username") String username,
	@PathVariable("password")String password,
	@PathVariable("number") String number,@PathVariable("email") String email,
	@PathVariable("driving_licence") String driving_licence,@PathVariable("national_id") String national_id){
		driver driver = new driver(username, password, number, email,driving_licence,national_id,  system);
		if(AccountService.registerDriver(driver)) {
			response.setMessage("Driver added successfuly wait admin to activate you");
			response.setStatus(true);
		}else {
			response.setMessage("Driver already exist");
			response.setStatus(false);
		}
		return response;
	}
	
	@PostMapping("/Account/loginUser/{email}/{password}")
	public Response loginUser(@PathVariable("email") String email,@PathVariable("password") String password) {
		int status=AccountService.loginUser(email, password);
		if(status==1) {
			response.setMessage("login success");
			response.setStatus(true);
		}else if(status==0) {
			response.setMessage("You are suspended");
			response.setStatus(false);
		}else {
			response.setMessage("user not found");
			response.setStatus(false);
		}
		return response;
	}
	
	@PostMapping("/Account/loginDriver/{email}/{password}")
	public Response loginDriver(@PathVariable("email") String email,@PathVariable("password") String password) {
		int status=AccountService.loginDriver(email, password);
		if(status==1) {
			response.setMessage("login success");
			response.setStatus(true);
		}else if(status==0) {
			response.setMessage("You are suspended");
			response.setStatus(false);
		}else {
			response.setMessage("user not found");
			response.setStatus(false);
		}
		return response;
	}
	@GetMapping("/logout")
	public Response logout() {
		system.setCuurent_user(null);
		response.setMessage("you logged out");
		response.setStatus(true);
		return response;
	}
	
	
	@PostMapping("/Account/loginAdmin/{ID}/{password}")
	public Response loginAdmin(@PathVariable("ID") String email,@PathVariable("password") String password) {
		int status=AccountService.loginAdmin(email, password);
		if(status==1) {
			response.setMessage("login success");
			response.setStatus(true);
		}else if(status==0) {
			response.setMessage("wrong data");
			response.setStatus(false);
		}else {
			response.setMessage("logout first");
			response.setStatus(false);
		}
		return response;
	}
	

		
}
