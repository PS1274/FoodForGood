package com.ps.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.demo.DonationEntity.DonateEntity;
import com.ps.demo.DonationEntity.Employee;
import com.ps.demo.donationrepo.EmployeeRepo;
import com.ps.demo.donationservice.EmployeeDTO;
import com.ps.demo.donationservice.EmployeeService;
import com.ps.demo.donationservice.LoginDTO;
import com.ps.demo.security.LoginMesage;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;


//@RestController
@Controller
@CrossOrigin
@RequestMapping("/login")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public String loginform() {

		return "login";
	}
	
//	@PostMapping(path="/save")
//	public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
//	 String id= employeeService.addEmployee(employeeDTO);
//	 return id;
//	}
	@PostMapping(path="/save")
	public String saveEmployee(@ModelAttribute EmployeeDTO e, HttpSession session) {
		employeeService.addEmployee(e);
		session.setAttribute("msg", "Donator Added Sucessfully..");
		return "redirect:/login";
	}
	
	
	 @Autowired
	   private PasswordEncoder passwordEncoder;
	
	@Autowired
  private EmployeeRepo employeeRepo;
	
	
	
	@PostMapping(path="/signin")
	public String loginEmployee(LoginDTO loginDTO){
		Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
	       if (employee1 != null) {
	           String password = loginDTO.getPassword();
	           String encodedPassword = employee1.getPassword();
	           Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	           if (isPwdRight) {
	               Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
	               if (employee.isPresent()) {
	                   return "aboutusdon";
	               } else {
	                   return "error";
	               }
	           } else {

	               return "password Not Match";
	           }
	       }else {
	           return "Email not exits";
	       }

	}
	/*
	 * @PostMapping(path="/signin") public
	 * ResponseEntity<?>loginEmployee(@RequestBody LoginDTO loginDTO){ LoginMesage
	 * loginMesage=employeeService.loginEmployee(loginDTO); return
	 * ResponseEntity.ok(loginMesage); }
	 */
//	@PostMapping(path="/signin")
//	public String loginEmployee(@ModelAttribute LoginDTO ep, HttpSession session){
//		employeeService.loginEmployee(ep);
//		session.setAttribute("msg", "Login Sucessfully..");
//		return "redirect:/";
//	}
	
	/*
	 * @PostMapping("/register") public String empRegister(@ModelAttribute
	 * DonateEntity e, HttpSession session) { service.addEmp(e);
	 * session.setAttribute("msg", "Donator Added Sucessfully.."); return
	 * "redirect:/"; }
	 */
	
}
