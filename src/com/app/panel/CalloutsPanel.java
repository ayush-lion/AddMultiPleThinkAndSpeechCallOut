/**
 * 
 */
package com.app.panel;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 13-Sept-2017
 */
public class CalloutsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private CalloutPanel[] callouts ;
	
	public CalloutsPanel(ArrayList<String> aList) {
		this.setLayout(new GridLayout(aList.size(),3));
		callouts = new CalloutPanel[aList.size()*2];
		boolean isStudent = Boolean.TRUE;
		
		for (int i = 0; i < aList.size()*2; i++) {
			callouts[i] = new CalloutPanel(isStudent);
			if(isStudent) 
				callouts[i].getCallout().setText(aList.get(i/2)); 
			else
				callouts[i].getCallout().setText(aList.get(i/2));
			if(i == 1 || i == 2 || i == 5)
				callouts[i].getCallout().setVisible(Boolean.FALSE);
			isStudent = !isStudent;
			this.add(callouts[i]);
		}
	}
	
	public CalloutsPanel(ArrayList<String> aList, String text)
	{
		this.setLayout(new GridLayout(aList.size(),3));
		callouts = new CalloutPanel[aList.size()*2];
		boolean tutor1 = Boolean.TRUE;
		
		for (int i = 0; i < aList.size()*2; i++) {
			callouts[i] = new CalloutPanel(tutor1);
			if(tutor1)
				callouts[i].getCallout().setText(aList.get(i/2));
			else
				callouts[i].getCallout().setText(aList.get(i/2));
			if(i == 0 || i == 3 || i == 4)
				callouts[i].getCallout().setVisible(Boolean.FALSE);
			tutor1 = !tutor1;
			this.add(callouts[i]);
		}
	}
}
