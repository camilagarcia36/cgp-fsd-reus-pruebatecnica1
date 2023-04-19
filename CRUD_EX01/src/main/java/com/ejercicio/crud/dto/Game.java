/**
 * 
 */
package com.ejercicio.crud.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author camila
 *
 */
@Entity
@Table(name="games")//en caso que la tabla sea diferente
public class Game {

	//Atributos de entidad messages
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long id_game;
		@Column(name = "game_title")//no hace falta si se llama igual
		private String gameTitle;
		@Column(name = "description")//no hace falta si se llama igual
		private String description;
		
		
	    @ManyToOne
	    @JoinColumn(name="party_id")
	    private Party party;


	    public Game() {}
		public Game(Long id_game, String gameTitle, String description) {
			super();
			this.id_game = id_game;
			this.gameTitle = gameTitle;
			this.description = description;
		
		}


		/**
		 * @return the id_game
		 */
		public Long getId_game() {
			return id_game;
		}


		/**
		 * @param id_game the id_game to set
		 */
		public void setId_game(Long id_game) {
			this.id_game = id_game;
		}


		/**
		 * @return the gameTitle
		 */
		public String getGameTitle() {
			return gameTitle;
		}


		/**
		 * @param gameTitle the gameTitle to set
		 */
		public void setGameTitle(String gameTitle) {
			this.gameTitle = gameTitle;
		}


		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}


		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}





}
	   