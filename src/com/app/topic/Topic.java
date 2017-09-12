package com.app.topic;

import java.awt.Color;
import java.awt.Graphics;

public class Topic  {

	private int posX;
	private int posY;
	private String text;

	public Topic(int posX, int posY, int width, int height) {
		this.posX = posX;
		this.posY = posY;
	}

	public Topic() {
		// TODO Auto-generated constructor stub
	}
 
	public void drawTopic(Graphics g) {

		g.setColor(Color.BLACK);
		g.drawString(getText(), getPosX(), getPosY());
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
