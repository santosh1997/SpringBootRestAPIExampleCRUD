package com.san.ERP.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.ERP.model.Student;
import com.san.ERP.repository.StudentRepository;

@Service
public class StudentDAO {
	@Autowired
	StudentRepository studentRepository;
	
	public Student save(Student student){
		return studentRepository.save(student);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student findOne(long studentId){
		return studentRepository.findOne(studentId);
	}
	
	public void delete(Student student){
		studentRepository.delete(student);
	}
}