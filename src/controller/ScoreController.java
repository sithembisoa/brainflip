package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import classes.Score;

public class ScoreController {

	Score[] scores = new Score[5];
	public ScoreController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Score[] getHighScores() {
		String position = "", score = "";
		String  uname="";
		String filePath = "config/scores.txt";
		
		try {
			Scanner scanner = new Scanner(new File(filePath));
			scanner.useDelimiter("[,\n]");
			int counter = 0;
			while(scanner.hasNext()) {
				position = scanner.next();
				uname = scanner.next();				
				score = scanner.next();
				Score score2 = new Score(Integer.parseInt(position.trim()),uname,Integer.parseInt(score.trim()));
				scores[counter] = score2;		
				counter++;
			}
			scanner.close();
		}catch(IOException e) {
			System.out.print(e.getMessage());
		}
		
		return scores;
		
	}
	
	public void setNewHighScore() {
		
	}
}
