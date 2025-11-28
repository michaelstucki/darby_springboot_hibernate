package com.michaelstucki.cruddemo;

import com.michaelstucki.cruddemo.dao.StudentDAO;
import com.michaelstucki.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
	}

    // CommandLineRunner is from Spring Boot framework
    // Executes after Spring Beans have been loaded
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createStudents(studentDAO);
        };
    }

    private void createStudents(StudentDAO studentDAO) {
        Student student = new Student("A", "A", "A@icloud.com");
        studentDAO.save(student);
        student = new Student("B", "B", "B@icloud.com");
        studentDAO.save(student);
        student = new Student("C", "C", "C@icloud.com");
        studentDAO.save(student);
    }

    private void createStudent(StudentDAO studentDAO) {
        // Create student instance
        System.out.println("Creating student...");
        Student student = new Student("Michael", "Stucki", "mstucki7@icloud.com");

        // Save student instance
        System.out.println("Saving student...");
        studentDAO.save(student);

        // Display student id
        System.out.println("Saved student. Generated id: " + student.getId());
    }
}
