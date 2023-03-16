// Diese Zeile deklariert das Package, zu dem diese Klasse gehört
package com.project.DocumentManagingTool.model;

// Diese Zeilen importieren Klassen, die in der Anwendung verwendet werden
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity                     // @Entity sagt Spring Data JPA, dass es sich um eine Entität handelt, die in der Datenbank gespeichert wird
@Table(name= "Employee")    // @Table gibt den Namen der Tabelle an, in der die Entität gespeichert werden soll
@Getter                     // Die Annotationen @Getter und @Setter stammen aus dem Lombok-Projekt und generieren automatisch Getter- und Setter-Methoden für alle Instanzvariablen
@Setter
public class Employee {
 
    @Id                                                 // @Id gibt an, dass dies die ID-Eigenschaft der Entität ist
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue gibt an, wie der Wert der ID-Eigenschaft automatisch generiert wird
    private int id;

    private String vorname;
    private String nachname;

    // Default-Konstruktor, der von Spring benötigt wird
    public Employee(){   
    }

    /* Konstruktor für die Erstellung eines neuen Employee-Objekts
       Setzt die Vor- und Nachnamen-Eigenschaften der Entität*/
    public Employee(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }
}