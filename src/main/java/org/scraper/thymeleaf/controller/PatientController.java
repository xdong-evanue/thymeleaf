package org.scraper.thymeleaf.controller;

import org.scraper.thymeleaf.entity.Patient;
import org.scraper.thymeleaf.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/newPatient")
    public String newPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "newPatient";
    }

    @PostMapping("/createNewPatient")
    public String createNewPatient(@ModelAttribute Patient patient) {
        patientService.insertPatient(patient.getName(), patient.getPhoneNumber());
        return "redirect:/newPatient";
    }

    @GetMapping("/allPatients")
    public String allPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "allPatients";
    }

    @GetMapping("/searchPatientForm")
    public String searchPatientForm() {
        return "searchPatient";
    }

    @GetMapping("/searchPatient")
    public String searchPatient(@RequestParam("phoneNumber") String phoneNumber, Model model) {
        model.addAttribute("patient", patientService.findByPhoneNumber(phoneNumber));
        return "searchPatient";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(@ModelAttribute Patient patient) {
        patientService.updatePatient(patient);
        return "redirect:/searchPatient?phoneNumber=" + patient.getPhoneNumber();
    }

    @PostMapping("/deletePatient")
    public String deletePatient(@RequestParam String phoneNumber) {
        patientService.deleteByPhoneNumber(phoneNumber);
        return "redirect:/searchPatientForm";
    }

}
