package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "res")
public class Result {
	
	@Id
	@Column(name = "matchID")
	private String matchID;
	
	@Column(name = "matchName")
	private String matchName;
	
	@Column(name = "endResult")
	private String endResult;
	
	public Result() {
		
	}
	
	public Result(String matchID, String matchName, String endResult) {
		super();
		this.matchID = matchID;
		this.matchName = matchName;
		this.endResult = endResult;
	}
	

	public String getmatchID() {
		return matchID;
	}
	public void setmatchID(String matchID) {
		this.matchID = matchID;
	}
	public String getmatchName() {
		return matchName;
	}
	public void setmatchName(String matchName) {
		this.matchName = matchName;
	}
	public String getendResult() {
		return endResult;
	}
	public void setendResult(String endResult) {
		this.endResult = endResult;
	}
}