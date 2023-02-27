package com.project.DocumentManagingTool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.DocumentManagingTool.model.Employee;
import com.project.DocumentManagingTool.service.EmployeeService;



@Controller
public class MitarbeiterController {

@Autowired
private EmployeeService employeeService;


    @GetMapping("/employee/add")
    public String addEmployeeForm(Model model){
        return "addEmployee";
    }

    @PostMapping("/employee/addEmployee")
    public String addEmployee(Model model,
                            @RequestParam("vornameEingabe") String vorname,
                            @RequestParam("nachnameEingabe") String nachname,
                            @RequestParam("weiterleitung_name") String weiterleitung){
        Employee employee = new Employee(vorname, nachname);
        employeeService.createEmployee(employee);
        return "redirect:/employee/all";
    }
}
