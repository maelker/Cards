package cards.possession.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cards.possession.model.PossessionIdentity;


@Service
public class PossessionService{


	@Autowired
	private PossessionRepository PossessionRepository;
	
	public String byidcard(int idcard) {
		String retour = null;
		
		try {
			// Création de l'url en fonction de l'id passé en paramètre.
			String path = "http://localhost:8080/cards/"+idcard;
			URL url = new URL(path);
			
			// Ouverture de la connection au microservice qui gère les cartes.
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			// Gestion du contenu de la réponse de la requète.
			con.setRequestProperty("Content-Type", "application/json");
			
			// Gestion d'un temps de réponse au-delà duquel on coupe la connection.
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			
			// Réception de la réponse dans un StringBuffer.
			BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			
			// Conversion de la réponse en string pour le retour.
			retour = content.toString();
			
			// Fermeture et deconnexion de la requète.
			in.close();
			con.disconnect();
			
		} catch (IOException e) {
			System.out.print("error connect MSCard");
		}
		
		return retour;
	}
	
	public String byiduser(int iduser) {
		
		StringBuilder retour = new StringBuilder();
		retour.append("[");
		List<Integer> tabidcard = PossessionRepository.findCards(iduser);
		ListIterator<Integer> iterator = tabidcard.listIterator();
		
		for (int i = 0; i < tabidcard.size(); i++) {
			List<Integer> price = PossessionRepository.findPrice(iduser,tabidcard.get(i));
			String infoCard = byidcard(tabidcard.get(i));
			
			retour.append("[");
			retour.append(infoCard);
			retour.append(", ");
			retour.append(price.toString());
			retour.append("]");
			
			if(iterator.hasNext())
				retour.append(", ");
			
			iterator.next();
		}
		
		retour.append("]");
		return retour.toString();
	}
	
	public String onMarket(int iduser) {

		StringBuilder retour = new StringBuilder();
		retour.append("[");
		
		List<PossessionIdentity> idCardUser = PossessionRepository.findonmarket(iduser);
		//  => [ [idcard1, iduser1] , [idcard2, iduser2] , ... ]
		ListIterator<PossessionIdentity> iterator = idCardUser.listIterator();
		
		for ( int i = 0; i < idCardUser.size(); i++) {
			String infoCard = byidcard(idCardUser.get(i).getidcard());
			
			retour.append("[");
			retour.append(infoCard);
			retour.append(", ");
			retour.append(idCardUser.get(i).getidcard().toString());
			retour.append(", ");
			retour.append(PossessionRepository.findPrice(idCardUser.get(i).getiduser(),
														 idCardUser.get(i).getidcard()
														 ).toString() );
			retour.append("]");
			
			if(iterator.hasNext())
				retour.append(", ");
			
			iterator.next();
		}
		
		// Make array [ [allInfoCard1,iduser1,price1], [allInfoCard2,iduser2,price2], ...]
		
		
		return retour.toString();
	}
	
	public void setPrice(int iduser, int idcard, int price) {
		
		PossessionRepository.setPrice(iduser, idcard, price);
		
	}
	
	public void buyCard(int iduser, int idusercard, int idcard, int price) {
		String retourSolde = null;
		
		try {
			// Création de l'url en fonction de l'id passé en paramètre.
			String path = "http://localhost:8080/user/"+iduser;
			URL url = new URL(path);
			
			// Ouverture de la connection au microservice qui gère les cartes.
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			// Gestion du contenu de la réponse de la requète.
			con.setRequestProperty("Content-Type", "application/json");
			
			// Gestion d'un temps de réponse au-delà duquel on coupe la connection.
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			
			// Réception de la réponse dans un StringBuffer.
			BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			
			// Conversion de la réponse en string pour le retour.
			retourSolde = content.toString();
			
			// Fermeture et deconnexion de la requète.
			in.close();
			con.disconnect();
			
		} catch (IOException e) {
			System.out.print("error connect MSUser");
		}
		int solde_buyer = Integer.parseInt(retourSolde);
		if(solde_buyer > price) {
			
			String retourTransaction = null;
			
			try {
				// Création de l'url en fonction de l'id passé en paramètre.
				String path = "http://localhost:8080/user/"+iduser+"+"+idusercard+"+"+price;
				URL url = new URL(path);
				
				// Ouverture de la connection au microservice qui gère les cartes.
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				
				// Gestion du contenu de la réponse de la requète.
				con.setRequestProperty("Content-Type", "application/json");
				
				// Gestion d'un temps de réponse au-delà duquel on coupe la connection.
				con.setConnectTimeout(5000);
				con.setReadTimeout(5000);
				
				// Réception de la réponse dans un StringBuffer.
				BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				
				// Conversion de la réponse en string pour le retour.
				retourTransaction = content.toString();
				
				// Fermeture et deconnexion de la requète.
				in.close();
				con.disconnect();
				
				boolean resultTransaction = Boolean.parseBoolean(retourTransaction);
				
				if (resultTransaction) {
					PossessionRepository.changeUserOfCard(idcard, idusercard, iduser);
				} else {
					System.out.print("Transaction error");
				}
			} catch (IOException e) {
				System.out.print("error connect MSUser");
			}
		} else {
			System.out.print("buyer doesn't have enough money");
		}
	}
	
}
