package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.service.ConsultService;
import com.madhis.optimed.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConsultController {
	
	@Autowired
	private ConsultService consultService;
	
	@Autowired
	private PatientService patientService;	

	@RequestMapping(value="/save_consult/{id}",method = {RequestMethod.POST})
        public String dispenseForm(@ModelAttribute("consult") Consult consult, @PathVariable(value="id") Long patientId){ 
		  Patient patient = patientService.findPatientById(patientId);
		  patient.getConsults().add(consult);
    	          consultService.addConsult(consult);
		  return "dispense";
        }

//	@RequestMapping(value="consult/{id}",method = {RequestMethod.POST})
//	public String consultForm(Model model, @PathVariable(value="id") Long patientId){
//		  model.addAttribute(patientService.getPatientById(patientId));
//		  return "consult";
//	}
}
