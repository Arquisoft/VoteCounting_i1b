package es.uniovi.asw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Main {

  private static final Logger LOG = LoggerFactory.getLogger(Main.class);

  @RequestMapping("/")
  public String landing(Model model) {
    LOG.info("Landing page access");
    RestTemplate rt = new RestTemplate();
    String response = rt.getForObject("http://localhost:8080/voting?id={id}", String.class,"1");
    model.addAttribute("response",response);
    return "landing";
  }
  
}