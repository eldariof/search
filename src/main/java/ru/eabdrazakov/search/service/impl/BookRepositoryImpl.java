/**
 * 
 */
package ru.eabdrazakov.search.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

import ru.eabdrazakov.search.model.Book;
import ru.eabdrazakov.search.service.BookRepository;

/**The Class <code>BookRepositoryImpl</code>
 *  <p>
 *  <b>Copyright: </b>Copyright (c) 2010-2011
 *  </p>
 *  @author Eldar Abdrazakov <br/> <b>e-mail</b>: eldariof@gmail.com <br/>
 *  @since 04.10.2011
 *  @version 1.0
 */
public class BookRepositoryImpl implements BookRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	/*
	 * @see ru.eabdrazakov.search.service.BookRepository#search(java.lang.String)
	 */
	public List<?> search(final String searchTerm) {
		QueryParser parser = new QueryParser(Version.LUCENE_34, "", new StandardAnalyzer(Version.LUCENE_34));
		Query luceneQuery;    
		try {
			luceneQuery = parser.parse(searchTerm);
		} catch (ParseException pe) {
			//log.error("found a problem in search", pe);
			return null;
		}			
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		List<?>  books = 
			fullTextEntityManager.createFullTextQuery(luceneQuery, Book.class).
				setMaxResults(20).getResultList();
		return books;
	}
}
