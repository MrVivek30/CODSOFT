package com.codsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codsoft.exception.StudentException;
import com.codsoft.model.Student;
import com.codsoft.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	  @Autowired
   private StudentRepository studentRepository;

  
      @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student removeStudent(Integer studentId) throws StudentException{
	Student student=studentRepository.findById(studentId).orElseThrow(()->new StudentException("Student not found whith this id "+studentId));
		
	studentRepository.delete(student);
		
		return student;
    }

    @Override
    public Student searchStudent(Integer studentId) throws StudentException{
        return studentRepository.findById(studentId).orElseThrow(()->new StudentException("Student not found whith this id "+studentId));
        		
       	}

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Student updateStudent(Student student) throws StudentException{
    	Student student2=studentRepository.findById(student.getId()).orElseThrow(()->new StudentException("Student not found whith this id "+student.getId()));
    	return studentRepository.save(student);
    	
    }
}