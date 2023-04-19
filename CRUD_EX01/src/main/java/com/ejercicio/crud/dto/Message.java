/**
 * 
 */
package com.ejercicio.crud.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author camila
 *
 */

@Entity
@Table(name="messages")//en caso que la tabla sea diferente
public class Message {

	//Atributos de entidad messages
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long id_message;
		@Column(name = "content")//no hace falta si se llama igual
		private String content;
		
		//esto igual falla 
		@Column(name = "date")//no hace falta si se llama igual
		@Temporal(TemporalType.TIMESTAMP)
		private Date date;
		
	    @ManyToOne
	    @JoinColumn(name="user_id")
	    private User user; 
	   

	    public Message() {}
		public Message(Long id_message, String content, Date date) {
			super();
			this.id_message = id_message;
			this.content = content;
			this.date = date;
		}
		/**
		 * @return the id_message
		 */
		public Long getId_message() {
			return id_message;
		}
		/**
		 * @param id_message the id_message to set
		 */
		public void setId_message(Long id_message) {
			this.id_message = id_message;
		}
		/**
		 * @return the content
		 */
		public String getContent() {
			return content;
		}
		/**
		 * @param content the content to set
		 */
		public void setContent(String content) {
			this.content = content;
		}
		/**
		 * @return the date
		 */
		public Date getDate() {
			return date;
		}
		/**
		 * @param date the date to set
		 */
		public void setDate(Date date) {
			this.date = date;
		}
		
		
		
		//Metodo impresion de datos por consola
		@Override
		public String toString() {
			return "Message [id=" + id_message + ", content=" + content + ", date=" + date+ "]";
		}
		
	    
}
