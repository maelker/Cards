package cards.Interface.controller;



import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

//controller gérant la methode REST des url

@RestController
public class InterfaceController {
	
static  String URL_CardBuy = "http://localhost:8080/cardBuy.html";
static  String URL_CARD = "http://localhost:8080/";
static  String URL_USER = "http://localhost:8080/users";
static  String URL_ROOM = "http://localhost:8080/room";

@RequestMapping(value = "/cardbuy", method = RequestMethod.GET)
public String getCardBuy() {
   RestTemplate restTemplate = new RestTemplate();
  String result = restTemplate.getForObject(URL_CardBuy, String.class);
        return result;

}

@RequestMapping(value = "/cardsell", method = RequestMethod.GET)
public String getCards() {
   RestTemplate restTemplate = new RestTemplate();
  String result = restTemplate.getForObject(URL_CARD+"cardList.html", String.class);
        return result;

}

@RequestMapping(value = "/user", method = RequestMethod.GET)
public String getUser() {
   RestTemplate restTemplate = new RestTemplate();
  String result = restTemplate.getForObject(URL_USER, String.class);
        return result;

}

@RequestMapping(value = "/room", method = RequestMethod.GET)
public String getRoom() {
   RestTemplate restTemplate = new RestTemplate();
  String result = restTemplate.getForObject(URL_USER, String.class);
        return result;

}

//onn envoie le mot de passe 
@RequestMapping(value = "/getConnexion", method = RequestMethod.GET)
public String getConnexion() {
	
    String USER_NAME = "tom";  //il faut recuperer les champs pourt la connexion
     String PASSWORD = "123";
	// HttpHeaders
    HttpHeaders headers = new HttpHeaders();

    // 
    // Authentication
    // 
    String auth = USER_NAME + ":" + PASSWORD;
   // byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
    String authHeader = "Basic " + new String(auth);
    headers.set("Authorization", authHeader);
    // 
    headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
    // Request to return JSON format
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("my_other_key", "my_other_value");

    // HttpEntity<String>: To get result as String.
    HttpEntity<String> entity = new HttpEntity<String>(headers);

    // RestTemplate
    RestTemplate restTemplate = new RestTemplate();

    // Send request with GET method, and Headers.
    ResponseEntity<String> response = restTemplate.exchange(URL_USER, HttpMethod.GET, entity, String.class);
    
    String result = response.getBody();
    		return result;

}


	@RequestMapping("/Home")
	private RedirectView Home(Model model) {
		return new RedirectView("cardHome.html");	
		}
	    
	//redirection d'url
	  @RequestMapping(value = "/cardBuy", method = RequestMethod.GET)
	    public ModelAndView method() {
		 String projectUrl="http://localhost:8081/cardBuy.html";
	            return new ModelAndView( "redirect:"+projectUrl);

	    }
	  
	 
	
	 
}
