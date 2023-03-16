// Diese Zeile deklariert das Package, zu dem diese Klasse gehört
package com.project.DocumentManagingTool.repository;

// Diese Zeilen importieren Klassen, die in der Anwendung verwendet werden
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.DocumentManagingTool.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> { 
    /* JpaRepository ist eine generische Schnittstelle in Spring Data JPA
       Es bietet Standardmethoden zur Interaktion mit der Datenbank wie save(), findAll(), findById() usw.
       Employee ist der Entitätstyp, mit dem das Repository arbeitet
       Integer ist der Typ der ID-Eigenschaft des Employee-Objekts*/
}