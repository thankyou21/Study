package com.cg.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.cg.dto.Employee;

@Controller
public class MyController 
{
	@RequestMapping("start")
	public ModelAndView handle(Model model)
	{
		String msg = "Welcome to Spring MVC";
		model.addAttribute("emp", new Employee());
		return new ModelAndView("Hello", "message", msg);
	}
	
	@RequestMapping("welcome")
							//@RequestParam(name of form feild b data type b variable name)			to get the value of feild from html file 
	public String showMessage(@RequestParam("un")String name, @RequestParam("com")String company, Model model)
	{
	//  model.addAttribute(model attribute, stored values of form)		to stored the fetch value from html form to model view
		model.addAttribute("un",name);
		model.addAttribute("com",company);
		// calling the welcome.jsp file
		return "welcome";
	}
	
	@RequestMapping("register")
	public String register(@Valid @ModelAttribute("emp")Employee emp, BindingResult res, Model model)
	{
		if(res.hasErrors())
		{
			return "Hello";
		}
		model.addAttribute("emp",emp);
		return "success";
	}
}
