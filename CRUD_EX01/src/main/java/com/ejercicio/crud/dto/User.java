package com.ejercicio.crud.dto;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")//en caso que la tabla sea diferente
public class User  {
 
	

	//Atributos de entidad users
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id_user;
	@Column(name = "username")//no hace falta si se llama igual
	private String username;
	@Column(name = "password")//no hace falta si se llama igual
	private String password;
	@Column(name = "email")//no hace falta si se llama igual
	private String email;
	@Column(name = "steam_user")//no hace falta si se llama igual
	private String steam_user;
	
    @OneToMany
    @JoinColumn(name="id_user")
    private List<Message> message;
	
    @ManyToOne
    @JoinColumn(name="party_id")
    private Party party; 
	
    
    //Constructores
	
	public User() {
	
	}

	public User(Long id_user, String username, String password, String email, String steam_user) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.email = email;
		this.steam_user = steam_user;
	}
	

	

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSteam_user() {
		return steam_user;
	}

	public void setSteam_user(String steam_user) {
		this.steam_user = steam_user;
	}
	
	/**
	 * @return the video
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Message")
	public List<Message> getMessage() {
		return message;
	}


	/**
	 * @return the message
	 */
	public List<Message> setMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(List<Message> message) {
		this.message = message;
	}

	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Message [id=" + id_user + ", username=" + username + ", password=" + password + ", steam=" + steam_user
				+ ", email=" + email + "]";
	}
	
	
	
	
	
}
