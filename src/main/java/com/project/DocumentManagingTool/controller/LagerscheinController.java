// Diese Zeile deklariert das Package, zu dem diese Klasse gehört
package com.project.DocumentManagingTool.controller;

// Diese Zeilen importieren Klassen, die in der Anwendung verwendet werden
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

@Controller // Dies ist eine Annotation von Spring, die anzeigt, dass diese Klasse ein Controller ist und HTTP-Anfragen verarbeiten kann
public class LagerscheinController {

    @Autowired // Diese Annotation sagt Spring, dass die Variable "employeeService" automatisch durch Dependency Injection injiziert werden soll.
    private EmployeeService employeeService;
    
    /* Diese Methode wird aufgerufen, wenn der Pfad "/employee/all" mit der HTTP-Methode GET aufgerufen wird.
       Es gibt eine Liste aller Mitarbeiter zurück und fügt sie als Attribut zum Model hinzu.
       Die Liste wird in einer HTML-Seite angezeigt.*/
    @GetMapping("/employee/all")
    public String getAllEmployee(Model model){
        /* Die Methode listAll() der EmployeeService-Klasse gibt eine Liste aller Mitarbeiter zurück
           Diese Liste wird im "listEmployee" Attribut des Models gespeichert und an die "employee" View weitergeleitet*/
        model.addAttribute("listEmployee", employeeService.listAll());
        return "employee";
    }
    
    // Diese Methode wird aufgerufen, wenn der Pfad "/employee/export/{id}" mit der HTTP-Methode GET aufgerufen wird.
    @GetMapping("/employee/export/{id}")
    public void exportToPDF(@PathVariable int id, HttpServletResponse response) throws DocumentException, IOException {
         // Diese Methode generiert ein PDF-Dokument und gibt es als Antwort zurück.
        response.setContentType("application/pdf");
         // Ein Datum-Formatierungsobjekt wird erstellt, um das aktuelle Datum und die Uhrzeit im Dateinamen des PDFs zu verwenden.
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        // Der Dateiname wird festgelegt und als "Content-Disposition" HTTP-Header hinzugefügt, um den Download des PDFs im Browser zu starten.
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Lagerentnahmeschein_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
      
        // Die Employee-Instanz wird basierend auf der "id" aus der Datenbank abgerufen.
        Employee employee = employeeService.getEmployeeById(id);

        // Ein Objekt der Klasse "LagerscheinPDFExporter" wird erstellt, um das PDF-Dokument zu generieren und als Antwort zurückzugeben.
        LagerscheinPDFExporter exporter = new LagerscheinPDFExporter();
        exporter.export(response, employee);
    }
}