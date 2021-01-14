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
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/credentials/in")
	public ResponseEntity<Response> getCredentialsByEmail(@RequestBody Credentials creds)
	{
		//Optional<Credentials> result= credsRepo.findById(creds.getEmail_id());
		Credentials theCreds=new Credentials();
		Response response=new Response();
		
		if(credsRepo.findById(creds.getEmail_id()).isPresent())
		{
			Optional<Credentials> result= credsRepo.findById(creds.getEmail_id());
			theCreds=result.get();
			System.out.println(theCreds.getPassword());
			System.out.println(creds.getPassword());
				
			if(!theCreds.getPassword().equals(creds.getPassword()))
			{
				response.setCode(HttpStatus.BAD_REQUEST+"");
				response.setMessage("Incorrect Password");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
		        response.setDate(dtf.format(now));
			}
			else
			{
				response.setCode(HttpStatus.OK+"");
				response.setMessage("Successfully Logged In");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
		        response.setDate(dtf.format(now));
			}
		}
		else
		{
			response.setCode(HttpStatus.BAD_REQUEST+"");
			response.setMessage("Email-ID not exists");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
	        response.setDate(dtf.format(now));
		}
		
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	
	@PostMapping("/credentials")
	public ResponseEntity<Response> addNCredentials(@RequestBody Credentials creds)
	{
		
		System.out.println(creds);
		Credentials theCred= new Credentials();
		Response response=new Response();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
        response.setDate(dtf.format(now));
        boolean value=credsRepo.findById(creds.getEmail_id()).isPresent();
        System.out.println(value);
		if(!value)
		{
			theCred.setDisplay_name(creds.getDisplay_name());
			theCred.setEmail_id(creds.getEmail_id());
			theCred.setPassword(creds.getPassword());
			credsRepo.save(theCred);
			response.setCode(HttpStatus.OK+"");
			response.setMessage("Successfully Added to the DB");
			System.out.println("Not null");
		}
		else
		{
			response.setCode(HttpStatus.CONFLICT+"");
			response.setMessage("Email Already exists");
			System.out.println("Nullify");
		}
			
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	
}
