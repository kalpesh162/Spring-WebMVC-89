package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/open")
	public String openForm() {

		return "studform";
	}

	@RequestMapping("/show")
	public String getStudentData(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("marks") double marks, Model model) {

		Student student = new Student(id, name, marks);
		model.addAttribute("stud", student);

		return "display";
	}
}
