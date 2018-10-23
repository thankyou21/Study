package com.cg.tms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.tms.entities.Trainee;
import com.cg.tms.service.TraineeService;


@Controller
public class TrainingController 
{
	@Autowired
	TraineeService tser;
	
	@RequestMapping("start")
	public String showLogin()
	{
		return "Login";
	}
	
	@RequestMapping("validate")
	public String showOperations(@RequestParam("usr") String usr, @RequestParam("pwd") String pwd)
	{
		
		if(usr.equals("a") && pwd.equals("a"))
			return "Operation";
		else
			return "Invalid";
	}
	
	@RequestMapping("operation")
	public String operation(@RequestParam("ch") String ch, Model model)
	{
		Trainee tdetails = new Trainee();
		model.addAttribute("tdetails",tdetails);
		switch(ch)
		{
			case "1": return "AddTrainee";
			
			case "2": return "DeleteTrainee";
			
			case "3": return "ModifyTrainee";
			
			case "4": return "RetrieveTrainee";
			
			case "5": 
			{
				List<Trainee> tlist = tser.getAllTrainees();
				model.addAttribute("tlist",tlist);
				return "RetrieveAll";
			}
		}
		return null;
	}
	
	@RequestMapping("add")
	public String add(@Valid@ModelAttribute("tdetails")Trainee tdetails, BindingResult res, Model model)
	{
		if(res.hasErrors())
		{
			model.addAttribute("tdetails",tdetails);
			return "AddTrainee";
		}
		else
		{
			model.addAttribute("tdetails",tdetails);
			tser.addTrainee(tdetails);
			
			return "Added";
		}
	}
	@RequestMapping("del")
	public String del(@RequestParam("traineeId")Integer traineeId, Model model)
	{
		tser.deleteTrainee(traineeId);
		model.addAttribute("traineeId", traineeId);
		return "Deleted";
	}
	
	@RequestMapping("retrieveOne")
	public String retriveOne(@RequestParam("traineeId")Integer traineeId, Model model)
	{
		model.addAttribute("tdetails",tser.retriveSingleTrainee(traineeId));
		return "RetrieveOne";
	}
	
	@RequestMapping("edit")
	public String edit(@RequestParam("traineeId")Integer traineeId, Model model)
	{
		Trainee trainee = new Trainee();
		//trainee.setTraineeId(traineeId);
		//model.addAttribute("tdetails",trainee);
		model.addAttribute("tdetails",tser.retriveSingleTrainee(traineeId));
		return "ModifyData";
	}
	
	@RequestMapping("update")
	public String update(@ModelAttribute("tdetails")Trainee tdetails, Model model)
	{
		tser.modifyTrainee(tdetails);
		model.addAttribute("tdetails", tdetails);
		return "Updated";
	}
}
