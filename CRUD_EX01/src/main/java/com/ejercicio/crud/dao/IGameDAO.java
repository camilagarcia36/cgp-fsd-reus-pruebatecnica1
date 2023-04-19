/**
 * 
 */
package com.ejercicio.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.crud.dto.Game;

/**
 * @author camila
 *
 */

public interface IGameDAO extends JpaRepository<Game, Long> {

}
