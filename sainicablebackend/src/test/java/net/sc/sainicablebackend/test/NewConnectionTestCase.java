package net.sc.sainicablebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sc.sainicablebackend.dao.NewConnectionDAO;
import net.sc.sainicablebackend.dto.NewConnection;

public class NewConnectionTestCase {

	private static AnnotationConfigApplicationContext context;

	private static NewConnectionDAO newConnectionDAO;

	private NewConnection newConnection;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.sc.sainicablebackend");
		context.refresh();
		newConnectionDAO = (NewConnectionDAO)context.getBean("newConnectionDAO");
	}

	@Test
	public void testCRUDNewConnection() {

		newConnection = new NewConnection();

		newConnection.setName("pooja");
		newConnection.setAddress("sawan Ppark");
		newConnection.setPhone("9555693908");
		newConnection.setEmail("nanda.pooja52");

		assertEquals("Something went wrong while inserting a new newConnection!", true,
				newConnectionDAO.add(newConnection));

		// reading and updating the category
		/*
		 * newConnection = newConnectionDAO.get(2);
		 * 
		 * newConnection.setName("Samsung Galaxy S7"); assertEquals(
		 * "Something went wrong while updating the existing record!",
		 * true,newConnectionDAO.update(newConnection));
		 * 
		 * assertEquals(
		 * "Something went wrong while deleting the existing record!",
		 * true,newConnectionDAO.delete(newConnection));
		 * 
		 * // list assertEquals(
		 * "Something went wrong while fetching the list of newConnections!",
		 * 2,newConnectionDAO.list().size());
		 */

	}

	/*
	 * @Test public void testListActiveNewConnections() { assertEquals(
	 * "Something went wrong while fetching the list of newConnections!",
	 * 1,newConnectionDAO.listActiveNewConnections().size()); }
	 */
}
