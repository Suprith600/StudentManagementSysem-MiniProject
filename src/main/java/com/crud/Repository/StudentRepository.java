package com.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, String>
{

}
