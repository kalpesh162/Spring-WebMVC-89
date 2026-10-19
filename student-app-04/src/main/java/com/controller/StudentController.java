package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String getStudentData(@ModelAttribute("student") Student student, Model model) {

		model.addAttribute("stud", student);

		return "display";
	}
}
