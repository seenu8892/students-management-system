package com.seenu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.seenu.entity.students;
import com.seenu.studentservice.studentservice;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller

public class controller {
	@Autowired  //all the object and all things are created by spring automaticaly
	private studentservice service;
	
	@GetMapping("/home")
	 public String home() {
		 return "home";
	 }
	
	@GetMapping("/students")
	public String getAllStudents (Model model) {
		model.addAttribute("students", service.getAllStudents()); // go to Studentservice will get getAllstudents method and go to serviceImpl
		return "students"; // return the students.html
	}
	
	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		students student = new students(); //to hold student object
		model.addAttribute("student", student); //this student object basically stores the data that come from form.. and stores in key that is students(entity) 
				
		return "create-student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") students student) { //@ModelAttribute is used to get the data from object 
		service.saveStudents(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("student",service.getById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id , @ModelAttribute ("student") students student) {
		students existingStudent =  service.getById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		service.saveStudents(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/students";	
	}
}
