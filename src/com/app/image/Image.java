package com.app.image;

import java.awt.Color;
import java.awt.Graphics;

public class Image {
	
	private int posX;
	private int posY;
	private String image;
	
	public Image(int posX,int posY) 
	{
		this.posX = posX;
		this.posY = posY;
	}
	
	public void drawImage(Graphics g) 
	{
		g.setColor(Color.BLACK);
		
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
