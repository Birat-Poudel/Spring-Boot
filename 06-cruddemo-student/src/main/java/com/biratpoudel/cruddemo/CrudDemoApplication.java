package com.biratpoudel.cruddemo;

import com.biratpoudel.cruddemo.dao.StudentDAO;
import com.biratpoudel.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
//          createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAll(studentDAO);
        };
	}

	private void deleteAll(StudentDAO studentDAO) {
		int num = studentDAO.deleteAll();
		System.out.println("Number of rows deleted: " + num);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 1;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		myStudent.setFirstName("hari");
		myStudent.setLastName("shyam");
		studentDAO.update(myStudent);

		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByLastName("Bhattarai");

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Retrieving student with id: "+ 1);
		Student myStudent = studentDAO.findById(3);
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating new student object...");
		Student tempStudent1 = new Student("Satyam", "Ghimire", "satyamstar@gmail.com");
		Student tempStudent2 = new Student("Sijan", "Bhattarai", "sijanhero@gmail.com");
		Student tempStudent3 = new Student("Saurav", "Bhandari", "sauravprince@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student, Generated id: " + tempStudent1.getId());
		System.out.println("Saved student, Generated id: " + tempStudent2.getId());
		System.out.println("Saved student, Generated id: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Birat", "Poudel", "poudel.birat25@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student, Generated id: " + tempStudent.getId());
	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}
}
