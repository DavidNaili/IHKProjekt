// Diese Zeile deklariert das Package, zu dem diese Klasse gehört
package com.project.DocumentManagingTool.service;

// Diese Zeilen importieren Klassen, die in der Anwendung verwendet werden
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.DocumentManagingTool.model.Employee;

import com.project.DocumentManagingTool.repository.EmployeeRepository;

@Service // Diese Annotation zeichnet diese Klasse als Spring Service-Komponente aus
public class EmployeeService {
    // Instanz des EmployeeRepository-Interfaces wird automatisch von Spring injiziert
    @Autowired
    private EmployeeRepository employeeRepository;

    // Methode zum Erstellen eines neuen Mitarbeiters
    public Employee createEmployee(Employee employee){
        // Verwenden der EmployeeRepository.save-Methode, um den Mitarbeiter in der Datenbank zu speichern
        return employeeRepository.save(employee);
    }

    // Methode zum Abrufen eines Mitarbeiters anhand der ID
    public Employee getEmployeeById (int id){
        // Verwenden der EmployeeRepository.findById-Methode, um einen Mitarbeiter anhand seiner ID abzurufen
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        // Rückgabe des gefundenen Mitarbeiters oder null, wenn kein Mitarbeiter mit der angegebenen ID gefunden wurde
        return optionalEmployee.orElse(null);
    }
    // Methode zum Abrufen aller Mitarbeiter aus der Datenbank
    public List<Employee> listAll() {
        /* Verwenden der EmployeeRepository.findAll-Methode, um alle Mitarbeiter aus der Datenbank abzurufen
           Die Mitarbeiter werden nach ihrer ID sortiert zurückgegeben*/
        return employeeRepository.findAll(Sort.by("id").ascending());
    }
}
