package cards.card.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import cards.card.model.Card;

/**
 *  pour que le test fonctionne il faut enlever le autowired pour family service ligne24 de card rest controller
 * @author thibault
 * Test unitaire pour la methode get pour avoir une carte
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = CardsRestController.class, secure = false)
public class CardsRestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CardsService cardsService;
	
	Card mockCard=new Card("test", "je teste", "Marvel", 5, 6, 7, 9, "url", 10);


@Test
public void retrieveDetailsForcards() throws Exception {

Mockito.when(cardsService.getCardbyid(Mockito.anyInt())).thenReturn(mockCard);

RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/card/1").accept(MediaType.APPLICATION_JSON);

MvcResult result = mockMvc.perform(requestBuilder).andReturn();

System.out.println(result.getResponse());

String expected = "{\"id\":null,\"name\":\"test\",\"description\":\"je teste\",\"family\":\"Marvel\",\"hp\":5,\"attack\":6, \"defence\":7,\"energy\":9,\"imgUrl\":\"url\", \"price\":10}";


JSONAssert.assertEquals(expected, result.getResponse()
		.getContentAsString(), false);
}




/**
 * Test unitaire de la méthode post pour ajouter une carte
 * @throws Exception
 */
@Test
public void createCard() throws Exception {
	Card mockCard = new Card("test", "je teste", "Marvel", 5, 6, 7, 9, "url", 10);
	String examplecardjson  = "{\"id\":10,\"name\":\"test\",\"description\":\"je teste\",\"family\":\"Marvel\",\"hp\":5,\"attack\":6, \"defence\":7,\"energy\":9,\"imgUrl\":\"url\", \"price\":10}";

	// CardsService.addCard to respond back with mockCourse
	Mockito.when(cardsService.addCard(Mockito.any(Card.class))).thenReturn(mockCard);

	// Send card as body to /cards
	RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post("/cards")
			.accept(MediaType.APPLICATION_JSON).content(examplecardjson)
			.contentType(MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	MockHttpServletResponse response = result.getResponse();
	assertEquals(HttpStatus.CREATED.value(), response.getStatus());

	assertEquals("http://localhost/cards/10",
			response.getHeader(HttpHeaders.LOCATION));

}







}
