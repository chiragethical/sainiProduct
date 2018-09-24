package net.sc.sainicable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sc.sainicablebackend.dao.NewConnectionDAO;
import net.sc.sainicablebackend.dao.PlanDAO;
import net.sc.sainicablebackend.dao.ProductDAO;
import net.sc.sainicablebackend.dto.NewConnection;
import net.sc.sainicablebackend.dto.Plan;
import net.sc.sainicablebackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private NewConnectionDAO newConnectionDAO;
	@Autowired
	private PlanDAO planDAO;
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsList() {
		return productDAO.list();

	}

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {

		return productDAO.listActiveProducts();

	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {

		return productDAO.listActiveProductsByCategory(id);

	}
	
	
	@RequestMapping("/all/plans")
	@ResponseBody
	public List<Plan> getAllPlans() {

		return planDAO.listActivePlans();

	}
	
	
	@RequestMapping("admin/all/plans")
	@ResponseBody
	public List<Plan> getAllPlansList() {

		return planDAO.list();

	}
	
	
	@RequestMapping("/show/connection/requests")
	@ResponseBody
	public List<NewConnection> getnewConnectionRequests() {

		return newConnectionDAO.list();

	}
	
	
}
