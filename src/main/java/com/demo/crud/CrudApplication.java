package com.demo.crud;

import com.demo.crud.dao.StudentDAO;
import com.demo.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			// createStudent(studentDAO);
			// readStudent(studentDAO);
			// listOfStudents(studentDAO);
			// listByLastName(studentDAO);
			updateStudentName(studentDAO);
		};
	}

	private void updateStudentName(StudentDAO studentDAO) {
		Student student=studentDAO.findAll().get(1);
		student.setFirstName("Gosho");
		student.setLastName("Bonchev");
		studentDAO.update(student);
		System.out.println(student.toString());
	}

	private void listByLastName(StudentDAO studentDAO) {
		List<Student> theList=studentDAO.findByLastName("Dow");
		for(Student student : theList){
			System.out.println(student);
		}
	}

	private void listOfStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println(" Creating a new student");
		Student student = new Student("John", "Dow","johnDow@com");

		System.out.println("Save new student");
		studentDAO.save(student);

		System.out.println("Saved student id id: "+student.getId());


		Student theStudent=studentDAO.readStudent(student.getId());
		System.out.println(" the saved student is: "+theStudent.toString());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student");
		Student student = new Student("Paul", "Walker","FastAndFurious@gmail.com");

		System.out.println("Saving student");
		studentDAO.save(student);

		System.out.println("Student id: " + student.getId());

	}
}
