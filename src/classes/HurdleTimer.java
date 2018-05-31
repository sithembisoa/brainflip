package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import views.BrainflipGame;

public class HurdleTimer {
	   private static final int TIMER_PERIOD = 1000;
	   protected static final int MAX_COUNT = 30;
	   private BrainflipGame brainflipGame; // holds a reference to the Welcome class
	   private int count;

	   public HurdleTimer(BrainflipGame brainflipGame) {
	      this.brainflipGame = brainflipGame; // initializes the reference to the Welcome class.
	      String text = "Time: " + (MAX_COUNT - count) +" ";
	      brainflipGame.setCountDownLabelText(text);
	   }

	   public void start() {
	      new Timer(TIMER_PERIOD, new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            if (count < MAX_COUNT) {
	               count++;
	               String text = "Time: " + (MAX_COUNT - count)+" ";
	               brainflipGame.setCountDownLabelText(text); // uses the reference to Welcome
	            } else {
	               ((Timer) e.getSource()).stop();
	               brainflipGame.gameOver();
	            }
	         }
	      }).start();
	   }

	}
