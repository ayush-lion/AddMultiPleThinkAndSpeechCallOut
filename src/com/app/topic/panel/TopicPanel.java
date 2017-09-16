package com.app.topic.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.app.integrated.main.Performer;
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
	
	private String fontName="serif";
	private String topicName="Good Morning Students";
	private int fontSize=20;
	
	private Performer performer;

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Dimension d = this.getPreferredSize();
		g.setFont(new Font(getFontName(), Font.PLAIN, getFontSize()));
		g.setColor(Color.black);
		g.drawString(getTopicName(), 400, 35);
	}

	public int getTexttopicposX() {
		return texttopicposX;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
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
