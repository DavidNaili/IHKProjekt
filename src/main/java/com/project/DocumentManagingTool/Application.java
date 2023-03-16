// Diese Zeile deklariert das Package, zu dem diese Klasse gehört
package com.project.DocumentManagingTool;

// Diese Zeilen importieren Klassen, die in der Anwendung verwendet werden
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Diese Zeile kennzeichnet die Klasse als Spring Boot Anwendung
@SpringBootApplication
public class Application {

	// Diese Methode ist der Einstiegspunkt der Anwendung, wenn sie ausgeführt wird
	public static void main(String[] args) {
		// Diese Zeile ruft die run-Methode von SpringApplication auf und übergibt die Klasse Application und die Argumente args
		SpringApplication.run(Application.class, args);
	}
}