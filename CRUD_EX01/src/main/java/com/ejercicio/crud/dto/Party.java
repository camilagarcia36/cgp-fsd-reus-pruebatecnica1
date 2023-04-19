package com.ejercicio.crud.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "parties") // en caso que la tabla sea diferente
public class Party {

	// Atributos de entidad Partys
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private Long id_party;
	@Column(name = "party_title") // no hace falta si se llama igual
	private String partyTitle;

	@OneToMany
	@JoinColumn(name = "id_party")
	private List<Game> game;

	@OneToMany
	@JoinColumn(name = "id_party")
	private List<Message> message;
	
	@OneToMany
	@JoinColumn(name = "id_party")
	private List<User> user;
	
	// Constructores

	public Party() {

	}

	public Party(Long id_party, String partyTitle, List<Game> game) {
		super();
		this.id_party = id_party;
		this.partyTitle = partyTitle;
		this.game = game;
	}

	/**
	 * @return the id_party
	 */
	public Long getId_party() {
		return id_party;
	}

	/**
	 * @param id_party the id_party to set
	 */
	public void setId_party(Long id_party) {
		this.id_party = id_party;
	}

	/**
	 * @return the partyTitle
	 */
	public String getPartyTitle() {
		return partyTitle;
	}

	/**
	 * @param partyTitle the partyTitle to set
	 */
	public void setPartyTitle(String partyTitle) {
		this.partyTitle = partyTitle;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(List<Game> game) {
		this.game = game;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(List<User> user) {
		this.user = user;
	}

	/**
	 * @return the video
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Game")
	public List<Game> getGame() {
		return game;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "User")
	public List<User> getUser() {
		return user;
	}

	/**
	 * @return the message
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Message")
	public List<Message> getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(List<Message> message) {
		this.message = message;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Message [id=" + id_party + ", Partyname=" + partyTitle + "]";
	}

}
