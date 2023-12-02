package com.vivek.quizapp.serivce;

import com.vivek.quizapp.model.EmployeeDTO;
import com.vivek.quizapp.model.LoginDTO;
import com.vivek.quizapp.response.LoginResponse;

public interface EmployeeService {
   
	String addEmployee(EmployeeDTO employeeDTO);
	LoginResponse loginEmployee(LoginDTO loginDTO);
}