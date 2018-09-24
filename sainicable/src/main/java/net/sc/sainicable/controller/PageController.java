package net.sc.sainicable.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.sc.sainicable.exception.ProductNotFoundException;
import net.sc.sainicablebackend.dao.CategoryDAO;
import net.sc.sainicablebackend.dao.NewConnectionDAO;
import net.sc.sainicablebackend.dao.ProductDAO;
import net.sc.sainicablebackend.dto.Category;
import net.sc.sainicablebackend.dto.NewConnection;
import net.sc.sainicablebackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private NewConnectionDAO newConnectionDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		logger.info("INSIDE PAGE CONTROLLER INDEX METHOD - INFO");
		logger.debug("INSIDE PAGE CONTROLLER INDEX METHOD - DEBUG");
		// passing the create of object
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	//========  SHOW ALL PRODUCTS  ================================================//

	@RequestMapping(value = "/all/products")
	public ModelAndView allProducts() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;				
	}	
	
	//========  SHOW CATEGORY WISE PRODUCT ================================================//
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;				
	}	
	
	//========  SHOW SINGLE PRODUCT =========================================================//
	
	@RequestMapping(value = "/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		if(product == null) throw new ProductNotFoundException();
		
	
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//---------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		return mv;
		
	}
	
	//======== APPLY FOR NEW CONNECTION  =========================================================//
	
	@RequestMapping(value = "/apply/newConnection", method = RequestMethod.GET) 
	public ModelAndView showApplyConnection(@RequestParam(name = "operation", required = false) String operation){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "New Connection");
		mv.addObject("userClickAddNewConnection", true);
		
		NewConnection newConnection = new NewConnection();
		mv.addObject("newConnection", newConnection);
		
		if (operation != null) {
			if (operation.equals("thankYou")) {
				mv.addObject("message", "Thank You.\n Your request has been submitted successfully.\n We will contact you soon.");
			}
		}
		return mv;
	}
	
	
	
	@RequestMapping(value = "/apply/newConnection", method = RequestMethod.POST) 
	public String newConnection (@Valid @ModelAttribute("newConnection")NewConnection newConnection, BindingResult results,
			Model model) 
	{
		if (results.hasErrors())
		{
			model.addAttribute("userClickAddNewConnection", true);
			model.addAttribute("title", "New Connection");
			model.addAttribute("message","Please enter correct details");
			return "page";	
		}
		newConnectionDAO.add(newConnection);
		return "redirect:/apply/newConnection?operation=thankYou";
	}
	
	
	//========  SHOW ALL PLANS =========================================================//
	
	@RequestMapping(value = "/all/plans")
	public ModelAndView allPlans() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Plans");		
		mv.addObject("userClickAllPlans",true);
		return mv;				
	}
	

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/services")
	public ModelAndView services() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Services");
		mv.addObject("userClickServices", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}

}
