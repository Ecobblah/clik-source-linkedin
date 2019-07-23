package com.linkedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.linkedin.model.Candidate;
import com.linkedin.model.CandidateBasics;

@Service
public class LinkedinServiceImp {
	
	/*
	 * To update find delete and add.
	 */

	@Autowired
	LinkedinService service;
	
	// Add By Token and user name
	public Candidate addCandidate( String token, String userName ) {
		String url = "https://api.linkedin.com/v2/me";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer  " + token);
		HttpEntity entity = new HttpEntity(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CandidateBasics> response = restTemplate.exchange(
			    url, HttpMethod.GET, entity, CandidateBasics.class);
		Candidate candidate = new Candidate (userName ,response.getBody());
		if ( getCandidateById(candidate.getInfo().getId()) == null )
			service.save(candidate);
		else {
			// incase there old info on a candidate it bacially updates
			deleteCandidate(candidate.getInfo().getId());
			service.save(candidate);
		}
		return candidate;
	}
	
	// Add by Candidate
	public void addCandidate( Candidate c ) {
			service.save(c);
	}
	
	// get all 
	public List<Candidate> getAllCandidates(){
		return service.findAll();
	}
	
	// Find by ID
	public Candidate getCandidateById(String id) {
		for(Candidate i: service.findAll()) 
			if(i.getInfo().getId().equals(id))
				return i;
		return null;
	}
	
	// Find by UserName
	public Candidate getCandidateByUserName(String userName) {
		Candidate candidate = service.findByUserName(userName);
		System.out.println(candidate);
		if( candidate == null )
			return null;
		else
			return candidate;
	}
	
	// Delete By ID
	public void deleteCandidate(String id) {
		Candidate candidate = getCandidateById(id);
		service.delete(candidate);
	}
	
	// Delete candidate By Username
	public void deleteCandidateByUserName(String userName) {
		Candidate candidate = getCandidateByUserName(userName);
		service.delete(candidate);
	}
	

}
