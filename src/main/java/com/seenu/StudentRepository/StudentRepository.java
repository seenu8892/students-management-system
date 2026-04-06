package com.seenu.StudentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seenu.entity.students;

@Repository
public interface StudentRepository extends JpaRepository<students, Integer>{
	

}
