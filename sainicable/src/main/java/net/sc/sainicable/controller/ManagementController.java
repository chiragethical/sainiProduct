package net.sc.sainicable.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import net.sc.sainicable.util.FileUploadUtility;
import net.sc.sainicablebackend.dao.CategoryDAO;
import net.sc.sainicablebackend.dao.NewConnectionDAO;
import net.sc.sainicablebackend.dao.PlanDAO;
import net.sc.sainicablebackend.dao.ProductDAO;
import net.sc.sainicablebackend.dto.Category;
import net.sc.sainicablebackend.dto.NewConnection;
import net.sc.sainicablebackend.dto.Plan;
import net.sc.sainicablebackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private NewConnectionDAO newConnectionDAO;
	@Autowired
	private PlanDAO planDAO;
	
	
	private static Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		Product nProduct = new Product();
		nProduct.setActive(true);
		mv.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product submitted succesfully");
			}
			if (operation.equals("category")) {
				mv.addObject("message", "Category added succesfully");
			}
		}
		return mv;
	}

	// handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {
		logger.info(results.toString());

		if (results.hasErrors())
		{
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message","Product validation failed for product submission");
			return "page";	
		}
	    logger.info(mProduct.toString());
		if(mProduct.getId()==0){
		productDAO.add(mProduct);
		}
		else{
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
			
		return "redirect:/manage/products?operation=product";
	}

	
	// FETCHING ANG SHOWING PRODUCT DETAIL
	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id)  {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		Product nProduct = productDAO.get(id);
		mv.addObject("product", nProduct);
		return mv;
	}
	
	
	//============ MANAGING PLANS================================================/////////
	@RequestMapping(value = "/plans", method = RequestMethod.GET)
	public ModelAndView showManagePlans(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManagePlans", true);
		mv.addObject("title", "Manage Plans");

		Plan nPlan = new Plan();
		nPlan.setActive(true);
		mv.addObject("plan", nPlan);

		if (operation != null) {
			if (operation.equals("plan")) {
				mv.addObject("message", "Plan submitted succesfully");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/plans", method = RequestMethod.POST)
	public String handlePlanSubmission(@Valid @ModelAttribute("plan") Plan mPlan, BindingResult results,
			Model model, HttpServletRequest request) {
		logger.info(results.toString());

		if (results.hasErrors())
		{
			model.addAttribute("userClickManagePlans", true);
			model.addAttribute("title", "Manage Plans");
			model.addAttribute("message","Plan validation failed for plan submission");
			return "page";	
		}
	    logger.info(mPlan.toString());
		if(mPlan.getId()==0){
		planDAO.add(mPlan);
		}
		else{
			planDAO.update(mPlan);
		}			
		return "redirect:/manage/plans?operation=plan";
	}
	
	
	@RequestMapping(value = "/{id}/plan", method = RequestMethod.GET)
	public ModelAndView showEditPlans(@PathVariable int id)  {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManagePlans", true);
		mv.addObject("title", "Manage Plans");

		Plan nPlan = planDAO.get(id);
		mv.addObject("plan", nPlan);
		return mv;
	}
	
	
	
	//------------
	//---- VIEW AND HANDLE NEW CONNECTION REQUESTS
	@RequestMapping(value = "/connections", method = RequestMethod.GET)
	public ModelAndView showConnections(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageConnections", true);
		mv.addObject("title", "Manage Connections");
		NewConnection newConnection = new NewConnection();
		mv.addObject("newConnection", newConnection);
		if (operation != null) {
			if (operation.equals("newConnection")) {
				mv.addObject("message", "Product submitted succesfully");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/update/newConnection", method = RequestMethod.POST)
	public String handleNewConnectionUpdation(@Valid @ModelAttribute("newConnection") NewConnection newConnection, BindingResult results,
			Model model, HttpServletRequest request) {
		logger.info(results.toString());

		if (results.hasErrors())
		{
			model.addAttribute("userClickManageConnections", true);
			model.addAttribute("title", "Manage Connections");
			model.addAttribute("message","Updation Failed");
			return "page";	
		}
	    logger.info(newConnection.toString());
		
			newConnectionDAO.update(newConnection);
			return "redirect:/manage/connections?operation=newConnection";
			
		}
	
	@RequestMapping(value ="/new/connection/{id}/request", method = RequestMethod.GET)
	public ModelAndView showNewConnectionRequest(@PathVariable int id) 
	{
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("userClickManageConnections", true);
	mv.addObject("updateNewConnection" , true);
	mv.addObject("title", "Manage Connections");
	
	NewConnection newConnection = newConnectionDAO.get(id);
	mv.addObject("newConnection", newConnection);
	return mv;
   }
	
	
	
	
// to handle category submission
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)  {
		
		categoryDAO.add(category);
		return "redirect:/manage/products/?operation=category";
		 
	}
	
	
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
}
