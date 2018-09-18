package net.sc.sainicablebackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sc.sainicablebackend.dao.CategoryDAO;
import net.sc.sainicablebackend.dto.Category;

public class CategoryTestCase {
	
private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	
	{
		
		context =  new AnnotationConfigApplicationContext();
	   context.scan("net.sc.sainicablebackend");
	   context.refresh();
	   
	   categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
/*	@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setName("Remotes");
		category.setActive(true);
		
		assertEquals("succesfully added a categoey",true,categoryDAO.add(category));
	}*/
	
/*	@Test
	public void testGetCategory()
	{
		category = categoryDAO.get(1);
		assertEquals("succesfully fatched a categoey","Boxes",category.getName());
		
	}
	*/

/*	@Test
	public void testUpdateCategory()
	{
		category = categoryDAO.get(2);
		category.setName("Remotes");
		assertEquals("succesfully fatched a categoey",true,categoryDAO.update(category));
		
	}*/
	
/*	@Test
	public void testDeleteCategory()
	{
		category = categoryDAO.get(2);
		
		assertEquals("succesfully deleted a category",true,categoryDAO.delete(category));
		
	}*/
	
	@Test
	public void testListCategory()
	{
		
		assertEquals("succesfully get the list of categories ",3,categoryDAO.list().size());
		
	}


}
