package com.ejercicio.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.crud.dto.Message;
import com.ejercicio.crud.dto.Party;
import com.ejercicio.crud.dto.User;
import com.ejercicio.crud.service.MessageServiceImpl;
import com.ejercicio.crud.service.PartyServiceImpl;
import com.ejercicio.crud.service.UserServiceImpl;



@RestController
@RequestMapping("/api")
public class PartyController {
	
	@Autowired
	PartyServiceImpl PartyServideImpl;
	//Muestra lista Users
	@GetMapping("/Party")
	public List<Party> listarParty(){
		return PartyServideImpl.listarParty();
	}
	
	
	
}