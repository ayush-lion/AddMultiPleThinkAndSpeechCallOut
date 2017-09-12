package com.app.topic.panel;

import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JPanel;
import com.app.topic.Topic;

public class TopicPanel extends JPanel {
	
	public TopicPanel() {
		// TODO Auto-generated constructor stub
	}

	private int texttopicposX;
	private int texttopicposY;
	private int texttopicheight;
	private int texttopicweidth;
	private String text;
	private Topic topic;

	
	public TopicPanel(int posX, int posY, int width, int height) {
		this.texttopicposX = posX;
		this.texttopicposY = posY;
		this.texttopicweidth = width;
		this.texttopicheight = height;
	}


	public int getTexttopicposX() {
		return texttopicposX;
	}


	public void setTexttopicposX(int texttopicposX) {
		this.texttopicposX = texttopicposX;
	}


	public int getTexttopicposY() {
		return texttopicposY;
	}


	public void setTexttopicposY(int texttopicposY) {
		this.texttopicposY = texttopicposY;
	}


	public int getTexttopicheight() {
		return texttopicheight;
	}


	public void setTexttopicheight(int texttopicheight) {
		this.texttopicheight = texttopicheight;
	}


	public int getTexttopicweidth() {
		return texttopicweidth;
	}


	public void setTexttopicweidth(int texttopicweidth) {
		this.texttopicweidth = texttopicweidth;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
