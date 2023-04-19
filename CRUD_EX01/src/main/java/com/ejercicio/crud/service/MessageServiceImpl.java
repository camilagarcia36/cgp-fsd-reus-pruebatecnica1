/**
 * 
 */
package com.ejercicio.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.crud.dao.IMessageDAO;
import com.ejercicio.crud.dto.Message;


/**
 * @author camila
 *
 */
@Service
public class MessageServiceImpl implements IMessageService{

	@Autowired
	IMessageDAO iMessageDAO; // me traigo el dao y dto en impots. 
	
	@Override
	public List<Message> listarMessage() {
		
		return iMessageDAO.findAll();
	}
	
	@Override
	public Message guardarMessage(Message Message) {
		
		return iMessageDAO.save(Message);
	}

	@Override
	public Message messageXID(Long id_message) {
		
		return iMessageDAO.findById(id_message).get();
	}

	@Override
	public Message actualizarMessage(Message Message) {
		
		return iMessageDAO.save(Message);
	}

	@Override
	public void eliminarMessage(Long id) {
		
		iMessageDAO.deleteById(id);
		
	}
}