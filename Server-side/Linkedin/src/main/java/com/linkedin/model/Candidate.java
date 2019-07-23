package com.linkedin.model;

import org.springframework.data.annotation.Id;

public class Candidate {
	
	@Id
	String id;
	
	String userName;
	
	CandidateBasics info;
	
	public Candidate(String userName, CandidateBasics info) {
		super();
		this.userName = userName;
		this.info = info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public CandidateBasics getInfo() {
		return info;
	}

	public void setInfo(CandidateBasics info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", userName=" + userName + ", info=" + info + "]";
	}
	
	
	

}
