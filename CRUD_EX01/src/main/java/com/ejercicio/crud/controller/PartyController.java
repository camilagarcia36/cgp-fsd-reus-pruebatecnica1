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

import com.ejercicio.crud.dto.Message;
import com.ejercicio.crud.dto.Party;
import com.ejercicio.crud.dto.Party;
import com.ejercicio.crud.service.MessageServiceImpl;
import com.ejercicio.crud.service.PartyServiceImpl;
import com.ejercicio.crud.service.PartyServiceImpl;



@RestController
@RequestMapping("/api")
public class PartyController {
	
	@Autowired
	PartyServiceImpl PartyServiceImpl;
	//Muestra lista Partys
	@GetMapping("/Party")
	public List<Party> listarParty(){
		return PartyServiceImpl.listarParty();
	}
	
	//Añadir Party desde json
		@PostMapping("/Party")
		public Party salvarParty(@RequestBody Party Party) {
			
			return PartyServiceImpl.guardarParty(Party);
		}
		
		//Get Partys por id 
		@GetMapping("/Party/{id_Party}")
		public Party PartyXID(@PathVariable(name="id_Party") Long id_Party) {
			
			Party Party_xid= new Party();
			
			Party_xid=PartyServiceImpl.PartyXID(id_Party);
			
			System.out.println("Party XID: "+Party_xid);
			
			return Party_xid;
		}
		
		//Añadir Party por id 
		@PutMapping("/Party/{id_Party}")
		public Party actualizarParty(@PathVariable(name="id_Party")Long id_Party,@RequestBody Party Party) {
			
			Party Party_seleccionado= new Party();
			Party Party_actualizado= new Party();
			
			Party_seleccionado= PartyServiceImpl.PartyXID(id_Party);
			
			Party_seleccionado.setPartyTitle(Party.getPartyTitle());
			
			Party_actualizado = PartyServiceImpl.actualizarParty(Party_seleccionado);
			
			System.out.println("El Party actualizado es: "+ Party_actualizado);
			
			return Party_actualizado;
		}
		
		@DeleteMapping("/Party/{id_Party}")
		public void eleiminarParty(@PathVariable(name="id_Party")Long id_Party) {
			PartyServiceImpl.eliminarParty(id_Party);
		}
		
	
	
}