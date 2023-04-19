package com.ejercicio.crud.service;

import java.util.List;

import com.ejercicio.crud.dto.User;

;

public interface IUserService {
	//Metodos del CRUD
	public List<User> listarUser(); //Listar All 
	
	public User guardarUser(User user);	// CREATE
	
	public User userXID(Long id_user); // READ
	
	public User actualizarUser(User user); // UPDATE
	
	public void eliminarUser(Long id_user);// DELETE
	
}
