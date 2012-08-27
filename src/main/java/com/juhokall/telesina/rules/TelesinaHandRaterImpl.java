/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.rules;

import com.juhokall.telesina.io.TelesinaHumanizer;
import com.juhokall.telesina.io.TextualHumanizer;
import com.juhokall.telesina.model.core.Telesina;
import com.juhokall.telesina.model.TelesinaHand;

/**
 *
 * @author juho
 */
public class TelesinaHandRaterImpl implements TelesinaHandRater {

	@Override
	public int getTelesinaHandValue(TelesinaHand telesinaHand) {
		if(telesinaHand.getNumberOfCardsDealt() == 1) {
			return getHighcardValue(telesinaHand.getCard(0));
		}
		int[] hand = new int[telesinaHand.getNumberOfCardsDealt()];
		for(int i = 0; i < telesinaHand.getNumberOfCardsDealt(); i++) {
			hand[i] = telesinaHand.getCards()[i];
		}
		return getTelesinaHandValue(hand);
	}

	@Override
	public int getTelesinaHandValue(int[] hand) {
		int value = 0;
		int[] pairHits = new int[Telesina.RANK_COUNT];
		int[] suitHits = new int[Telesina.SUIT_COUNT];
		for(int card : hand) {
			pairHits[getRank(card)]++;
			suitHits[getSuit(card)]++;
		}
		value = getPairHandValue(pairHits, hand);
		
		int flushHandValue = getFlushValue(suitHits);
		if(flushHandValue > value) {
			value = flushHandValue;
		}
		if(value < Telesina.FLUSH_VALUE) {
			int straightHandValue = getStraightValue(pairHits, hand); 
			if(straightHandValue > value) {
				value = straightHandValue;
			}
		}
		return value;
	}
	

	@Override
	public int getHighcardValue(int card) {
		int suit = getSuit(card);
		int rank = getRank(card);
		int firstOne = suit;
		int value = firstOne + rank * (Telesina.SUIT_COUNT);
		return value;
	}

//	@Override
//	public int getPairhandValue(int[] hand) {
//		int[] pairHits = new int[Telesina.RANK_COUNT];
//		int[] suitHits = new int[Telesina.SUIT_COUNT];
//		int value = 0;
//		for (int card : hand) {
//			int rank = getRank(card);
//			int suit = getSuit(card);
//			pairHits[rank]++;
//			if (pairHits[rank] == 2) {
//				value = getPairValue(rank, value);
//			} else if (pairHits[rank] == 3) {
//				value = getSetValue(rank, value);
//			} else if (pairHits[rank] == 4) {
//				value = getSquadsValue(rank);
//			}
//			suitHits[suit]++;
//		}
//
//		return value;
//	}
	private int getPairHandValue(int[] pairHits, int[] hand) {
		int value = 0;
		for (int rank = 0; rank < Telesina.RANK_COUNT; rank++) {
			if (pairHits[rank] == 2) {
				value = getPairValue(rank, value);
				value += getKickerValue(hand, pairHits);
			} else if (pairHits[rank] == 3) {
				value = getSetValue(rank, value);
			} else if (pairHits[rank] == 4) {
				value = getSquadsValue(rank);
			}
		}
		return value;
	}



	private int getPairValue(int rank, int originalValue) {
		int value = 0;
		if (originalValue == 0) {
			value = Telesina.PAIR_VALUE + rank;
		} else if (originalValue < Telesina.PAIR_VALUE + Telesina.RANK_COUNT) {
			int otherPairRank = originalValue - Telesina.PAIR_VALUE;
			value = Telesina.TWO_PAIR_VALUE;
			if (rank > otherPairRank) {
				value += Telesina.RANK_COUNT * rank + otherPairRank;
			} else {
				value += Telesina.RANK_COUNT * otherPairRank + rank;
			}
		} else {
			int originalTwoPairValue = originalValue - Telesina.TWO_PAIR_VALUE;
			int originalWeakerPair = originalTwoPairValue % Telesina.RANK_COUNT;
			int originalStrongerPair = originalTwoPairValue / Telesina.RANK_COUNT;
			if (rank > originalWeakerPair) {
				if (rank < originalStrongerPair) {
					value = Telesina.TWO_PAIR_VALUE + originalStrongerPair * Telesina.RANK_COUNT + rank;
				} else {
					value = Telesina.TWO_PAIR_VALUE + rank * Telesina.RANK_COUNT + originalStrongerPair;
				}
			}
		}
		return value;
	}

	private int getSetValue(int rank, int originalValue) {
		int value = 0;

		return value;
	}

	private int getSquadsValue(int rank) {
		int value = 0;
		return value;
	}

	private int getStraightValue(int[] rankHits, int[] hand) {
		int straightValue = 0;
		int straightCount = 0;
		for (int rank = 0; rank < Telesina.RANK_COUNT; rank++) {
			if (rankHits[rank] != 0) {
				straightCount++;
				if (straightCount >= Telesina.RATEABLE_HAND_LENGTH) {
					straightValue = Telesina.STRAIGHT_VALUE + getKickerValue(rank, hand);
				}
			} else {
				straightCount = 0;
			}
		}
		return straightValue;
	}

	private int getFlushValue(int[] suitHits) {
		int flushValue = 0;
		for (int suit = 0; suit < Telesina.SUIT_COUNT; suit++) {
			if (suitHits[suit] >= Telesina.RATEABLE_HAND_LENGTH) {
				flushValue = Telesina.FLUSH_VALUE + suit;
			}
		}
		return flushValue;
	}

	private int getSuit(int card) {
		return card / Telesina.RANK_COUNT;
	}

	private int getRank(int card) {
		return card % Telesina.RANK_COUNT;
	}

	private int getKickerValue(int[] hand, int[] rankHits) {
		int value = 0;
		for(int rank = Telesina.RANK_COUNT - 1; rank >= 0; rank--) {
					if(rankHits[rank] == 1) {
						value = getKickerValue(rank, hand);
						break;
					}
				}
		return value;
	}
	private int getKickerValue(int rank, int[] hand) {
		return rank * Telesina.SUIT_COUNT + getHighestSuitOfRank(hand, rank);
	}

	private int getHighestSuitOfRank(int[] hand, int rank) {
		int highestSuit = 0;
		int suit;
		for (int card : hand) {
			if (getRank(card) == rank) {
				suit = getSuit(card);
				if (suit > highestSuit) {
					highestSuit = suit;
				}
			}
		}
		return highestSuit;
	}
}
