package es.uniovi.asw;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uniovi.asw.model.Vote;
import es.uniovi.asw.model.Voting;
import es.uniovi.asw.persistence.VoteRepository;
import es.uniovi.asw.persistence.VotingRepository;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Application.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);
  }
  
  
  private Voting vot1 = new Voting("Voting 1"); 
  private Voting vot2 = new Voting("Voting 2"); 
  
  @Bean
	public CommandLineRunner voting(VotingRepository repository) {
		return (args) -> {
			// save a couple of votings
			repository.save(vot1);
			repository.save(vot2);	
			repository.save(new Voting("Voting 3"));
		};
	}
  
  @Bean
	public CommandLineRunner votes(VoteRepository repository) {
		return (args) -> {
			// save a couple of votings
			repository.save(new Vote(vot1, "Si"));
			repository.save(new Vote(vot1, "No"));
			repository.save(new Vote(vot1, "No"));
			repository.save(new Vote(vot2, "Si"));
			repository.save(new Vote(vot2, "Si"));
			repository.save(new Vote(vot2, "No"));

		};
	}
}