package com.ejercicio.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.crud.dto.Game;
import com.ejercicio.crud.service.GameServiceImpl;

@RestController
@RequestMapping("/api")
public class GameController {

	@Autowired
	GameServiceImpl GameServiceImpl;

	@GetMapping("/Games")
	public List<Game> listarGames() {
		return GameServiceImpl.listarGame();
	}

	// Añadir Game desde json
	@PostMapping("/Games")
	public Game salvarGame(@RequestBody Game Game) {

		return GameServiceImpl.guardarGame(Game);
	}

	// Get Games por id
	@GetMapping("/Games/{id_game}")
	public Game GameXID(@PathVariable(name = "id_game") Long id_game) {

		Game Game_xid = new Game();

		Game_xid = GameServiceImpl.GameXID(id_game);

		System.out.println("Game XID: " + Game_xid);

		return Game_xid;
	}

	// Añadir Game por id
	@PutMapping("/Games/{id_Game}")
	public Game actualizarGame(@PathVariable(name = "id_Game") Long id_Game, @RequestBody Game Game) {

		Game Game_seleccionado = new Game();
		Game Game_actualizado = new Game();

		Game_seleccionado = GameServiceImpl.GameXID(id_Game);

		Game_seleccionado.setDescription(Game.getDescription());
		Game_seleccionado.setGameTitle(Game.getGameTitle()); 

		Game_actualizado = GameServiceImpl.actualizarGame(Game_seleccionado);

		System.out.println("El Game actualizado es: " + Game_actualizado);

		return Game_actualizado;
	}

	@DeleteMapping("/Games/{id_Game}")
	public void eleiminarGame(@PathVariable(name = "id_Game") Long id_Game) {
		GameServiceImpl.eliminarGame(id_Game);
	}

}