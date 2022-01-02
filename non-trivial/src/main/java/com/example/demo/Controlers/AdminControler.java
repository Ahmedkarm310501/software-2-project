package com.example.demo.Controlers;
import Entites.*;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Services.AdminService;

@RestController
@RequestMapping(value="AdminControler")
public class AdminControler {
	Response response=new Response();
	
	@PostMapping("/activateDriver/{email}")
	public Response activate_driver(@PathVariable("email") String email) {
		boolean status=AdminService.activate_driver(email);
		if(status) {
			response.setMessage("Driver account activated");
			response.setStatus(true);
		}else {
			response.setMessage("Driver not found");
			response.setStatus(false);
		}
		return response;
	}
	
	@GetMapping("/suspendedDrivers")
	public ArrayList<driver> list_suspended_drivers() {
		return AdminService.list_suspended_drivers();
	}
	
	@GetMapping("/list_suspended_users")
	public ArrayList<person> list_suspended_users(){
		return  AdminService.list_suspended_users();
	}

	@PostMapping("/suspend_person/{email}")
	public Response suspend_person(@PathVariable("email")  String email){
		boolean status=AdminService.suspend_person(email);
		if(status) {
			response.setMessage("User suspended");
			response.setStatus(true);
		}else {
			response.setMessage("User not found");
			response.setStatus(false);
		}
		return response;
	}
	@PostMapping("/activate_user/{email}")
	public Response activate_user(@PathVariable("email") String email){
		boolean status=AdminService.activate_user(email);
		if(status) {
			response.setMessage("User activated");
			response.setStatus(true);
		}else {
			response.setMessage("User not found");
			response.setStatus(false);
		}
		return response;
	}

	@GetMapping("/get_all_rides")
	public ArrayList<ride> get_all_rides(){
		return AdminService.get_all_rides();
	}


	@PostMapping("/add_discount_area/{email}")
	public Response add_discount_area(@PathVariable("email") String email) {
		AdminService.add_discount_area(email);
		response.setMessage("Done");
		response.setStatus(true);
		return response;
	}
	@GetMapping("/show_discount_areas")
	public ArrayList<String> show_discount_areas(){
		return AdminService.show_discount_areas();
	}
	@PostMapping("/add_discount_Holiday/{date}")
	public Response add_discount_Holiday(String date){
		AdminService.add_discount_Holiday(date);
		response.setMessage("Done");
		response.setStatus(true);
		return response;
	}

	@RequestMapping("/show_discount_Holiday")
	public ArrayList<String> show_discount_Holiday(){
		return AdminService.show_discount_Holiday();
	}


}