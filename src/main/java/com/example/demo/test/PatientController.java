package com.example.demo.test;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/getPatientDetails/{name}")
	public Patient getPatient(@PathVariable String name) throws InterruptedException, ExecutionException {
		return patientService.getPatientDetails(name);
	}
	
	@PostMapping("/createPatient")
	public String createPatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
		return patientService.savePatientDetails(patient);
	}
	
	@PutMapping("/updatePatient")
	public String updatePatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
		return patientService.updatePatientDetails(patient);
	}
	
	@DeleteMapping("/deletePatient")
	public String deletePatient(@RequestParam String name) throws InterruptedException, ExecutionException {
		return patientService.deletePatient(name);
	}
}
