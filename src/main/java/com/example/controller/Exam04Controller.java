package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

	
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	@RequestMapping(value = "")
	public String index(){
		return "exam04";
	}
	@RequestMapping(value = "/input")
	public String inputs(@Validated UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		if(result.hasErrors()) {
			return index();
		}
		User user = new User();
		BeanUtils.copyProperties(userForm,user);
		
		//requestスコーピに格納する
		model.addAttribute("user",user);
		//flashスコープに格納する
		//redirectAttributes.addFlashAttribute("user",user);
			
		return "exam04-result";
	}
	
	@RequestMapping(value="/result")
	public String result() {
		return "exam04-result";
	}

}
