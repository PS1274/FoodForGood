package com.ps.demo.donationservice;



import com.ps.demo.security.LoginMesage;


public interface EmployeeService {
   String addEmployee(EmployeeDTO employeeDTO);

   LoginMesage loginEmployee(LoginDTO loginDTO);


}