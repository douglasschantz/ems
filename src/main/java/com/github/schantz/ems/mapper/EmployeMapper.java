package com.github.schantz.ems.mapper;

import com.github.schantz.ems.dto.EmployeDto;
import com.github.schantz.ems.entity.Employe;

public class EmployeMapper {
	
	public static EmployeDto mapToEmployeDto(Employe employe) {
		return new EmployeDto(
				employe.getId(),
				employe.getName(),
				employe.getEmail()				
		);
	}
	
	public static Employe mapToEmploye(EmployeDto employeDto) {
		return new Employe(
				employeDto.getId(),
				employeDto.getName(),
				employeDto.getEmail()
		);
	}

}
