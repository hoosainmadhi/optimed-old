package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Dispense;
import com.madhis.optimed.service.ConsultService;
import com.madhis.optimed.service.DispenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DispenseController {


	@Autowired
	private DispenseService dispenseService;
	
	@Autowired
	private ConsultService consultService;
	
	@RequestMapping(value="/dispense/{id}",method = {RequestMethod.POST})
        public String dispenseForm(Model model, @ModelAttribute("dispense") Dispense dispense, @PathVariable(value="id") Long consultId){
		System.out.println("consultId = " + consultId);
		Consult consult = consultService.findByConsultId(consultId);
		model.addAttribute("consult",consult);
		
		consult.getDispenses().add(dispense);
		dispenseService.addDispense(dispense);
		
		return "index";
	} 
}
