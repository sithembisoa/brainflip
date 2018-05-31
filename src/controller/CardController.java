package controller;

import javax.swing.Timer;

import classes.Card;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CardController implements ActionListener{
	private Vector<Card> turnedCard;
	private Timer turnDownTimer;
	private final int turnDownDelay = 1000;
	private int score = 0;
	
	public CardController() {
		this.turnedCard = new Vector<Card>(2);
		this.turnDownTimer = new Timer(this.turnDownDelay, this);
		this.turnDownTimer.setRepeats(false);
	}
	
	public boolean turnUp(Card card) {
		if(this.turnedCard.size() < 2) return doAddCard(card);
		return false;
	}

	private boolean doAddCard(Card card) {
		// TODO Auto-generated method stub
		this.turnedCard.add(card);
		if(this.turnedCard.size() == 2) {
			Card otherCard = (Card)this.turnedCard.get(0);
			if(otherCard.getNum() == card.getNum()) {
				this.turnedCard.clear();
				score++;			}
			else this.turnDownTimer.start();
		}
		return true;
	}
	
	public int getScore() {
		return this.score;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for(int i=0; i < this.turnedCard.size(); i++) {
			Card card = (Card)this.turnedCard.get(i);
			card.turnDown();
		}
		this.turnedCard.clear();
	}

}
