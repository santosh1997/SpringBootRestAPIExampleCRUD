package com.san.ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.san.ERP.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
