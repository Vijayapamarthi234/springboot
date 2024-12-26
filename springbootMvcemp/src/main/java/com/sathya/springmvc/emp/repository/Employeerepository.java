package com.sathya.springmvc.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.springmvc.emp.entity.Employeeentity;
@Repository
public interface Employeerepository extends JpaRepository<Employeeentity, Long> {

}
