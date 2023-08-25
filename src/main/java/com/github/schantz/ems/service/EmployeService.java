package com.github.schantz.ems.service;

import java.util.List;

import com.github.schantz.ems.dto.EmployeDto;

public interface EmployeService {
	EmployeDto createEmploye(EmployeDto employeDto);

	EmployeDto getEmployeById(Long employeId);

	List<EmployeDto> getAllEmployes();

	EmployeDto updateEmploye(Long employeId, EmployeDto updateEmploye);
	
	void deleteEmploye(Long EmployeId);

}
