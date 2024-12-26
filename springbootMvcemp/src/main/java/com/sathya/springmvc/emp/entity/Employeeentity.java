package com.sathya.springmvc.emp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employeeentity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String name;
    private long phoneno;
    private String gender;
    private String doj;
    private String deptname;
    private double salary;  
    private double da;
    private double hra;
    private double totalsalary;

}
