/**
 * 
 */
package com.app.panel;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.app.callout.FilledLeftCallout;

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
		
		for (int i = 0; i < aList.size(); i++) { 
			
			if(aList.get(i).startsWith("ST")) 
			{
			callouts[(i*2)+1] = new CalloutPanel(false,"TT");	
			callouts[i*2] = new CalloutPanel(false,"ST");	
			callouts[i*2].getCallout().setText(aList.get(i));
			callouts[(i*2)+1].getCallout().setVisible(Boolean.FALSE);
			this.add(callouts[i*2]);
			this.add(callouts[(i*2)+1]);
			}
			else if(aList.get(i).startsWith("TT"))
			{
			callouts[i*2] = new CalloutPanel(true,"ST");		
			callouts[(i*2)+1] = new CalloutPanel(false,"TT");	
			callouts[(i*2)+1].getCallout().setText(aList.get(i));
			callouts[i*2].getCallout().setVisible(Boolean.FALSE);
			this.add(callouts[i*2]);
			this.add(callouts[(i*2)+1]);
			}else
			if(aList.get(i).startsWith("SS")) 
			{
			callouts[(i*2)+1] = new CalloutPanel(false,"TS");	
			callouts[i*2] = new CalloutPanel(false,"SS");	
			callouts[i*2].getCallout().setText(aList.get(i));
			callouts[(i*2)+1].getCallout().setVisible(Boolean.FALSE);
			this.add(callouts[i*2]);
			this.add(callouts[(i*2)+1]);
			}
			else if(aList.get(i).startsWith("TS"))
			{
			callouts[i*2] = new CalloutPanel(true,"SS");		
			callouts[(i*2)+1] = new CalloutPanel(false,"TS");	
			callouts[(i*2)+1].getCallout().setText(aList.get(i));
			callouts[i*2].getCallout().setVisible(Boolean.FALSE);
			this.add(callouts[i*2]);
			this.add(callouts[(i*2)+1]);
			}	
		}
	}
}
