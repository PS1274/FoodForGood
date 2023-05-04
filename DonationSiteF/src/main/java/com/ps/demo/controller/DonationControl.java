package com.ps.demo.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps.demo.DonationEntity.DonateEntity;
import com.ps.demo.donationservice.DonationService;


import jakarta.servlet.http.HttpSession;

@Controller
public class DonationControl {
	@Autowired
	private DonationService service;
	
	@GetMapping("/cart")
	public String home(Model m) {
		List<DonateEntity> emp=service.getALLEmp();
		m.addAttribute("emp",emp);
		
		return "index";
	}
	
	@GetMapping("/certi")
	public String certificate() {
		return "certificate";
	}
	@GetMapping("/aboutusdon")
	public String aboutusdon() {
		return "aboutusdon";
	}
	
	
	@GetMapping("/thanks")
	public String thanks() {
		return "thankyou";
	}
	
	@GetMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}
	
	@GetMapping("/login/addemp")
	public String addEmpForm() {
		return "add_emp";
	}
//	@GetMapping("/qrpage")
//	public String qrpageForm() {
//		return "qrpage";
//	}

//	@RequestMapping("/login")
//	public String loginForm() {
//		return "login";
//	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute DonateEntity e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Added Sucessfully..");
		return "redirect:/cart";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		DonateEntity e = service.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute DonateEntity e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Donor Data Update Sucessfully..");
		return "redirect:/cart";
	}
 
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {

		service.deleteEMp(id);
		session.setAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/cart";
	}
	
//	@GetMapping("/login")
//	public String loginForm() {
//		return "login";
//	}
	
//	 @PostMapping("/error")
//		 String error(){
//			 return "redirect:/";
//		 }
	 
}
