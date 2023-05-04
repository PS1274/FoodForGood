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
import com.ps.demo.DonationEntity.PaymentEntity;
import com.ps.demo.donationrepo.ContactUsRepo;
import com.ps.demo.donationrepo.PaymentRepo;

@Controller
public class PaymentController {
	@Autowired
	PaymentRepo repo;
	@GetMapping("/payment")
	  public String detail() {
		  
		  return "paymentgateway";
	  }
	@RequestMapping("/detail")
	  public String detail(PaymentEntity customers) {
		  repo.save(customers);
		  return "qrpage";
	  }
//	@RequestMapping("/getdetail")
//	  public String getdetail() {
//		  
//		  return "detail";
//	  }

	
	@PostMapping("/getdetail")
	public ModelAndView getdetail(@RequestParam int cid){
		    ModelAndView mv =new ModelAndView("Retrive.jsp");
		    PaymentEntity customers=repo.findById(cid).orElse(null);
		   mv.addObject(customers);
		   return mv;
	}
//	@RequestMapping("/getdetails")
//	  public String getdetails() {
//		  
//		  return "details";
//	  }

//	
	@PostMapping("/detailspayment")
	public ModelAndView getdetails(@RequestParam int cid){
		    ModelAndView mv =new ModelAndView("Retrive.jsp");
		    PaymentEntity customers=repo.findById(cid).orElse(null);
		   mv.addObject(customers);
		   return mv;
	}
}