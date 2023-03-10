package com.project.DocumentManagingTool.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "Employee")
@Getter
@Setter
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String vorname;
    private String nachname;


    public Employee(){   
    }

    public Employee(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }
}
