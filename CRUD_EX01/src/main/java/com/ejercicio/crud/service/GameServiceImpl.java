/**
 * 
 */
package com.ejercicio.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.crud.dao.IGameDAO;
import com.ejercicio.crud.dto.Game;


/**
 * @author camila
 *
 */
@Service
public class GameServiceImpl implements IGameService{

	@Autowired
	IGameDAO iGameDAO; // me traigo el dao y dto en impots. 
	
	@Override
	public List<Game> listarGame() {
		
		return iGameDAO.findAll();
	}
	
	@Override
	public Game guardarGame(Game Game) {
		
		return iGameDAO.save(Game);
	}

	@Override
	public Game GameXID(Long id_game) {
		
		return iGameDAO.findById(id_game).get();
	}

	@Override
	public Game actualizarGame(Game Game) {
		
		return iGameDAO.save(Game);
	}

	@Override
	public void eliminarGame(Long id_game) {
		
		iGameDAO.deleteById(id_game);
		
	}
}