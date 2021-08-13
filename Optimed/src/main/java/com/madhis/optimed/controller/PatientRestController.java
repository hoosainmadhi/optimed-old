
package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.service.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RestController for Postman

public class PatientRestController {
    
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
	
	@RequestMapping(value= "/rest_savepatient", method = {RequestMethod.POST})
	public Patient savePatient(@RequestBody Patient patient){
            return patientService.savePatient(patient);
        }


	@RequestMapping(value= "/rest_delete_patient/{id}", method = {RequestMethod.DELETE})
	public void deletePatientById(@PathVariable(value="id") Long patientId){
               patientService.deletePatientById(patientId);
        }
        
    
//        @RequestMapping(value="/patient_form",method = {RequestMethod.GET})
//        public String newPatientForm(Model model){
//            Patient patient = new Patient();
//            model.addAttribute("patient", patient);
//            return "patient_form";
//        }
// 
//        @RequestMapping(value="/patient_form",method = {RequestMethod.POST})
//        public String submitForm(@ModelAttribute("patient") Patient patient) {
//            patientService.savePatient(patient);
//    	    return "patientadded";
//}
//        
//
//	@RequestMapping(value="/patient_delete/{id}", method = {RequestMethod.GET,RequestMethod.POST})
//        public String deletePatientId(Model model , @PathVariable(value="id") Long patientId){
//            patientService.deletePatientById(patientId);
//            List<Patient> listPatients = patientService.fetchPatientList();
//            model.addAttribute("listPatients",listPatients);
//            return "patients";  
//	}       
//	
//        @PostMapping("/savepatients")
//        public Patient savePatient(@RequestBody Patient patient){
//            return patientService.savePatient(patient);
//}


//	@DeleteMapping("/patient_delete/{id}")
//	    public String deletePatient(@PathVariable(name = "id") int id ) {
//		patientService.deletePatientById();
//		return "redirect:/";       
//}

//        @GetMapping("/patients")
//        public List<Patient> fetchPatientList(){
//            return patientService.fetchPatientList();
//        }

             
//        @DeleteMapping("/patients/{id}")
//        public void deletePatientById(@PathVariable(value="id") Long patientId){
//               patientService.deletePatientById(patientId);
//        }
        
        

        
}
