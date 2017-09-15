/**
 * 
 */
package com.app.main;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.app.panel.MainPanel;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 13-Sept-2017
 */
public class Test extends JFrame {
	ArrayList<String> aList = new ArrayList<String>();
	MainPanel mPanel ;
	
	private static final long serialVersionUID = 1L;

	public Test() {
		
		super("Test Actors and Callouts");
		
		aList.add("Good Morning Students how ");
		aList.add("Good Morning Students how are");
		aList.add("Good Morning Students ");
		aList.add("Good Morning Students 1");
		aList.add("Good Morning Students 2");
		aList.add("Good Morning Students 3");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mPanel = new MainPanel(aList);
		this.add(mPanel);
		this.setSize(800, 400);
		this.setVisible(true); 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test();
            }
        });
	}

}
