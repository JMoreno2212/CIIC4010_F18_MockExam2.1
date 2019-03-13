import static org.junit.Assert.*;

import org.junit.Test;

public class CardTester {

	Card cardAD = new Card("Diamond", 1);
	Card card2D = new Card("Diamond", 2);
	Card cardAS = new Card("Spade", 1);
	Card card2S = new Card("Spade", 2);
	Card cardKS = new Card("Spade", 13);
	Card card2C = new Card("Club", 2);
	Card card2H = new Card("Heart", 2);
	Card card3C = new Card("Club", 3);
	Card card4H = new Card("Heart", 4);
	Card cardAH = new Card("Heart", 1);
	Card card10S = new Card("Spade", 10);
	Card cardJS = new Card("Spade", 11);
	Card cardQS = new Card("Spade", 12);

	Card[] hand1 = {cardAD, cardAS, card2D, card2S, card3C};
	Card[] hand2 = {cardKS, card3C, card4H};
	Card[] hand3 = {cardAH, cardAD, cardAS}; 
	Card[] hand4 = {cardAH, card4H, card2S};
	Card[] pair1 = {card4H, card2S, card10S, cardAD, card2H};
	Card[] flush = {card10S, card2S, cardAS, cardKS};
	Card[] straight = {cardAD, card2S, card3C, card4H};
	Card[] straightFlush = {card10S, cardJS, cardQS, cardKS};
	Card[] empty = {};

	@Test
	public void testConstructors() {
		Card card4D = new Card("Diamond", 4);
		assertEquals("Constructor is not saving the suit correctly.", card4D.getSuit(), "Diamond");
		assertEquals("Constructor is not saving the rank correctly.", card4D.getRank(), 4);
		Card cardQH = new Card("Heart", 12);
		assertEquals("Constructor is not saving the suit correctly.", cardQH.getSuit(), "Heart");
		assertEquals("Constructor is not saving the rank correctly.", cardQH.getRank(), 12);
		Card card4DCopy = new Card(card4D);
		assertEquals("Constructor is not saving the suit correctly.", card4DCopy.getSuit(), "Diamond");
		assertEquals("Constructor is not saving the rank correctly.", card4DCopy.getRank(), 4);
		Card cardQHCopy = new Card(cardQH);
		assertEquals("Constructor is not saving the suit correctly.", cardQHCopy.getSuit(), "Heart");
		assertEquals("Constructor is not saving the rank correctly.", cardQHCopy.getRank(), 12);
	}

//	@Test
//	public void testGetterSetter() {
//		Card testCard = new Card("Club", 3);
//		assertEquals("The Getter is not correctly returning the suit.", testCard.getSuit(), "Club");
//		assertEquals("The Getter is not correctly returning the rank.", testCard.getRank(), 3);
//		testCard.setRank(10);
//		testCard.setSuit("Spade");
//		assertEquals("The Setter is not correctly modifying the suit.", testCard.getSuit(), "Spade");
//		assertEquals("The Setter is not correctly modifying the rank.", testCard.getRank(), 10);
//	}

//	@Test
//	public void testToString() {
//		assertTrue("Card.toString: generates incorrect String", cardAD.toString().equals("[1,Diamond]"));
//		assertTrue("Card.toString: generates incorrect String", card2S.toString().equals("[2,Spade]"));
//	}

//	@Test
//	public void testEquals() {
//		assertTrue("Card.equals: Yields false incorrectly", cardAD.equals(cardAD));
//		assertFalse("Card.equals: Yields true incorrectly", cardAD.equals(card2D));
//	}

//	@Test
//	public void testSameSuitRank() {
//		assertTrue("Card.sameRankAs: Yields false incorrectly", cardAD.sameRankAs(cardAS));
//		assertTrue("Card.sameSuitAs: Yields false incorrectly", cardAD.sameSuitAs(card2D));
//		assertFalse("Card.sameRankAs: Yields true incorrectly", cardAS.sameRankAs(card2S));
//		assertFalse("Card.sameSuitAs: Yields true incorrectly", card2S.sameSuitAs(cardAD));
//	}

	@Test
	public void testIsAnA() {
		assertTrue("isAnA(): Yields false incorrectly", cardAS.isAnA());
		assertFalse("isAnA(): Yields true incorrectly", cardKS.isAnA());
	}

	@Test
	public void testIsPair() {
		assertTrue("isPair:  Yields false incorrectly", card2C.isPair(card2C));
		assertTrue("isPair:  Yields false incorrectly", card2C.isPair(card2S));
		assertFalse("isPair:  Yields true incorrectly", card2C.isPair(card3C));
		assertFalse("isPair:  Yields true incorrectly", card2C.isPair(card3C));
	}

	@Test
	public void testIsTrio() {
		assertTrue("isTrio:  Yields false incorrectly", card2C.isTrio(card2C, card2C));
		assertTrue("isTrio:  Yields false incorrectly", card2C.isTrio(card2S, card2D));
		assertFalse("isTrio:  Yields true incorrectly", card2C.isTrio(card2S, card3C));
		assertFalse("isTrio:  Yields true incorrectly", card2C.isTrio(card3C, card2S));
		assertFalse("isTrio:  Yields true incorrectly", card3C.isTrio(card2C, card2S));
	}

	@Test
	public void testIsFourTuple() {
		assertTrue("isFourTuple:  Yields false incorrectly", card2C.isFourTuple(card2C, card2C, card2C));
		assertFalse("isFourTuple:  Yields true incorrectly", card3C.isFourTuple(card2C, card2C, card2C));
		assertFalse("isFourTuple:  Yields true incorrectly", card2C.isFourTuple(card3C, card2C, card2C));
		assertFalse("isFourTuple:  Yields true incorrectly", card2C.isFourTuple(card2C, card3C, card2C));
		assertFalse("isFourTuple:  Yields true incorrectly", card2C.isFourTuple(card2C, card2C, card3C));
	}

//	@Test
//	public void testIsConsecutive() {
//		assertTrue("isConsecutive(): The object card has a rank of 2 while the target one is 3, it should be true.", card2H.isConsecutive(card3C));
//		assertFalse("isConsecutive(): The object card has a rank of 3 while the target one is 2, it should be false.", card3C.isConsecutive(card2H));
//		assertFalse("isConsecutive(): The object card has a rank of 1 while the target one is 13, it should be false.", cardAD.isConsecutive(cardKS));
//		assertFalse("isConsecutive(): The object card has a rank of 13 while the target one is 1, it should be false.", cardKS.isConsecutive(cardAD));
//	}

	@Test
	public void testCardExists() {
		assertTrue("cardExists(): The card 2D exists on this deck.", card2D.cardExistsIn(hand1));
		assertFalse("cardExists(): The card AH doesnt exists on this deck.", cardAH.cardExistsIn(hand1));
		assertFalse("cardExists(): The card KS doesnt exists on this deck.", cardKS.cardExistsIn(hand1));
		assertFalse("cardExists(): The card 2D doesnt exists on this deck.", card2D.cardExistsIn(empty));
	}

	@Test
	public void testPairExists() {
		assertTrue("pairExists(): This deck contains a pair.", card2D.pairExists(hand1));
		assertTrue("pairExists(): This deck contains a pair.", card2D.pairExists(pair1));
		assertFalse("pairExists(): This deck does not contains a pair.", card2D.pairExists(flush));
		assertFalse("pairExists(): This deck does not contains a pair.", card2D.pairExists(empty));
	}

	@Test
	public void testIsFlush() {
		assertTrue("isFlush(): The deck is a valid flush.", card2D.isFlush(flush));
		assertFalse("isFlush(): The deck is not a valid flush.", card2D.isFlush(hand1));
		assertFalse("isFlush(): The deck is not a valid flush.", card2D.isFlush(hand4));
		assertTrue("isFlush(): The deck is a valid flush.", card2D.isFlush(straightFlush));
		assertTrue("isFlush(): The deck is a valid flush.", card2D.isFlush(empty));
	}

	@Test
	public void testIsStraight() {
		assertTrue("isStraight(): The deck is a valid consecutive straight.", card2D.isConsecutiveStraight(straight));
		assertTrue("isStraight(): The deck is a valid consecutive straight.", card2D.isConsecutiveStraight(straightFlush));
		assertFalse("isStraight(): The deck is not a valid consecutive straight.", card2D.isConsecutiveStraight(flush));
		assertFalse("isStraight(): The deck is not a valid consecutive straight.", card2D.isConsecutiveStraight(hand1));
		assertTrue("isStraight(): The deck is a valid consecutive straight.", card2D.isConsecutiveStraight(empty));
	}

	@Test
	public void testIsStraightFlush() {
		assertFalse("isStraightFlush(): The deck is not a valid consecutive straight flush.", card2D.isConsecutiveStraightFlush(straight));
		assertTrue("isStraightFlush(): The deck is a valid consecutive straight flush.", card2D.isConsecutiveStraightFlush(straightFlush));
		assertFalse("isStraightFlush(): The deck is not a valid consecutive straight flush.", card2D.isConsecutiveStraightFlush(flush));
		assertFalse("isStraightFlush(): The deck is not a valid consecutive straight flush.", card2D.isConsecutiveStraightFlush(hand1));
		assertTrue("isStraightFlush(): The deck is a valid consecutive straight flush.", card2D.isConsecutiveStraightFlush(empty));
	}

}