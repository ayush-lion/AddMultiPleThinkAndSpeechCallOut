package com.app.imagePanel;

import java.awt.Color;

import javax.swing.JPanel;

import com.app.callout.Callout;
import com.app.callout.LeftCallout;
import com.app.callout.RightCallout;
import com.app.instruction.InstructionStudent;

public class ImagePanel extends JPanel {

	private int leftposX;
	private int rightposX;
	private int leftposY;
	private int rightposY;
	private ImagePanel imagePanel;
	private Callout leftlabel, rightlabel;
	private InstructionStudent instructionStudent;

	public ImagePanel() {

		instructionStudent = new InstructionStudent();
		leftlabel = new LeftCallout(Color.RED, Color.BLACK);
		rightlabel = new RightCallout(Color.GREEN, Color.black);

	}

	public ImagePanel(int leftposX, int leftposY, int rightposX, int rightposY) {
		this.leftposX = leftposX;
		this.leftposY = leftposY;
		this.rightposX = rightposX;
		this.rightposY = rightposY;

	}

	public void drawLeftLabel(String text) {
		leftlabel.setText("hello");
		leftlabel.setText("hurrah Text messaging, or texting, is the act of composing and sending electronic");
		this.add(leftlabel);
	}

	public void drawRightLabel(String text) {
		rightlabel.setText("yes");
		rightlabel.setLocation(getRightposX(), getRightposY());
		this.add(rightlabel);
	}

	public int getLeftposX() {
		return leftposX;
	}

	public void setLeftposX(int leftposX) {
		this.leftposX = leftposX;
	}

	public int getRightposX() {
		return rightposX;
	}

	public void setRightposX(int rightposX) {
		this.rightposX = rightposX;
	}

	public int getLeftposY() {
		return leftposY;
	}

	public void setLeftposY(int leftposY) {
		this.leftposY = leftposY;
	}

	public int getRightposY() {
		return rightposY;
	}

	public void setRightposY(int rightposY) {
		this.rightposY = rightposY;
	}
}
