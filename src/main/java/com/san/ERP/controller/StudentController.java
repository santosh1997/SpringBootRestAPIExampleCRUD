package com.san.ERP.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.ERP.dao.StudentDAO;
import com.san.ERP.model.Student;

@RestController
@RequestMapping("/school")
public class StudentController {
	
	@Autowired
	StudentDAO studentDAO;
	
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student){
		return studentDAO.save(student);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentDAO.findAll();
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long studentId){
		Student student = studentDAO.findOne(studentId);
		if(student==null)
			return ResponseEntity.notFound().build();
		else 
			return ResponseEntity.ok().body(student) ;
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id") Long studentId,
			@Valid @RequestBody Student student){
		
		Student studentInRepository = studentDAO.findOne(studentId);
		if(studentInRepository==null)
			return ResponseEntity.notFound().build();
		else
		{
			studentInRepository.setName(student.getName());
			Student updatedStudent = studentDAO.save(studentInRepository);
			return ResponseEntity.ok().body(updatedStudent);
		}
	}
	
	@GetMapping("/deletestudent/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable(value="id") Long studentId){
		Student student = studentDAO.findOne(studentId);
		if(student==null)
			return ResponseEntity.notFound().build();
		else 
		{
			studentDAO.delete(student);
			return ResponseEntity.ok().build() ;
		}
	}
}
