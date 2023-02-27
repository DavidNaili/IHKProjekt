package com.project.DocumentManagingTool.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.DocumentManagingTool.model.Employee;
import com.project.DocumentManagingTool.service.LagerscheinPDFExporter;
import com.project.DocumentManagingTool.service.EmployeeService;
import com.lowagie.text.DocumentException;

@Controller
public class LagerscheinController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/all")
    public String getAllEmployee(Model model){
        model.addAttribute("listEmployee", employeeService.listAll());
        return "employee";
    }

    @GetMapping("/employee/export/{id}")
    public void exportToPDF(@PathVariable int id, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());  
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Lagerentnahmeschein_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        Employee employee = employeeService.getEmployeeById(id);

        LagerscheinPDFExporter exporter = new LagerscheinPDFExporter();
        exporter.export(response, employee);
    }
}
