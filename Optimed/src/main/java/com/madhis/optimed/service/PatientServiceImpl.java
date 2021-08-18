
package com.madhis.optimed.service;

import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.repository.PatientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {   
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Override
    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }
    
    
    @Override
    public List<Patient> fetchPatientList(){
        return patientRepository.findAll();
    }
    
    
    @Override
    public void deletePatientById(Long patientId){
           patientRepository.deleteById(patientId);
    }
    
    @Override
    public List<Patient> fetchPatientByName(String  patientName){
        return patientRepository.findByPatientName(patientName);
    }
    
    @Override
    public Patient getPatientById(Long patientId){
	    return patientRepository.getById(patientId);
    }
       

}
