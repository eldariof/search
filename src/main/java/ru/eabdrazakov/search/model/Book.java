/**
 * 
 */
package ru.eabdrazakov.search.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**The Class <code>Book</code>
 *  <p>
 *  <b>Copyright: </b>Copyright (c) 2010-2011
 *  </p>
 *  @author Eldar Abdrazakov <br/> <b>e-mail</b>: eldariof@gmail.com <br/>
 *  @since 04.10.2011
 *  @version 1.0
 */
@Entity
@Indexed
@Table(name="BOOK")
public class Book implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 8032404825633295172L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	@Type(type="java.lang.Long")
	@DocumentId
	private Long id;

	@Column(name="TITLE", nullable = false, length = 250)
	@Field(index=Index.TOKENIZED, store=Store.YES)
	private String title;
 
	@Column(name="DESCRPTION", nullable = false, length = 2500)
	@Field(index=Index.TOKENIZED, store=Store.YES)
	private String description;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
