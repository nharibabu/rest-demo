package com.dxc.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.rest.data.Student;
import com.dxc.rest.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> list;
	
	@PostConstruct
	public void loadData() {
		
		list = new ArrayList<Student>();
		list.add(new Student("Jayanth", "N"));
		list.add(new Student("Sri Krishna", "N"));
		list.add(new Student("Stut", "N"));
	}
	
	@GetMapping("/students")
	public List<Student> students() {
		
		return list;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		
		if(id < 0 || id >= list.size()) {
			throw new StudentNotFoundException("Student Id not found - "+id);
		}
		
		return list.get(id);
		
	}
	
	

}
