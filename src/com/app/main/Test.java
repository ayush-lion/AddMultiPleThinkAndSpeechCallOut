/**
 * 
 */
package com.app.main;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.app.integrated.main.Performer;
import com.app.panel.MainPanel;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 13-Sept-2017
 */
public class Test extends JFrame {
	ArrayList<String> aList = new ArrayList<String>();
	MainPanel mPanel ;
	Performer performer;
	
	private static final long serialVersionUID = 1L;

	public Test() {
		super("Test Actors and Callouts");
		performer = new Performer();

	    System.out.println("hello:"+performer.getSb());
		
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
