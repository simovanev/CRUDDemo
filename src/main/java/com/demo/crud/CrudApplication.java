package com.demo.crud;

import com.demo.crud.dao.StudentDAO;
import com.demo.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student");
		Student student = new Student("Paul", "Walker","FastAndFurious@gmail.com");

		System.out.println("Saving student");
		studentDAO.save(student);

		System.out.println("Student id: " + student.getId());

	}
}
