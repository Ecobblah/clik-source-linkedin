package com.linkedin.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.model.Candidate;
import com.linkedin.service.LinkedinServiceImp;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LinkdeinController {
	
	@Autowired
	LinkedinServiceImp service;
	
	// List all candidates
	@GetMapping("/candidate/getall")
	public ResponseEntity<List<Candidate>> getAllCandidates() {
		List<Candidate> list = service.getAllCandidates();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	// Get candidate by ID
	@GetMapping("/candidate/id/{id}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable String id) {
		Candidate candidate = service.getCandidateById(id);
		if(candidate == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.status(HttpStatus.OK).body(candidate);
	}
	
	// Get candidate by UserName
	@GetMapping("/candidate/username/{userName}")
	public ResponseEntity<Candidate> getCandidateByUserName(@PathVariable String userName) {
		Candidate candidate = service.getCandidateByUserName(userName);
		if(candidate == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.status(HttpStatus.OK).body(candidate);
	}
	
	// Add candidate also updates
	@PostMapping("/candidate")
	public ResponseEntity<Candidate> addCandidate(@RequestHeader("Authorization") String token, @RequestBody String userName) {
		Candidate candidate = service.addCandidate(token, userName);
		return ResponseEntity.status((HttpStatus.CREATED)).body(candidate);
	}
	
	// Update candidate, Add should already do this
	@PutMapping("/candidate/{userName}")
	public ResponseEntity<Object> updateCandidate(@RequestHeader("Authorization") String token, @PathVariable String userName){
		if(service.getCandidateByUserName(userName) == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			service.deleteCandidateByUserName(userName);
			service.addCandidate(token, userName);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}

}
