package com.codsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codsoft.exception.StudentException;
import com.codsoft.model.Student;
import com.codsoft.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student addedStudent = studentService.addStudent(student);
		return new ResponseEntity<>(addedStudent,HttpStatus.CREATED);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<Student> removeStudent(@PathVariable Integer studentId) {
		Student student=studentService.removeStudent(studentId);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<Student> searchStudent(@PathVariable Integer studentId) {
		Student student=studentService.searchStudent(studentId);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {

		List<Student> list = studentService.getAllStudents();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student student2=studentService.updateStudent(student);
		return new ResponseEntity<>(student2,HttpStatus.ACCEPTED);
	}
}
