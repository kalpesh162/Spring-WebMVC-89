package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String openForm() {
		return "studform";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String getStudentData(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String marks = request.getParameter("marks");

		System.out.println(id);
		System.out.println(name);
		System.out.println(marks);

		model.addAttribute("sid", id);
		model.addAttribute("sname", name);
		model.addAttribute("smarks", marks);

		return "display";
	}

}
