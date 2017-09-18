package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	@Test
	public void TestDeck() {
		
		Deck d1 = new Deck(1);
		assertEquals(d1.size(),52);
		
		Deck d2 = new Deck(6);
		assertEquals(d2.size(),52*6);
		
		
	}

}
