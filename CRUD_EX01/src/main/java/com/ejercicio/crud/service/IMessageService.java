package com.ejercicio.crud.service;

import java.util.List;

import com.ejercicio.crud.dto.Message;



public interface IMessageService {
	//Metodos del CRUD
		public List<Message> listarMessage(); //Listar All 
		
		
		public Message guardarMessage(Message message);	//CREATE
		
		public Message messageXID(Long id_message); //READ
		
		public Message actualizarMessage(Message message); //UPDATE
		
		public void eliminarMessage(Long id_message);//DELETE
}
