package com.github.schantz.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	public EmployeController(EmployeService employeService) {
		this.employeService = employeService;
	}

	// build add employe REST APT
	@PostMapping
	public ResponseEntity<EmployeDto> createEmploye(@RequestBody EmployeDto employeDto) {
		EmployeDto savedEmploye = employeService.createEmploye(employeDto);
		return new ResponseEntity<>(savedEmploye, HttpStatus.CREATED);
	}

	// build get ID employe REST APT
	@GetMapping("{id}")
	public ResponseEntity<EmployeDto> getEmployeId(@PathVariable("id") Long employeId) {
		EmployeDto employeDto = employeService.getEmployeById(employeId);
		return ResponseEntity.ok(employeDto);
	}

	// build get All employes REST APT
	@GetMapping()
	public ResponseEntity<List<EmployeDto>> getAllEmployes() {
		List<EmployeDto> employes = employeService.getAllEmployes();
		return ResponseEntity.ok(employes);
	}

}
