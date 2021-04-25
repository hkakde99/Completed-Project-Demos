package com.spring.boot.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.beans.StudentBean;
import com.spring.boot.entities.Student;
import com.spring.boot.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	static {
		System.out.println("inside student controller");
	}
	
	public HashMap<String,Object> getDataFromDB() {
		HashMap<String,Object> value = new HashMap<String,Object>();
		value.put("sbean", new StudentBean());
		value.put("slist", service.findAll());
		
		return value;
	}
	
	@RequestMapping(value = "/form",method = RequestMethod.GET)
	public ModelAndView studentForm() {
		return new ModelAndView("studentUI",getDataFromDB());
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute StudentBean stud) {
	    Optional<Student> result = service.findById(stud.getStudId());
	    
	    if(result.isPresent()) {
	    	Student update = result.get();
	    	update.setStudName(stud.getStudName());
	    	service.save(update);
	    	
	    }else {
	    	service.save(getBeanToEntity(stud));
	    }
	    return new ModelAndView("studentUI",getDataFromDB());
	    
	}
	
	@RequestMapping(value = "/edit/{sid}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("sid") Integer id) {
		HashMap<String,Object> value = new HashMap<String,Object>();
		value.put("sbean", service.findById(id));
		return new ModelAndView("studentUI",value);
		
	}
	
	@RequestMapping(value = "/delete/{sid}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("sid") Integer id) {
		service.deleteById(id);
		return new ModelAndView("studentUI",getDataFromDB());
	}

	
	//conversions
	private Student getBeanToEntity(StudentBean student) {
		Student entity = new Student();
		entity.setStudId(student.getStudId());
		entity.setStudName(student.getStudName());
		
		return entity;
	}
	
}
