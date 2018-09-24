package net.sc.sainicablebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sc.sainicablebackend.dao.UserDAO;
import net.sc.sainicablebackend.dto.Cart;
import net.sc.sainicablebackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	/* private Cart cart = null; */

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.sc.sainicablebackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	/*@Test
	public void testAddUser() {

		user = new User();
		user.setFirstName("pooja");
		user.setLastName("nanda");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");

		Cart cart = new Cart();

		//linked the cart with the user
		cart.setUser(user);
		//link the user with the cart
		 user.setCart(cart);

		// add the user
		assertEquals("Failed to add the user!", true, userDAO.add(user));

	}
*/
	
	  @Test 
	  public void testUpdateCart() {
		  
	  user = userDAO.getByEmail("nanda.pooja52@gmail.com"); 
	  Cart cart = user.getCart();
	  cart.setGrandTotal(100); 
	  cart.setCartLines(1);
	  assertEquals("Failed to update the cart!", true,userDAO.update(cart)); 
	  
	  }
	  
	
	/* @Test 
	  public void email() {
		  
	  user = userDAO.getByEmail("nanda.pooja52@gmail.com"); 
	 
	  assertEquals("Failed to update the cart!",1,userDAO.getByEmail("nanda.pooja52@gmail.com")); 
	  
	  }*/
	 

}
