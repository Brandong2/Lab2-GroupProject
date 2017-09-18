package pkgCore;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandTest {

	public int[] HandHelper(ArrayList<Card> cards) {

		int[] result = null;

		try {
			
			//	c = structure of class 'Hand'
			Class<?> c = Class.forName("pkgCore.Hand");

			//	the arguments for 'AddCard' is a instance of Card
			Class[] cArgsAddCard = new Class[1];
			cArgsAddCard[0] = pkgCore.Card.class;

			//	Create an instance of Hand
			Object inst = c.newInstance();

			//	Find the method 'AddCard' in Hand
			Method mAddCard = c.getDeclaredMethod("AddCard", cArgsAddCard);
			
			//	Make the private method accessible 
			mAddCard.setAccessible(true);
			
			//	Invoke the AddCard method for each card passed into this method
			for (Card card: cards)
			{
				mAddCard.invoke(inst, card);
			}
			
			//	Find the method 'ScoreHand' in 'Hand'
			Method mScore = c.getDeclaredMethod("ScoreHand", null);
			
			//	Invoke 'ScoreHand'.  It returns an array of integers
			result = (int[]) mScore.invoke(inst, null);

			//	easy way to see each score.  not necessary.. but helps
			for (int i : result) {
				System.out.println(i);
			}

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Test
	public void test1() {
		
		// TOD: Test 2-3-4, score should be 9

		ArrayList<Card> cards = new ArrayList<Card>();
		
		// TOD:  REMOVE THE COMMENTS FROM THE NEXT THREE LINES
		
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		cards.add(new Card(eSuit.CLUBS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.FOUR));
		
		int[] score = HandHelper(cards);
		
		//	TOD: Check Score to make sure it's right.  Something close to this:
		assertEquals(score[0],9);		
	}

	@Test
	public void test2() {
		// TOD: Test 2-3-J, score should be 15
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.HEARTS,eRank.TWO));
		cards.add(new Card(eSuit.HEARTS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],15);
	}

	@Test
	public void test3() {
		// TOD: Test 2-3-J-J, score should be 25
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.HEARTS,eRank.TWO));
		cards.add(new Card(eSuit.HEARTS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.HEARTS,eRank.JACK)); 
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],25);
	}

	@Test
	public void test4() {
		// TOD: Test J-A, score should be 21
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.HEARTS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],21);
	}

	@Test
	public void test5() {
		// TODO: Test J-A-A, score should be 12
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.HEARTS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.HEARTS,eRank.ACE)); 
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],12);
	}

	@Test
	public void test6() {
		// TOD: Test J-A-A-A, score should be 13
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.HEARTS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.HEARTS,eRank.ACE)); 
		cards.add(new Card(eSuit.SPADES,eRank.ACE));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],13);
	}
	
	@Test
	public void test7() {
		//	TOD: Test A-A-A-A-2, score should be 6 or 16
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.HEARTS,eRank.ACE)); 
		cards.add(new Card(eSuit.DIAMONDS,eRank.ACE)); 
		cards.add(new Card(eSuit.SPADES,eRank.ACE)); 
		cards.add(new Card(eSuit.SPADES,eRank.TWO));
		
		int[] score = HandHelper(cards);
		assertEquals(score[0],16);
		assertEquals(score[1],6);
	}

}
