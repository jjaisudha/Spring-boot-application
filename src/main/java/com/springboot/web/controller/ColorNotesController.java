package com.springboot.web.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.service.ColorNotesService;
import com.springboot.web.service.LoginService;

@Controller
@SessionAttributes("name")
public class ColorNotesController {
	@Autowired
	ColorNotesService colornotesService;
	
	@RequestMapping(value = "/list-colorNotes", method= RequestMethod.GET)
   	public String displayColorNotes(ModelMap model)	 {
		//System.out.println("Name--"+name); 
		model.put("notes", colornotesService.retrieveColorNotess((String) model.get("name")));
		return "list-colornotes";		
		}
	@RequestMapping(value="/addColorNotes", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model){
		return "colornotes";
	}
	@RequestMapping(value="/deletecolorNotes", method = RequestMethod.GET)
	public String showdeleteTodoPage(ModelMap model,@RequestParam int id){
		colornotesService.deleteColorNotes(id);
		return "redirect:/list-colorNotes";	
	}
	@RequestMapping(value = "/addColorNotes", method= RequestMethod.POST)
   	public String addColorNotes(ModelMap model,@RequestParam String description)	 {
		colornotesService.addColorNotes((String) model.get("name"),description,new Date(),false);
		return "redirect:/list-colorNotes";		
		}
	
	/*@RequestMapping(value = "/deletecolorNotes", method= RequestMethod.POST)
   	public String deleteColorNotes(ModelMap model,@RequestParam int id)	 {
		colornotesService.deleteColorNotes(id);
		return "redirect:/list-colorNotes";		
		}*/
	
	
	}
