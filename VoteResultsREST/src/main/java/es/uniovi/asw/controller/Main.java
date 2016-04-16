package es.uniovi.asw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import es.uniovi.asw.factories.Factories;
import es.uniovi.asw.model.Voting;
import es.uniovi.asw.model.VotingResults;


@Controller
public class Main {

  private static final Logger LOG = LoggerFactory.getLogger(Main.class);
  @Autowired
  Factories factories;
  @RequestMapping(value = "/voting",consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<VotingResults> getVotingInfo(@RequestBody Voting voting) {
	  
  	return  new ResponseEntity<VotingResults>(factories.getBusinessFactory().getResults(voting), HttpStatus.OK);
  	} 
}