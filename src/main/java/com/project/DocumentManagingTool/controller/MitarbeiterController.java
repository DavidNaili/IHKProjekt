// Diese Zeile deklariert das Package, zu dem diese Klasse gehört
package com.project.DocumentManagingTool.controller;

// Diese Zeilen importieren Klassen, die in der Anwendung verwendet werden
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.DocumentManagingTool.model.Employee;
import com.project.DocumentManagingTool.service.EmployeeService;



@Controller // Dies ist eine Annotation von Spring, die anzeigt, dass diese Klasse ein Controller ist und HTTP-Anfragen verarbeiten kann.
public class MitarbeiterController {

@Autowired // Diese Annotation teilt Spring mit, dass das employeeService-Objekt automatisch injiziert werden soll.
private EmployeeService employeeService;

    /* Diese Methode wird aufgerufen, wenn der Pfad "/employee/add" mit der HTTP-Methode GET aufgerufen wird.
       Es zeigt das Formular zum Hinzufügen eines neuen Mitarbeiters an.*/
    @GetMapping("/employee/add")
    public String addEmployeeForm(Model model){
        return "addEmployee";
    }

    /* Diese Methode wird aufgerufen, wenn das Formular zum Hinzufügen eines neuen Mitarbeiters gesendet wird.
       Es nimmt die Eingabedaten aus dem Formular entgegen und fügt einen neuen Mitarbeiter zur Datenbank hinzu.
       Anschließend wird der Benutzer auf die Seite umgeleitet, die alle Mitarbeiter anzeigt.*/
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