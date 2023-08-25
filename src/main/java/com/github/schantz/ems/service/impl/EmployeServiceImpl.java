package com.github.schantz.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.github.schantz.ems.dto.EmployeDto;
import com.github.schantz.ems.entity.Employe;
import com.github.schantz.ems.exception.ResourceNotFoundException;
import com.github.schantz.ems.mapper.EmployeMapper;
import com.github.schantz.ems.repository.EmployeRepository;
import com.github.schantz.ems.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {

	private EmployeRepository employeRepository;

	public EmployeServiceImpl(EmployeRepository employeRepository) {
		this.employeRepository = employeRepository;
	}

	@Override
	public EmployeDto createEmploye(EmployeDto employeDto) {
		Employe employe = EmployeMapper.mapToEmploye(employeDto);
		Employe savedEmploye = employeRepository.save(employe);

		return EmployeMapper.mapToEmployeDto(savedEmploye);
	}

	@Override
	public EmployeDto getEmployeById(Long employeId) {
		Employe employe = employeRepository.findById(employeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employe is not exists with given id: " + employeId));

		return EmployeMapper.mapToEmployeDto(employe);
	}

	@Override
	public List<EmployeDto> getAllEmployes() {
		List<Employe> employes = employeRepository.findAll(Sort.by(Direction.ASC, "id"));
		return employes.stream().map((employe) -> EmployeMapper.mapToEmployeDto(employe)).collect(Collectors.toList());
	}

	@Override
	public EmployeDto updateEmploye(Long employeId, EmployeDto updateEmploye) {
		Employe employe = employeRepository.findById(employeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employe is not exists with give id: " + employeId));
		employe.setName(updateEmploye.getName());
		employe.setEmail(updateEmploye.getEmail());

		Employe updateEmployeObd = employeRepository.save(employe);

		return EmployeMapper.mapToEmployeDto(updateEmployeObd);
	}

	@Override
	public void deleteEmploye(Long employeId) {
		employeRepository.findById(employeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employe is not exists with give id: " + employeId));
		employeRepository.deleteById(employeId);
	}

}
