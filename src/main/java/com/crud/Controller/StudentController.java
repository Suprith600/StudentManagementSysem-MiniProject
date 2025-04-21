package com.crud.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Entity.Student;
import com.crud.Services.StudentServices;

@Controller
public class StudentController {

	StudentServices ss;
	
	public StudentController(StudentServices ss)
	{
		super();
		this.ss=ss;
	}
	
	@GetMapping("/home")
	public String mapHome() {
		return "index";
	}
	
	@GetMapping("/add")
	public String mapregisterstud() {
		return "register";
	}
	
	@GetMapping("/viewI")
	public String mapviewstud() {
		return "ViewInfo";
	}
	
	@GetMapping("/del")
	public String mapremovestud() {
		return "remove";
	}
	
	@GetMapping("/up")
	public String mapUpdatestud() {
		return "updateInfo";
	}
	
	@GetMapping("/showInfo")
	public String mapShowstud() {
		return "showInfo";
	}
	
	
	
	@PostMapping("/addStud")
	public String addStudent(@RequestParam("sid") String kodId,
							@RequestParam("sname") String name,
							@RequestParam("sbranch") String branch)
	{
		Student s=new Student(kodId,name,branch);
		ss.addStudent(s);
		return "index";
	}
	
	@GetMapping("/getStud")
	public String getStudent(@RequestParam("sid") String kodId, Model model)
	{
		Student st=ss.getStudent(kodId);
		model.addAttribute("student", st);
		return "showInfo";
	}
	
	@GetMapping("/viewAll")
	public String getAllStudents(Model model)
	{
		List<Student> stList= ss.getAllStudents();
		model.addAttribute("list", stList);
		return "showAll";
	}
	
	@PutMapping("/updateStud")
	public String updateStudent(@RequestParam("sid") String kodId,
			@RequestParam("sname") String name,
			@RequestParam("sbranch") String branch)
	{
		
		Student s=ss.getStudent(kodId);
		s.setName(name);
		s.setBranch(branch);
		ss.updateStudent(s);
		return "index";
	}
	
	@DeleteMapping("/delStud")
	public String deleteStudent(@RequestParam("sid") String kodId)
	{
		ss.deleteStudent(kodId);
		return "index";
	}
}
