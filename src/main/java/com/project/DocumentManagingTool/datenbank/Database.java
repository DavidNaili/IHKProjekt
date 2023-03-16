// Diese Zeile deklariert das Package, zu dem diese Klasse gehört
package com.project.DocumentManagingTool.datenbank;

// Diese Zeilen importieren Klassen, die in der Anwendung verwendet werden
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.DocumentManagingTool.model.Employee;
import com.project.DocumentManagingTool.repository.EmployeeRepository;

@Component // Die Klasse Database wird als Komponente markiert, die von Spring verwaltet wird
public class Database implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    private final EmployeeRepository employeeRepository;

    public Database(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    // Diese Methode wird beim Starten der Anwendung ausgeführt
    @Override
    public void run(String... args) throws Exception {
        // Löscht alle Mitarbeiter in der Datenbank
        employeeRepository.deleteAll();
        // Fügt einige Beispiel-Mitarbeiter hinzu
        employeeRepository.save(new Employee("Daenerys", "Targaryen"));
        employeeRepository.save(new Employee("Sarah", "Connor"));
        employeeRepository.save(new Employee("Elvis", "Presley"));
        employeeRepository.save(new Employee("Viktor", "Frankenstein"));
        employeeRepository.save(new Employee("Michael", "Jackson"));
        employeeRepository.save(new Employee("Whitney", "Houston"));

        // Gibt alle Mitarbeiter aus der Datenbank in der Konsole aus
        employeeRepository.findAll().forEach((employee) -> {
            logger.info("{}", employee);
        });
    }
}
