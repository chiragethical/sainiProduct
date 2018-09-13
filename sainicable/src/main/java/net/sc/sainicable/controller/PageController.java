package net.sc.sainicable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sc.sainicablebackend.dao.CategoryDAO;


@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("title","Home");
		
		//passing the create of object
	
		mv.addObject("userClickHome",true);
		return mv;
	}


	@RequestMapping(value = "/boxes")
	public ModelAndView boxes() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Boxes");
		mv.addObject("userClickBoxes",true);
		return mv;
	}


	@RequestMapping(value = "cables")
	public ModelAndView cables() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Cables");
		mv.addObject("userClickCables",true);
		return mv;
	}


	@RequestMapping(value = "/remotes")
	public ModelAndView remotes() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Remotes");
		mv.addObject("userClickRemotes",true);
		return mv;
	}

	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About");
		mv.addObject("userClickAbout",true);
		return mv;
	}

	@RequestMapping(value = "/services")
	public ModelAndView services() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Services");
		mv.addObject("userClickServices",true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userClickContact",true);
		return mv;
	}

}
