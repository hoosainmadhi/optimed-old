package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.service.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController

class PatientRestController {
    
    @Autowired
    private PatientService patientService;
            
   
       @RequestMapping(value = "/rest",method = {RequestMethod.GET}) 
        public String index(){
            return "welcome - Rest Controller Managing all Rest calls";
        }
    
     
        @RequestMapping(value = "/rest_patients",method = {RequestMethod.GET}) 
        public List<Patient> fetchPatientList(){
            return patientService.fetchPatientList();
        }
	
	//@RequestMapping(value = "/rest_get_patient/{id}", method = {RequestMethod.GET})
	@GetMapping(value = "/rest_get_patients/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public Patient getPatientById(@PathVariable(value="id") Long patientId){
	     return patientService.findPatientById(patientId);	
	} 	
	
	@RequestMapping(value= "/rest_savepatient", method = {RequestMethod.POST})
	public Patient savePatient(@RequestBody Patient patient){
            return patientService.savePatient(patient);
        }


	@RequestMapping(value= "/rest_delete_patient/{id}", method = {RequestMethod.DELETE})
	public void deletePatientById(@PathVariable(value="id") Long patientId){
               patientService.deletePatientById(patientId);
        }
        

	//@RequestMapping(value="/rest_update_patient/{id}", method = {RequestMethod.PUT})
	@PutMapping({"/rest_update_patient/{id}"})
	public void updatePatient(@RequestBody Patient patient, @PathVariable(value="id") Long patientId){
		patientService.updatePatient(patientId, patient);
	}	

        
}
