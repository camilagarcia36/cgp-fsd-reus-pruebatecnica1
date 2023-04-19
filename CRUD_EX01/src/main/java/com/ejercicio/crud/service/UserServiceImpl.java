/**
 * 
 */
package com.ejercicio.crud.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.crud.dao.IUserDAO;
import com.ejercicio.crud.dto.User;



/**
 * @author camila
 *
 */
@Service
public class UserServiceImpl implements IUserService{
	
	//Utilizamos los metodos de la interface IUserDAO
	@Autowired
	IUserDAO iUserDAO;
	
	@Override
	public List<User> listarUser() {
		
		return iUserDAO.findAll();
	}

	@Override
	public User guardarUser(User User) {
		
		return iUserDAO.save(User);
	}

	@Override
	public User userXID(Long id_user) {
		
		return iUserDAO.findById(id_user).get();
	}

	@Override
	public User actualizarUser(User User) {
		
		return iUserDAO.save(User);
	}

	@Override
	public void eliminarUser(Long id_user) {
		
		iUserDAO.deleteById(id_user);
		
	}

}