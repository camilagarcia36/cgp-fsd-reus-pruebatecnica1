package com.ejercicio.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.crud.dto.User;

public interface IUserDAO extends JpaRepository<User, Long>{

}
