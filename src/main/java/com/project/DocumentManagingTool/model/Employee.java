package com.project.DocumentManagingTool.model;

import javax.persistence.*;

@Entity
@Table(name= "Employee")
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

    public int getId() {
        return this.id;
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

}
