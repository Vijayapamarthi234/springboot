package com.sathya.springmvc.emp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employeemodel {
private String name;
private long phoneno;
private String gender;
private String doj;
private String  deptname;
private double salary;
}
