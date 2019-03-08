package com.vitthal.student.dal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vitthal.student.dal.entities.Student;
import com.vitthal.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void createStudent() {
		Student student = new Student();
		student.setName("john");
		student.setCourse("Spring boot with Microservices");
		student.setFee(30d);
		studentRepository.save(student);
	}

	@Test
	public void testFindStudentById() {

		Student student = studentRepository.findOne(1L);
		System.out.println(student);
	}

	@Test
	public void testUpdateStudent() {
		Student student = studentRepository.findOne(1L);
		student.setFee(7777d);
		Student savedStudent = studentRepository.save(student);
		System.out.println(savedStudent);
	}
	
	@Test
	public void testDeleteStudent() {
		Student student = new Student();
		student.setId(2L);
		studentRepository.delete(student);
	}

}
