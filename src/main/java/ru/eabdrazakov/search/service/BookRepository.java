/**
 * 
 */
package ru.eabdrazakov.search.service;

import java.util.List;

/**The Class <code>BookRepository</code>
 *  <p>
 *  <b>Copyright: </b>Copyright (c) 2010-2011
 *  </p>
 *  @author Eldar Abdrazakov <br/> <b>e-mail</b>: eldariof@gmail.com <br/>
 *  @since 04.10.2011
 *  @version 1.0
 */
public interface BookRepository {
	
	/*
	 * Full text search
	 */
	public List<?> search ( final String searchTerm);

}
