package com.ejercicio.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.crud.dto.Message;
import com.ejercicio.crud.service.MessageServiceImpl;



@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	MessageServiceImpl MessageServideImpl;
	
	@GetMapping("/Messages")
	public List<Message> listarMessages(){
		return MessageServideImpl.listarMessage();
	}
	
	
	
}