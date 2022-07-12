package com.crud1.controller;

import java.util.Optional;

import com.crud1.student;
import com.crud1.Repo.Studentrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Homecontroller {
	@Autowired
	Studentrepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/insert")
	public String insert(student s1) {
		repo.save(s1);
		return "home.jsp";
	}
	
	@RequestMapping("/getstudent")
	public ModelAndView getstudent(@RequestParam int rno) {
		
		ModelAndView mv=new ModelAndView("showstudent.jsp");
		student stud=repo.findById(rno).orElse(new student());
		
//		System.out.println(repo.findByDep("CSE"));
		System.out.println(repo.findByRnoGreaterThan(1));
//		System.out.println(repo.findByDepSorted("CSE"));
		
		mv.addObject(stud);
		return mv;
	}
	
	
}
