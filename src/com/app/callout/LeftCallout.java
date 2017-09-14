/**
 * 
 */
package com.app.callout;

import java.awt.Color;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 04-Sept-2017
 */
public class LeftCallout extends Callout {

	private static final long serialVersionUID = 1L;

	public LeftCallout(Color borderColor, Color foreColor) {
		this.setForeground(foreColor);
		this.setBorder(new LeftCalloutBorder(borderColor));
	}

	@Override
	public void setText(String text) {
		StringBuffer txtToPrint = new StringBuffer("<html>");
		String txtArr[] = text.split("<br>");
		for (String sText : txtArr) {
			String txt = wordWrap(sText, 40, "Left");
			txtToPrint.append(txt).append("<br>");
		}
		txtToPrint.append("</html>");
		super.setText(txtToPrint.toString());
	}
}
