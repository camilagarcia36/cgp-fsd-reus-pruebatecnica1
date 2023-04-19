package com.ejercicio.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.crud.dto.Message;


public interface IMessageDAO extends JpaRepository<Message, Long>{

}
