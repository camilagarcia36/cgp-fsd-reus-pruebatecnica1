package com.ejercicio.crud.service;

import java.util.List;

import com.ejercicio.crud.dto.Game;



public interface IGameService {
	//Metodos del CRUD
		public List<Game> listarGame(); //Listar All 
		
		
		public Game guardarGame(Game Game);	//CREATE
		
		public Game GameXID(Long id_game); //READ
		
		public Game actualizarGame(Game Game); //UPDATE
		
		public void eliminarGame(Long id_game);//DELETE
}
