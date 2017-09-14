/**
 * 
 */
package com.app.callout;

import java.awt.Color;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 04-Sept-2017
 */
public class FilledRightCallout extends Callout {
	
	private static final long serialVersionUID = 1L;
	
	public FilledRightCallout(Color filledColor, Color foreColor) {
		this.setBackground(filledColor);
		this.setForeground(foreColor);
		this.setOpaque(true);
		this.setBorder(new FilledRightCalloutBorder(filledColor));
	}
	
	@Override
	public void setText(String text) {
		StringBuffer txtToPrint = new StringBuffer("<html>");
		String txtArr[] = text.split("<br>");
		for (String sText : txtArr) {
			String txt = wordWrap(sText, 40, "Right");
			txtToPrint.append(txt).append("<br>");
		}
		txtToPrint.append("</html>");
		System.out.println(txtToPrint.toString());
		super.setText(txtToPrint.toString());
	}
}
