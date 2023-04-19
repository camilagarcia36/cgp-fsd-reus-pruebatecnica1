/**
 * 
 */
package com.ejercicio.crud.controller;

/**
 * @author camila
 *
 */
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

import com.ejercicio.crud.dto.User;
import com.ejercicio.crud.service.UserServiceImpl;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserServiceImpl UserServideImpl;
	//Muestra lista Users
	@GetMapping("/Users")
	public List<User> listarUsers(){
		return UserServideImpl.listarUser();
	}
	//Añadir User desde json
	@PostMapping("/Users")
	public User salvarUser(@RequestBody User User) {
		
		return UserServideImpl.guardarUser(User);
	}
	
	//Get Users por id 
	@GetMapping("/Users/{id_user}")
	public User UserXID(@PathVariable(name="id_user") Long id_user) {
		
		User User_xid= new User();
		
		User_xid=UserServideImpl.userXID(id_user);
		
		System.out.println("User XID: "+User_xid);
		
		return User_xid;
	}
	
	//Añadir User por id 
	@PutMapping("/Users/{id_user}")
	public User actualizarUser(@PathVariable(name="id_user")Long id_user,@RequestBody User User) {
		
		User User_seleccionado= new User();
		User User_actualizado= new User();
		
		User_seleccionado= UserServideImpl.userXID(id_user);
		
		User_seleccionado.setUsername(User.getUsername());
		User_seleccionado.setPassword(User.getPassword());
		User_seleccionado.setEmail(User.getEmail());
		User_seleccionado.setSteam_user(User.getSteam_user());
		
		User_actualizado = UserServideImpl.actualizarUser(User_seleccionado);
		
		System.out.println("El User actualizado es: "+ User_actualizado);
		
		return User_actualizado;
	}
	
	@DeleteMapping("/Users/{id_user}")
	public void eleiminarUser(@PathVariable(name="id_user")Long id_user) {
		UserServideImpl.eliminarUser(id_user);
	}
	
}