/**
 * 
 */
package com.app.instructions.beans;

import java.util.List;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 25-Aug-2017
 */
public class Row {

	private int width;
	private int height;
	private List<Col> cols;

	/**
	 * @return the cols
	 */
	public List<Col> getCols() {
		return cols;
	}

	/**
	 * @param cols the cols to set
	 */
	public void setCols(List<Col> cols) {
		this.cols = cols;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Width => ").append(width).append(" :: ");
		buf.append("Height => ").append(height);
		if(cols != null) {
			buf.append("\n");
			int counter = 1;
			for (Col col : cols) {
				buf.append(" ###Col = ").append(counter++).append(" <==> ").append(col.toString()).append("\n");
			}
		}
		return buf.toString();
	}
}
