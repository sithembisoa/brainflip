package views;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import classes.Card;
import classes.HurdleTimer;
import classes.Score;
import controller.CardController;
import controller.ScoreController;

public class BrainflipGame implements ActionListener{
	private JFrame mainFrame;
	private Container mainContentFrame;
	private ImageIcon cardIcon[];
	private JLabel labelTimer; 
	private CardController controller;
	
	public BrainflipGame(String username) {
		this.mainFrame= new JFrame("Brainflip Game");
		
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(400,500);
		this.mainContentFrame=this.mainFrame.getContentPane();
		this.mainContentFrame.setLayout(new BoxLayout(this.mainContentFrame, BoxLayout.PAGE_AXIS));
		
		JMenuBar menuBar = new JMenuBar();
		this.mainFrame.setJMenuBar(menuBar);
		
		JMenu gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);
		
		/*JMenu highMenu = new JMenu("HighScores");
		menuBar.add(highMenu);*/
		
		JMenu aboutMenu = new JMenu("About");
		menuBar.add(aboutMenu);
		newMenuItem("About",aboutMenu,this);
		
			
		JMenuItem newItem = new JMenuItem("HighScores");
		newItem.setActionCommand("HighScores");
		newItem.addActionListener(this);
		menuBar.add(newItem);
		
		newMenuItem("New Game",gameMenu,this);
		newMenuItem("Exit",gameMenu,this);	
		
		
		menuBar.add(Box.createHorizontalGlue());
		labelTimer = new JLabel("Time: ", SwingConstants.CENTER);
		menuBar.add(labelTimer);
		JMenu userName = new JMenu("Player: "+username.toUpperCase());
		menuBar.add(userName);
		
		this.cardIcon = loadCardIcons();
		
	}
	
	public void setCountDownLabelText(String text) {
		labelTimer.setText(text);
	}
	
	private ImageIcon[] loadCardIcons() {
		// TODO Auto-generated method stub
		ImageIcon icon[] = new ImageIcon[9];
		for(int i=0; i < 9; i++) {
			String fileName = "images/card"+i+".jpg";
			ImageIcon face = new ImageIcon(fileName);
			Image image = face.getImage(); // transform it 
			Image newimg = image.getScaledInstance(80, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			face = new ImageIcon(newimg);
			icon[i] = face;
		}
		return icon;
	}

	public JPanel makeCards() {
		JPanel panel = new JPanel (new GridLayout(4,4));
		ImageIcon backIcon = this.cardIcon[8];
		Image image = backIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(80, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		backIcon = new ImageIcon(newimg);
		
		controller = new CardController();
	
		int cardsToAdd[] = new int[16]; // 4x4 grid requires 16 cards
		for(int i=0; i < 8; i++) {
			cardsToAdd[2*i] = i;
			cardsToAdd[2*i+1] = i;
		}
		//randomize
		randomizeCardArray(cardsToAdd);
		//make card object
		for(int i=0; i < cardsToAdd.length; i++) {
			int num = cardsToAdd[i];
			Card newCard = new Card(controller,this.cardIcon[num], backIcon, num);
			panel.add(newCard);
		}
		return panel;
	}
	
	private void randomizeCardArray(int[] deck) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		for(int i=0; i < deck.length; i++) {
			int item = rand.nextInt(deck.length);
			int swap = deck[item];
			deck[item] = deck[i];
			deck[i] =swap;
		}
	}

	private void newMenuItem(String string, JMenu gameMenu, ActionListener listener) {
		// TODO Auto-generated method stub
		JMenuItem newItem = new JMenuItem(string);
		newItem.setActionCommand(string);
		newItem.addActionListener(listener);
		gameMenu.add(newItem);
	}

	public void newGame() {
		this.mainContentFrame.removeAll();
		this.mainContentFrame.add(makeCards());
		this.mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setVisible(true);
		if (JOptionPane.showConfirmDialog(null, "Are you Ready to Begin?", "Ready?",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		    // yes option
			new HurdleTimer(this).start();
		} else {
		    // no option
		}
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(null,"Game Over! You ran out of time! \n Your Score is: "+controller.getScore()+" points.",
			      "Time Up",JOptionPane.ERROR_MESSAGE);
		newGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("New Game")) newGame();
		if(e.getActionCommand().equals("Exit")) System.exit(0);
		if(e.getActionCommand().equals("HighScores")) {			
			Score[] scores = new ScoreController().getHighScores();			
			Object[][] rows = {
				    {scores[0].getPosition(),scores[0].getUname(),scores[0].getScore()},
				    {scores[1].getPosition(),scores[1].getUname(),scores[1].getScore()},
				    {scores[2].getPosition(),scores[2].getUname(),scores[2].getScore()},
				    {scores[3].getPosition(),scores[3].getUname(),scores[3].getScore()},
				    {scores[4].getPosition(),scores[4].getUname(),scores[4].getScore()},
			};			
			Object[] cols = {
			    "Rank","Username","Score"
			};
			JTable table = new JTable(rows, cols);
			table.setFillsViewportHeight(true);
			JOptionPane.showMessageDialog(null, new JScrollPane(table),"Ranks",JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
}