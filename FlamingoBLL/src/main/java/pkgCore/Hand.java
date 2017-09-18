package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	private int iScore;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand(){
	
	}
	
	public int[] ScoreHand()
	{
		int [] iScore = new int[2];
		
		iScore[0] = 0; //Change back to 5 if needed?
		iScore[1] = 0; //Change back to 10 if needed?
		
		Collections.sort(cards);
		
		int oneCardRank;
		
		for (Card c: cards)
		{
			oneCardRank = c.geteRank().getiRankNbr();
			
			switch(oneCardRank) {
			case 14: case 1:
				iScore[0] += 11;
				iScore[1] += 1;
				break;
			case 11: case 12: case 13:
				oneCardRank = 10;
			default:
				iScore[0] += oneCardRank;
				iScore[1] += oneCardRank;
			}
			
			if (iScore[0] != iScore[1]) {
				if(iScore[0] > 21) {
					iScore[0] -= 10;
				}
			}
				
			
			//	TODO: Determine the score.  
			//			Cards:
			//			2-3-4 - score = 11
			//			5-J-Q - score = 25
			//			5-6-7-2 - score = 20
			//			J-Q	- score = 20
			//			8-A = score = 9 or 19
			//			4-A = score = 5 or 15
		}
		
		return iScore;
	}
	
	public void Draw(Deck d)
	{
		this.AddCard(d.draw());
		
	}
	
	private void AddCard(Card c)
	{
		cards.add(c);
	}
	
}
