/**
 * 
 */
package com.app.callout;

import java.awt.Color;

/**
 * @author prashant.joshi
 *
 */
public class FilledLeftCallout extends Callout {
	
	private static final long serialVersionUID = 1L;

	public FilledLeftCallout(Color filledColor, Color foreColor) {
		this.setBackground(filledColor);
		this.setForeground(foreColor);
		this.setOpaque(true);
		this.setBorder(new FilledLeftCalloutBorder(filledColor));
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
