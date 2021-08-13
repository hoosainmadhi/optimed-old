
package com.madhis.optimed.service;

import com.madhis.optimed.entity.Patient;
import java.util.List;

public interface PatientService {
    
    public Patient savePatient(Patient patient);
    
    public List<Patient> fetchPatientList();
    
    public List<Patient> fetchPatientByName(String name);
    
    public void deletePatientById(Long patientId);

}
