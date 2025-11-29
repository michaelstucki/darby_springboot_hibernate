package com.michaelstucki.cruddemo;

import com.michaelstucki.cruddemo.dao.StudentDAO;
import com.michaelstucki.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
 //            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudents(studentDAO);
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

    private void readStudent(StudentDAO studentDAO) {
        // Create student
        Student student = new Student("Dafy", "Duck", "dafy@icloud.com");
        // Save student
        studentDAO.save(student);
        // Display student id
        System.out.println(student.getId());
        // Get student by id
        student = studentDAO.findById(student.getId());
        // Display student
        System.out.println(student);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // Get list of students
        List<Student> students = studentDAO.findAll();
        // Display students
        for(Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // Get students with lastName
        List<Student> students = studentDAO.findByLastName("A");
        // Display students
        for(Student student : students) {
            System.out.println(student);
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        Student student = studentDAO.findById(studentId);
        student.setFirstName("Peter");
        studentDAO.update(student);
        System.out.println(student);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        studentDAO.delete(studentId);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        int studentsDeleted = studentDAO.deleteAll();
        System.out.println(studentsDeleted);
    }
}
