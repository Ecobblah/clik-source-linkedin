package com.linkedin.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.linkedin.model.Candidate;

@Repository
public interface LinkedinService extends MongoRepository<Candidate, Integer> {
	public Candidate findById(String id);
	public Candidate findByUserName(String userName);
}
