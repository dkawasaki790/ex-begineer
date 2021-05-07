package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.Exam02Form;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	
	@Autowired
	private HttpSession session;

	@ModelAttribute
	public Exam02Form setUpForm() {
		return new Exam02Form();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam02";
	}
	@RequestMapping("/input")
	public String inputs(Exam02Form exam02Form) {
		
		int num1= exam02Form.getNum1();
		int num2= exam02Form.getNum2();
		int total=num1 + num2;
	
		session.setAttribute("num1",num1);
		session.setAttribute("num2",num2);
		session.setAttribute("total", total);
		
		return "exam02-result";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "exam02-result";
	}
	@RequestMapping("/result2")
	public String result2() {
		return "exam02-result2";
	}

}
