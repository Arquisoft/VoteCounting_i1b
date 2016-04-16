package es.uniovi.asw.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.ResultsAction;
import es.uniovi.asw.model.Voting;
import es.uniovi.asw.model.VotingResults;
@Service
public class BusinessFactory {

	@Autowired ResultsAction results;
	
	public VotingResults getResults(Voting voting) {
		
		return results.execute(voting);		
	}

}
