package com.seenu.studentservice;

import java.util.List;
import com.seenu.entity.students;

public interface studentservice {
	
	public List<students> getAllStudents();
	public students saveStudents(students student);
	
	public students getById(int id);
	
	public void deleteById(int id);
}
