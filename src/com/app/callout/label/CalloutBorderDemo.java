/**
 * 
 */
package com.app.callout.label;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.app.callout.Callout;
import com.app.callout.FilledLeftCallout;
import com.app.callout.FilledRightCallout;
import com.app.callout.LeftCallout;
import com.app.callout.RightCallout;

/**
 * @author prashant.joshi(198joshi@gmail.com)
 * @version 05-Sept-2017
 */
public class CalloutBorderDemo {
	public static void main(String args[]) {
		JFrame f = new JFrame("Callout Samples");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel cp = new JPanel();
		f.setContentPane(cp);

		String txtRed = "This is a <colorred>Callout Demo</colorred>";
		String txtBlue = "This is a <colorblue>Callout Demo</colorblue>";
		String txtYellow = "This is a <coloryellow>Callout Demo</coloryellow>";
		String txtGreen = "This is a <colorgreen>Callout Demo</colorgreen>";
		String bTxt = "This is a <colorred>Callout Demo</colorred>.";

		/* Right Pointed Callout */
		Callout rightLabel = new RightCallout(Color.GREEN, Color.YELLOW);
		rightLabel.setText(txtRed);

		/* Left Pointed Callout */
		Callout leftLabel = new LeftCallout(Color.RED, Color.BLACK);
		leftLabel.setText(txtBlue);

		/* Filled Left Pointed Callout */
		Callout filledLeftLabel = new FilledLeftCallout(Color.CYAN, Color.BLACK);
		filledLeftLabel.setText(txtYellow);

		/* Filled Right Pointed Callout */
		Callout filledRightLabel = new FilledRightCallout(Color.YELLOW, Color.BLACK);
		filledRightLabel.setText(txtGreen);

		/* Right Pointed Callout (Big Text) */
		Callout rightLabel1 = new RightCallout(Color.RED, Color.BLACK);
		rightLabel1.setText(bTxt);

		f.getContentPane().setLayout(new FlowLayout());
		f.getContentPane().add(leftLabel);
		f.getContentPane().add(rightLabel);
		f.getContentPane().add(filledLeftLabel);
		f.getContentPane().add(filledRightLabel);
		f.getContentPane().add(rightLabel1);

		f.setSize(400, 600);
		f.setVisible(true);
	}
}
