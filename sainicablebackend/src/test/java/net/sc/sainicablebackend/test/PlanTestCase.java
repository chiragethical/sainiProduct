package net.sc.sainicablebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sc.sainicablebackend.dao.PlanDAO;
import net.sc.sainicablebackend.dto.Plan;

public class PlanTestCase {

	
	private static AnnotationConfigApplicationContext context;
	
	private static PlanDAO planDAO;
	
	private Plan plan;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.sc.sainicablebackend");
		context.refresh();
		planDAO = (PlanDAO)context.getBean("planDAO");
	}
	
		@Test
		public void testCRUDPlan() {
		
		// create operation
		/*plan = new Plan();
				
		plan.setName("Airtel");
		plan.setDescription("50 channels are included inn this plan . less channels camn also be selsvted");
		plan.setPrice(500);
		plan.setActive(true);
		
		assertEquals("Something went wrong while inserting a new plan!",
				true,planDAO.add(plan));	*/	
		
		
		// reading and updating the category
		/*plan = planDAO.get(2);
		
		plan.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong while updating the existing record!",
				true,planDAO.update(plan));		
				
		assertEquals("Something went wrong while deleting the existing record!",
				true,planDAO.delete(plan));		
		
		// list
		assertEquals("Something went wrong while fetching the list of plans!",2,planDAO.list().size());
				*/
	}
		
	
	@Test
	public void testListActivePlans() {
		assertEquals("Something went wrong while fetching the list of plans!",
				2,planDAO.listActivePlans().size());				
	} 
	
	
}
