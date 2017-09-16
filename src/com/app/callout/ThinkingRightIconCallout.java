/**
 * 
 */
package com.app.callout;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 12-Sept-2017
 */
public class ThinkingRightIconCallout extends Callout {
	
	private static final long serialVersionUID = 1L;
	private Icon icon = null;

	public ThinkingRightIconCallout(Color borderColor) {
		URL url = this.getClass().getClassLoader().getResource("thinking.gif");
		icon = new ImageIcon(url);
		ThinkingRightCalloutBorder customBorder = new ThinkingRightCalloutBorder(borderColor, 15);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setBorder(customBorder);
		this.setIconTextGap(10);
        this.setIcon(icon);
	}
	
	@Override
	public void setText(String text) {
		StringBuffer txtToPrint = new StringBuffer("<html>&nbsp;&nbsp;");
		String txtArr[] = text.split("<br>");
		for (String sText : txtArr) {
			String txt = wordWrap(sText, 40, "Right");
			txtToPrint.append(txt).append("<br>");
		}
		txtToPrint.append("</html>");
		super.setText(txtToPrint.toString());
	}
}
