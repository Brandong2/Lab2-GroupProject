package pkgCore;

import pkgEnum.*;

public class Card implements Comparable {

	private eRank eRank;
	private eSuit eSuit;
	
	public Card(eSuit Suit, eRank Rank) {
		eRank = Rank;
		eSuit = Suit;
	}
	
	public eRank geteRank() {
		return eRank;
	}
	
	public eSuit geteSuit() {
		return eSuit;
	}
	
	private void seteRank(eRank Rank) {
		eRank = Rank;
	}
	
	private void seteSuit(eSuit Suit) {
		eSuit = Suit;
	}
	
	@Override
	public int compareTo(Object o) {
		Card c = (Card) o;
		return c.geteRank().compareTo(this.geteRank());
	}
}
