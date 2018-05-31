package classes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import controller.CardController;

public class Card extends JLabel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Icon frontIcon;
	Icon backIcon;
	boolean faceUp = false;
	int num;
	int iconWidthHalf, iconHeightHalf;
	boolean mousePressedOnMe = false;
	private CardController controller;
	
	public Card (CardController controller, Icon face,Icon back, int num) {
		super(back);
		this.frontIcon = face;
		this.backIcon = back;
		this.num = num;
		
		this.addMouseListener(this);
		this.iconHeightHalf=back.getIconHeight()/2;
		this.iconWidthHalf=face.getIconWidth()/2;
		this.controller = controller;
	}

	public int getNum() {
		return num;
	}
	
	private boolean overIcon(int x,int y) {
		int disX=Math.abs(x-this.getWidth()/2);
		int disY=Math.abs(y-this.getHeight()/2);
		
		if(disX>this.iconHeightHalf || disY>this.iconWidthHalf) {
			return false;
		}
		return true;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(overIcon(e.getX(),e.getY())) {
			this.turnUp();
		}

	}

	public void turnUp() {
		// TODO Auto-generated method stub
		if(this.faceUp) return;
		//test
		this.faceUp=true;
		this.faceUp = this.controller.turnUp(this);
		if(this.faceUp) this.setIcon(this.frontIcon);;
	}

	public void turnDown() {
		// TODO Auto-generated method stub
		if(!this.faceUp) return;
		this.setIcon(this.backIcon);
		this.faceUp = false;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.mousePressedOnMe=false;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(overIcon(e.getX(),e.getY())) {
			this.mousePressedOnMe=true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this.mousePressedOnMe) {
			this.mousePressedOnMe=false;
			this.mouseClicked(e);
		}
	}
}
