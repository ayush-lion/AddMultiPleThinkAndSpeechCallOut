/**
 * 
 */
package com.app.callout;

import java.awt.Color;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 04-Sept-2017
 */
public class RightCallout extends Callout {
	
	private static final long serialVersionUID = 1L;
	
	public RightCallout(Color borderColor, Color foreColor) {
		this.setForeground(foreColor);
		this.setBorder(new RightCalloutBorder(borderColor));
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
