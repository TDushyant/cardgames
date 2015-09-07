package com.learnon.games.card.dhaglabaazi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Card> mDeck;
	public List<Card> player1Deck;
	public List<Card> player2Deck;

	public void setPlayer1Deck(List<Card> player1Deck) {
		this.player1Deck = player1Deck;
	}

	public void setPlayer2Deck(List<Card> player2Deck) {
		this.player2Deck = player2Deck;
	}

	public List<Card> getPlayer2Deck() {
		return player2Deck;
	}

	public List<Card> getPlayer1Deck() {
		return player1Deck;
	}

	public Deck(){
		mDeck = new ArrayList<Card>(); // Card[52];
		int d = 0;
		
		for(int p=3;p>=0;p--)
        {
            for(int i=0; i<=12; i++, d++)
            {
            	mDeck.add(new Card(p, i));
            }
        }
	}
	

	public void dealAllCards() {
		Collections.shuffle(mDeck);
		setPlayer1Deck(mDeck.subList(0,26));
		setPlayer2Deck(mDeck.subList(26,mDeck.size()));
	}
	

}
