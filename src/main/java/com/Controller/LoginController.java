package com.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POJO.Credentials;
import com.POJO.Response;
import com.Repository.CredentialsRepository;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class LoginController {

	@Autowired
	public CredentialsRepository  credsRepo;
	
	@GetMapping("/credentials/{emailId}")
	public ResponseEntity<Credentials> getCredentialsByEmail(@PathVariable("emailId") String email)
	{
		Optional<Credentials> result= credsRepo.findById(email);
		Credentials creds=null;
		if(result.get()!=null)
		{
			creds=result.get();
		}
		else
		{
			throw new RuntimeException("Please enter the Email Id");
		}
		
		return new ResponseEntity<Credentials>(creds,HttpStatus.OK);
	}
	
	@PostMapping("/credentials")
	public ResponseEntity<Response> addCredentials(@RequestBody Credentials creds)
	{
		Optional<Credentials> result= credsRepo.findById(creds.getEmail_id());
		if(result.get()==null)
		{
			credsRepo.save(creds);
		}
		else
		{
			throw new RuntimeException("Email Id already exists");
		}
		Response response=new Response();
		response.setCode(HttpStatus.OK+"");
		response.setMessage("Successfully Added to the DB");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
        response.setDate(dtf.format(now));		
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
}
