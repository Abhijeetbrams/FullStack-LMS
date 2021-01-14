package com.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POJO.EmployeeDetails;
import com.POJO.Leaves;
import com.POJO.Response;
import com.Repository.EmployeeDetailsRepo;

@RestController
@RequestMapping("/api/v1")
public class EmployeeDetailsController {

	@Autowired
	public EmployeeDetailsRepo empRepo;
	
	@GetMapping("/employeedetails")
	public ResponseEntity<List<EmployeeDetails>> getEmployees(){
		
	   List<EmployeeDetails> employees=(List<EmployeeDetails>) empRepo.findAll();
	   return new ResponseEntity<List<EmployeeDetails>>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/employeedetails/{email_id}")
	public ResponseEntity<EmployeeDetails> getEmployeeByEmail(@PathVariable("email_id") String email_id)
	{
		Optional<EmployeeDetails> details=empRepo.findById(email_id);
		EmployeeDetails emp=null;
		if(details.get()!=null)
		{
			emp=details.get();
		}
		else
		{
			throw new RuntimeException("Can't Find the Employee By this -"+email_id);
		}
		
		return new ResponseEntity<EmployeeDetails>(emp,HttpStatus.OK);
	}
	
	@PostMapping("/employeedetails")
	public ResponseEntity<Response> addEmployeeDetails(@RequestBody EmployeeDetails emp)
	{
		Leaves leaves=new Leaves();
		leaves.setBereavement_leave(7);
		leaves.setCasual_leave(4);
		leaves.setEarned_leaves(15);
		leaves.setId(0);
		leaves.setMarriage_leave(12);
		leaves.setPaternity_leave(7);
		leaves.setSick_leave(4);
		
		emp.add(leaves);
		empRepo.save(emp);
		Response response = new Response();
		response.setCode(HttpStatus.CREATED.toString());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		   
		response.setDate(dtf.format(now));
		response.setMessage("Succesfully Inserted");
		
		return new ResponseEntity<Response>(response,HttpStatus.CREATED);
	}
}
