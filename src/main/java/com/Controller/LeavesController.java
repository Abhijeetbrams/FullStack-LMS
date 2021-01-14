package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POJO.Leaves;
import com.Repository.LeavesRepo;

@RestController
@RequestMapping("/api/v1")
public class LeavesController {
	
	@Autowired
	public LeavesRepo leavesrepo;

	@GetMapping("/leaves")
	public ResponseEntity<List<Leaves>> getLeaves()
	{
		List<Leaves> leaves=(List<Leaves>) leavesrepo.findAll();
		return new ResponseEntity<List<Leaves>>(leaves,HttpStatus.OK); 
	}
}
