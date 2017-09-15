/**
 * 
 */
package com.app.panel;

import java.awt.Color;

import javax.swing.JPanel;

import com.app.callout.Callout;
import com.app.callout.FilledLeftCallout;
import com.app.callout.FilledRightCallout;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 13-Sept-2017
 */
public class CalloutPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private Callout callout; 
	
	public CalloutPanel(boolean isStudent) {
		if(isStudent) {
			callout = new FilledLeftCallout(Color.YELLOW, Color.BLUE);
		} else {
			callout = new FilledRightCallout(Color.CYAN, Color.BLACK);
		}
		this.add(callout);
	}

	/**
	 * @return the callout
	 */
	public Callout getCallout() {
		return callout;
	}
}
