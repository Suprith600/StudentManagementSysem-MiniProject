package com.crud.Services;

import java.util.List;

import com.crud.Entity.Student;

public interface StudentServices {
	
	String addStudent(Student s);
	Student getStudent(String kodId);
	List<Student> getAllStudents();
	String updateStudent(Student s);
	String deleteStudent(String kodId);

}
