package com.ejercicio.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.crud.dto.Game;
import com.ejercicio.crud.service.GameServiceImpl;



@RestController
@RequestMapping("/api")
public class GameController {

	@Autowired
	GameServiceImpl GameServideImpl;
	
	@GetMapping("/Game")
	public List<Game> listarGames(){
		return GameServideImpl.listarGame();
	}
	
	
	
}