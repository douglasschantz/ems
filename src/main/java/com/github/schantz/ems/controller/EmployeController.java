package com.github.schantz.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.schantz.ems.dto.EmployeDto;
import com.github.schantz.ems.service.EmployeService;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
	
	private EmployeService employeService;
	
	//build add employe REST APT
	@PostMapping
	public ResponseEntity<EmployeDto> createEmploye(@RequestBody EmployeDto employeDto){
		EmployeDto savedEmploye = employeService.createEmploye(employeDto);
		return new ResponseEntity<>(savedEmploye, HttpStatus.CREATED);
	}

	public EmployeController(EmployeService employeService) {
		this.employeService = employeService;
	}
	
	
	
}
