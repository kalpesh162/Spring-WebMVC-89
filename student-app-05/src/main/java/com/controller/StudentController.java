package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Student;
import com.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	private StudentService service = null;

	@Autowired
	public void setStudentService(StudentService service) {
		this.service = service;
	}

	@RequestMapping(value = "/")
	public String openStudentForm() {
		System.out.println("openStudentform");
		return "studform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student) {
		System.out.println(student);
		service.enrolledStudent(student);
		return "display";
	}
	
	
	@RequestMapping(value = "/read" , method = RequestMethod.GET)
	public String showAllStuents(Model model) {
		// all students
		List<Student> students=service.getAllStudents();
		model.addAttribute("students", students);
		return "display";
	}

}
