package com.codsoft.service;

import java.util.List;

import com.codsoft.exception.StudentException;
import com.codsoft.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student);

	public Student removeStudent(Integer studentId) throws StudentException;

	public Student searchStudent(Integer studentId)throws StudentException;

	public Student updateStudent(Student student) throws StudentException;
	
	public List<Student> getAllStudents();
}