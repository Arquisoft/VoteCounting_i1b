package es.uniovi.asw.model;

import java.util.HashMap;
import java.util.Map;

public class VotingResults 
{
	String votingDescription;	
	Map<String, Integer> results = new HashMap<String, Integer>();
	
	
	public VotingResults() {
	
	}
	public VotingResults(String votingDescription) {
		this.votingDescription=votingDescription;
	}
	public VotingResults() {
	}
	public String getVoting() {
		return votingDescription;
	}
	public void setVoting(String votingDescription) {
		this.votingDescription = votingDescription;
	}
	public Map<String, Integer> getResults() {
		return results;
	}
	public void setResults(Map<String, Integer> results) {
		this.results = results;
	}
	

}
