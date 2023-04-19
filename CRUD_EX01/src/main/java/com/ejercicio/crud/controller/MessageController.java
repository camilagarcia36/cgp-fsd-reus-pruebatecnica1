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

import com.ejercicio.crud.service.MessageServiceImpl;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	MessageServiceImpl MessageServiceImpl;

	@GetMapping("/Messages")
	public List<Message> listarMessages() {
		return MessageServiceImpl.listarMessage();
	}

	// Añadir Message desde json
	@PostMapping("/Messages")
	public Message salvarMessage(@RequestBody Message Message) {

		return MessageServiceImpl.guardarMessage(Message);
	}

	// Get Messages por id
	@GetMapping("/Messages/{id_Message}")
	public Message MessageXID(@PathVariable(name = "id_Message") Long id_Message) {

		Message Message_xid = new Message();

		Message_xid = MessageServiceImpl.messageXID(id_Message);

		System.out.println("Message XID: " + Message_xid);

		return Message_xid;
	}

	// Añadir Message por id
	@PutMapping("/Messages/{id_Message}")
	public Message actualizarMessage(@PathVariable(name = "id_Message") Long id_Message, @RequestBody Message Message) {

		Message Message_seleccionado = new Message();
		Message Message_actualizado = new Message();

		Message_seleccionado = MessageServiceImpl.messageXID(id_Message);

		Message_seleccionado.setContent(Message.getContent());

		Message_seleccionado.setDate(Message.getDate());

		Message_actualizado = MessageServiceImpl.actualizarMessage(Message_seleccionado);

		System.out.println("El Message actualizado es: " + Message_actualizado);

		return Message_actualizado;
	}

	@DeleteMapping("/Messages/{id_Message}")
	public void eleiminarMessage(@PathVariable(name = "id_Message") Long id_message) {
		MessageServiceImpl.eliminarMessage(id_message);
	}

}