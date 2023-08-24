package com.github.schantz.ems.service.impl;

import org.springframework.stereotype.Service;

import com.github.schantz.ems.dto.EmployeDto;
import com.github.schantz.ems.entity.Employe;
import com.github.schantz.ems.mapper.EmployeMapper;
import com.github.schantz.ems.repository.EmployeRepository;
import com.github.schantz.ems.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService{
	
	private EmployeRepository employeRepository;
	
	@Override
	public EmployeDto createEmploye(EmployeDto employeDto) {
		Employe employe = EmployeMapper.mapToEmploye(employeDto);
		Employe savedEmploye = employeRepository.save(employe);
		
		return EmployeMapper.mapToEmployeDto(savedEmploye);
	}
	
	public EmployeServiceImpl(EmployeRepository employeRepository) {
		this.employeRepository = employeRepository;
	}
	
	
}
