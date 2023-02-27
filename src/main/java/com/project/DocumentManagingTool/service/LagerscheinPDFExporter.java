package com.project.DocumentManagingTool.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.project.DocumentManagingTool.model.Employee;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


@Service
public class LagerscheinPDFExporter {

    public LagerscheinPDFExporter(){}


    public void export(HttpServletResponse response, Employee employee) throws DocumentException, IOException {

        PdfReader document = new PdfReader("/Dokumente/Lagerentnahmeschein.pdf");
        PdfStamper pdfStamper = new PdfStamper(document, response.getOutputStream());

		BaseFont baseFont = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        int pages = document.getNumberOfPages(); 
        for(int i=1; i<=pages; i++) { 
        PdfContentByte pageContentByte = pdfStamper.getOverContent(i);
        
        writeToPdf(baseFont, pageContentByte, employee);
        pageContentByte.endText();
        }
        pdfStamper.close();	     
       
    }

    private void writeToPdf(BaseFont baseFont, PdfContentByte pageContentByte, Employee employee) {
        pageContentByte.beginText();
        pageContentByte.setFontAndSize(baseFont, 17);
        pageContentByte.setTextMatrix(170, 391);
        pageContentByte.showText(employee.getVorname() + " ");
        pageContentByte.showText(employee.getNachname());
    }
}
