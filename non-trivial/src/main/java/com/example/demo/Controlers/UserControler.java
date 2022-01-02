package com.example.demo.Controlers;
import Entites.*;
import Services.UserService;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="UserControler")
public class UserControler {

    Response response=new Response();

    @PostMapping("/requestSingleRide/{source}/{destination}/{num}")
    public Response requestSingleRide(@PathVariable String source,@PathVariable 
     String destination, @PathVariable int num){
        boolean status=UserService.requestSingleRide(source, destination, num);
        if(status) {
			response.setMessage("Request added");
			response.setStatus(true);
		}else {
			response.setMessage("No driver in source area");
			response.setStatus(false);
		}
        return response;
    }


    @PostMapping("/requestMultiRide/{source}/{destination}/{num}")
    public Response requestMultiRide(@PathVariable("source")String source,@PathVariable("destination")
     String destination, @PathVariable("num")int num){
        boolean status=UserService.requestMultiRide(source, destination, num);
        if(status) {
			response.setMessage("Request added");
			response.setStatus(true);
		}else {
			response.setMessage("No driver in source area");
			response.setStatus(false);
		}
        return response;
    }

    @PostMapping("/deposit/{ammount}")
    public Response deposit(@PathVariable float ammount){
        boolean status=UserService.deposit(ammount);
        if(status) {
			response.setMessage("Done");
			response.setStatus(true);
		}else {
			response.setMessage("Login first");
			response.setStatus(false);
		}
        return response;
    }

	
}