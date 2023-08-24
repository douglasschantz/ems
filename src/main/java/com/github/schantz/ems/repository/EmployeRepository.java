package com.github.schantz.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.schantz.ems.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
