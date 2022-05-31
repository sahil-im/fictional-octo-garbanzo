package com.boot.demo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	StudentRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/addStudent")
	public String addStudent(Student student) {
		repo.save(student);
		return "home";
	}

	@RequestMapping("/getData")
	public ModelAndView getData(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("showData");
		Student student = repo.findById(id).orElse(new Student());
		mv.addObject(student);
		return mv;
	}

	@RequestMapping("/students")
	@ResponseBody
	public String students() {
		return repo.findAll().toString();
	}

	@RequestMapping("/students/{id}")
	@ResponseBody
	public String studentsByID(@PathVariable("id") int id) {
		return repo.findById(id).toString();
	}

	@RequestMapping("/studentsList")
	@ResponseBody
	public List<Student> studentsList() {
		return repo.findAll();
	}

	@RequestMapping("/studentsIDList/{id}")
	@ResponseBody
	public Optional<Student> studentsByIDList(@PathVariable("id") int id) {
		return repo.findById(id);
	}

	@PostMapping("/students")
	public Student studentsInsert(@RequestBody Student student) {
		repo.save(student);
		return student;
	}
	
	@DeleteMapping("/students/{id}")
	public Student studentsDelete(@PathVariable("id") int id) {
		@SuppressWarnings("deprecation")
		Student student=repo.getOne(id);
		repo.delete(student);
		return student;
	}
	
	@PutMapping(path="/students", consumes = {"application/json"})
	public Student studentsUpdate(@RequestBody Student student) {			
		repo.save(student);
		return student;
	}
}
