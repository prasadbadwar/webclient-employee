package com.hdfc.ems.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hdfc/emsclient/")
public class WebEmployeeController {
	
	String url="http://localhost:9191/ems";
	WebClient client=WebClient.create(url);

	@GetMapping("/getemployeeinfo/{id}")
	public Mono<String> getEmployeeData(@PathVariable long id){
		Mono<String> mono=client.get().uri("/findemployee/"+id).retrieve().bodyToMono(String.class);
		return mono;
		
	}
}
