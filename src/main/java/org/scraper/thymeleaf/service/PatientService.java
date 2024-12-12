package org.scraper.thymeleaf.service;

import org.scraper.thymeleaf.entity.Patient;
import org.scraper.thymeleaf.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientMapper patientMapper;

    public PatientService(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    public void insertPatient(String name, String phoneNumber) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setPhoneNumber(phoneNumber);
        patientMapper.insert(patient);
    }

    public List<Patient> getAllPatients() {
        return patientMapper.findAll();
    }

    public Patient findByPhoneNumber(String phoneNumber) {
        return patientMapper.findByPhoneNumber(phoneNumber);
    }

    public void updatePatient(Patient patient) {
        patientMapper.update(patient);
    }

    public void deleteByPhoneNumber(String phoneNumber) {
        patientMapper.deleteByPhoneNumber(phoneNumber);
    }


}
