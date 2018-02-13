package com.springboot.web.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import org.omg.CosNaming.Binding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.model.ColorNotes;
import com.springboot.web.service.ColorNotesService;
import com.springboot.web.service.LoginService;

@Controller
@SessionAttributes("name")
public class ColorNotesController {
	@Autowired
	ColorNotesService colornotesService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value = "/list-colorNotes", method= RequestMethod.GET)
   	public String displayColorNotes(ModelMap model)	 {
		//System.out.println("Name--"+name); 
		model.put("notes", colornotesService.retrieveColorNotess((String) model.get("name")));
		return "list-colornotes";		
		}
	
	//Bean to form mapping by setting the model attribute in the server side and then consuming them by using component bean
	@RequestMapping(value="/addColorNotes", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model){
		model.addAttribute("colorNotes", new ColorNotes(0,(String) model.get("name"),"Default desc",new Date(),false));
		return "colornotes";
	}
	@RequestMapping(value="/deletecolorNotes", method = RequestMethod.GET)
	public String showdeleteTodoPage(ModelMap model,@RequestParam int id){
		colornotesService.deleteColorNotes(id);
		return "redirect:/list-colorNotes";	
	}
	
	@RequestMapping(value = "/addColorNotes", method= RequestMethod.POST)
   	public String addColorNotes(ModelMap model,@Valid ColorNotes colorNotes,BindingResult  result)	 {
		if (result.hasErrors()) {
			return "colornotes";
		}
					colornotesService.addColorNotes((String) model.get("name"),colorNotes.getDesc(),colorNotes.getTargetDate(),false);
				return "redirect:/list-colorNotes";	
		}	
	
	@RequestMapping(value="/updatecolorNotes", method = RequestMethod.GET)
	public String showupdateTodoPage(ModelMap model,@RequestParam int id){
		System.out.println(id);
		ColorNotes colornotes= colornotesService.retrieveColorNotesbyid(id);
		//Maintanin the same attribute name to colorNotes to redirect to the colornotes page for adding/updating
		model.put("colorNotes",colornotes);
		return "colornotes";	
	}
	
	@RequestMapping(value="/updatecolorNotes", method = RequestMethod.POST)
	public String updateTodoPage(ModelMap model,@Valid ColorNotes colorNotes,BindingResult  result){
		
		if (result.hasErrors()) {
			return "colornotes";
		}
		colorNotes.setUser((String) model.get("name"));
		colornotesService.updateTodo(colorNotes);
		return "redirect:/list-colorNotes";	
	}
	}
