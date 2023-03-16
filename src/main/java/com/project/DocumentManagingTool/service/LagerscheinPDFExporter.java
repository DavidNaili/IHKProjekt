// Diese Zeile deklariert das Package, zu dem diese Klasse gehört
package com.project.DocumentManagingTool.service;

// Diese Zeilen importieren Klassen, die in der Anwendung verwendet werden
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.project.DocumentManagingTool.model.Employee;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


@Service // Diese Annotation kennzeichnet die Klasse als Spring Service
public class LagerscheinPDFExporter {

    // Der Standardkonstruktor für die Klasse
    public LagerscheinPDFExporter(){}

    // Diese Methode exportiert eine PDF-Datei, die einen Lagerschein für einen Mitarbeiter enthält
    public void export(HttpServletResponse response, Employee employee) throws DocumentException, IOException {

        // Liest eine PDF-Datei ein, die als Vorlage für den Lagerschein dient
        PdfReader document = new PdfReader("/Dokumente/Lagerentnahmeschein.pdf");
        // Erstellt einen PdfStamper-Objekt, um die PDF-Datei zu bearbeiten und sie in die HTTP-Antwort zu schreiben
        PdfStamper pdfStamper = new PdfStamper(document, response.getOutputStream());

        // Erstellt eine BaseFont-Objekt, das als Schriftart für den Lagerschein verwendet wird
		BaseFont baseFont = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        // Ermittelt die Anzahl der Seiten in der PDF-Vorlage
        int pages = document.getNumberOfPages();
        // Vorsorglich eingebaute Schleife über alle Seiten in der PDF-Datei für künftige Dokumente
        for(int i=1; i<=pages; i++) {
        // Ruft das PdfContentByte-Objekt für die aktuelle Seite ab, um darauf zu schreiben
        PdfContentByte pageContentByte = pdfStamper.getOverContent(i);
        // Schreibt den Mitarbeiter auf die Seite des Lagerscheins
        writeToPdf(baseFont, pageContentByte, employee);
        // Beendet den Schreibvorgang auf der Seite
        pageContentByte.endText();
        }
        // Schließt den PdfStamper und die PDF-Datei
        pdfStamper.close();	     
    }
    // Schreibt den Mitarbeiter in den Lagerschein
    private void writeToPdf(BaseFont baseFont, PdfContentByte pageContentByte, Employee employee) {
        // Beginnt den Schreibvorgang auf der Seite
        pageContentByte.beginText();
        // Setzt die Schriftart und die Schriftgröße
        pageContentByte.setFontAndSize(baseFont, 17);
        // Setzt die Position des Textes auf der Seite
        pageContentByte.setTextMatrix(170, 391);
        // Schreibt den Vor- und Nachnamen des Mitarbeiters auf die Seite
        pageContentByte.showText(employee.getVorname() + " ");
        pageContentByte.showText(employee.getNachname());
    }
}
