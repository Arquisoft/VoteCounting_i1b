package es.uniovi.asw;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.uniovi.asw.model.Vote;
import es.uniovi.asw.model.Voting;
import es.uniovi.asw.persistence.VoteRepository;
import es.uniovi.asw.persistence.VotingRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class MainControllerTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testLandingVotings() throws Exception {
    mvc.perform(get("/votings")).andExpect(status().isOk()).andExpect(content().string(containsString("Voting")))
    	.andExpect(content().string(containsString("Voting 1"))).andExpect(content().string(containsString("[{\"id\":1")));
  }
  
  @Test
  public void testLandingOneVoting() throws Exception {
    mvc.perform(get("/voting?id=1")).andExpect(status().isOk())
    	.andExpect(content().string(containsString("Voting 1")))
    	.andExpect(content().string(containsString("{\"No\":2")));
  }
 }