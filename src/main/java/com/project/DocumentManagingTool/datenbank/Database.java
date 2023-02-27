package com.project.DocumentManagingTool.datenbank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.DocumentManagingTool.model.Employee;
import com.project.DocumentManagingTool.repository.EmployeeRepository;

@Component
public class Database implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    private final EmployeeRepository employeeRepository;

    public Database(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.deleteAll();

        employeeRepository.save(new Employee("Daenerys", "Targaryen"));
        employeeRepository.save(new Employee("Sarah", "Connor"));
        employeeRepository.save(new Employee("Elvis", "Presley"));
        employeeRepository.save(new Employee("Viktor", "Frankenstein"));
        employeeRepository.save(new Employee("Michael", "Jackson"));
        employeeRepository.save(new Employee("Whitney", "Houston"));

        employeeRepository.findAll().forEach((employee) -> {
            logger.info("{}", employee);
        });
    }
}
