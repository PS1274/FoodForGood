package com.ps.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ps.demo.DonationEntity.ContactUsEntity;
import com.ps.demo.donationrepo.ContactUsRepo;

@Controller
public class ContactUsController {
	@Autowired
	ContactUsRepo repo;
	
	@GetMapping("/contactus")
	  public String details() {
		  
		  return "contactus";
	  }
	@RequestMapping("/details")
	  public String details(ContactUsEntity customers) {
		  repo.save(customers);
		  return "contactus";
	  }
	@RequestMapping("/getdetails")
	  public String getdetails() {
		  
		  return "details";
	  }

	
	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int cid){
		    ModelAndView mv =new ModelAndView("Retrive.jsp");
		    ContactUsEntity customers=repo.findById(cid).orElse(null);
		   mv.addObject(customers);
		   return mv;
	}
//	
//	@RequestMapping("/customers")
//	@ResponseBody
//	public List<ContactUsEntity>  getcustoms() {
//		return repo.findAll();
//	}
//	@RequestMapping("/customers/{cid}")
//	@ResponseBody
//	public String  getcustoms2(@PathVariable("cid")int cid ){
//		return repo.findById(cid).toString();
//	}
//	@PostMapping("/customers")
//	@ResponseBody
//	public ContactUsEntity  getcustoms3(@RequestBody ContactUsEntity customers) {
//		repo.save(customers);
//		return customers;
//	}
//	@DeleteMapping("/customers/{cid}")
//	@ResponseBody
//	public ContactUsEntity  getcustoms4(@PathVariable("cid")int cid ) {
//		ContactUsEntity cust = repo.getReferenceById(cid);
//		repo.delete(cust);
//		return cust;
//	}
//	@PutMapping(path="/customers",consumes= {"application/json"})
//	@ResponseBody
//	public ContactUsEntity  getcustoms5(@RequestBody ContactUsEntity customers ) {
//		
//		repo.save(customers);
//		return customers;
//	}
}
