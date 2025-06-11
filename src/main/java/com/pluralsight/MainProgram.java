package com.pluralsight;

// These are special Spring Boot imports that let us start the app.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This is a special annotation that tells Spring Boot:
// "This is the main class for your application."
// It turns on many helpful features automatically (auto-configuration, component scanning, etc.).
@SpringBootApplication
public class MainProgram {

	// This is the "main method" — the starting point of any Java application.
	// When you run the app, Java looks for this method first.
	public static void main(String[] args) {
		// This line starts the entire Spring Boot application.
		// It does 3 main things:
		// 1. Creates the Spring "ApplicationContext" (this is like the brain of Spring that manages everything).
		// 2. Scans for your @Component classes (like FilmApp, SimpleFilmDao, etc.) and creates them automatically.
		// 3. Starts the web server (if your app had web controllers), or calls CommandLineRunner beans (like your FilmApp).

		SpringApplication.run(MainProgram.class, args);

		// After this line runs, your app is running!
		// If you have a CommandLineRunner (like FilmApp), its run() method will now be called.
	}

}
