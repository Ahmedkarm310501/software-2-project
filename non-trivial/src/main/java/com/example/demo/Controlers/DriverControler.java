package com.example.demo.Controlers;
import Entites.*;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Services.DriverService;
@RestController
@RequestMapping(value="DriverControler")
public class DriverControler {
    Response response=new Response();

    @PostMapping("/deposit/{ammount}")
    public Response deposit(@PathVariable float ammount){
        boolean status=DriverService.deposit(ammount);
        if(status) {
			response.setMessage("Done");
			response.setStatus(true);
		}else {
			response.setMessage("Login first");
			response.setStatus(false);
		}
        return response;
    }
    @GetMapping("/show_all_requests")
	public ArrayList<ride> show_all_requests(){
		return  DriverService.show_all_requests();
	}

    


}
