package com.project.DocumentManagingTool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.DocumentManagingTool.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {   
}

