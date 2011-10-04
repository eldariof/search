/**
 * 
 */
package ru.eabdrazakov.search;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;
import org.testng.Assert;

import ru.eabdrazakov.search.model.Book;
import ru.eabdrazakov.search.service.BookRepository;

/**The Class <code>SearchTest</code>
 *  <p>
 *  <b>Copyright: </b>Copyright (c) 2010-2011
 *  </p>
 *  @author Eldar Abdrazakov <br/> <b>e-mail</b>: eldariof@gmail.com <br/>
 *  @since 04.10.2011
 *  @version 1.0
 */
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class SearchTest extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
	BookRepository bookRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	@Rollback(false)
	public void testCanSearchWithResult() {
		Book book = new Book();
		book.setTitle("baby 3");
		book.setDescription("baby 3");
		entityManager.persist(book);
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		fullTextEntityManager.index(book);		
		List<?> books = bookRepository.search("title:baby");
		Assert.assertNotNull(books);
	}

}
