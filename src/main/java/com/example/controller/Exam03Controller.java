package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.Exam03Form;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;

	@ModelAttribute
	public Exam03Form setUpForm() {
		return new Exam03Form();
	}
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	@RequestMapping("/input")
	public String inputs(Exam03Form exam03Form) {
		
		int num1= exam03Form.getNum1();
		int num2= exam03Form.getNum2();
		int num3= exam03Form.getNum3();

		int total=num1 + num2 + num3;
		int taxedPrice = (int)(total*1.1);
		

		application.setAttribute("total", total);
		application.setAttribute("taxedPrice", taxedPrice);

		return "exam03-result";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "exam03-result";
	}

}
