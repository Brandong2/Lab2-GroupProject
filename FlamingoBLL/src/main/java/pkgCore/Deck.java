package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.*;

public class Deck {
	private ArrayList<Card> deckOfCards;
	
	public Deck(int number) {
		deckOfCards = new ArrayList<Card>(); 
		for(int i = 0; i < number ; i++) {
			for (eSuit S : eSuit.values()) {
				 for (eRank R : eRank.values()) {
					 if(R != eRank.ONE) {
						 deckOfCards.add(new Card(S,R));
					 }
				 }
			}
		}
		
		Collections.shuffle(deckOfCards);
	}
	
	public int size() {
		return deckOfCards.size();
	}
	
	public Card draw() {
		return deckOfCards.remove(0);
	}
}
