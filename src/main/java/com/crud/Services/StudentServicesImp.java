package com.crud.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.Entity.Student;
import com.crud.Repository.StudentRepository;

@Service
public class StudentServicesImp implements StudentServices
{
	StudentRepository srepo;
	
	public StudentServicesImp(StudentRepository srepo)
	{
		super();
		this.srepo=srepo;
	}

	@Override
	public String addStudent(Student s) {
		// TODO Auto-generated method stub
		srepo.save(s);
		return "Student added succesfully";
	}

	@Override
	public Student getStudent(String kodId) {
		// TODO Auto-generated method stub
		Student s=srepo.findById(kodId).get();
		return s;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return srepo.findAll();
	}

	@Override
	public String updateStudent(Student s) {
		// TODO Auto-generated method stub
		srepo.save(s);
		return "student updated succesfully";
	}

	@Override
	public String deleteStudent(String kodId) {
		// TODO Auto-generated method stub
		srepo.deleteById(kodId);
		return "Student deleted sucessfully";
	}
	
	

}
