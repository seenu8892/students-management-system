package com.seenu.sreviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seenu.StudentRepository.StudentRepository;
import com.seenu.entity.students;
import com.seenu.studentservice.studentservice;

@Service
public class ServiceImpl implements studentservice{
	@Autowired
	StudentRepository studentRepository;
	@Override
	public List<students> getAllStudents() {
		List<students> list= studentRepository.findAll();
		return list;
	}
		
	
	@Override
	public students saveStudents(students student) {
		return studentRepository.save(student);
	}


	@Override
	public students getById(int id) {
		return studentRepository.findById(id).get();
	}


	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);		
	}
	
	
}
