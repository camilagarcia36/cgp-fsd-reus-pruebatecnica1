package com.ejercicio.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.crud.dto.Party;

public interface IPartyDAO extends JpaRepository<Party, Long> {

}
