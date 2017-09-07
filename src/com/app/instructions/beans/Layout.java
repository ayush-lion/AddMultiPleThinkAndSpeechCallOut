/**
 * 
 */
package com.app.instructions.beans;

import java.util.List;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 25-Aug-2107
 */
public class Layout {
	
	private int numOfRow;
	private int numOfCols;
	private List<Row> rows;
	
	/**
	 * @return the numOfRow
	 */
	public int getNumOfRow() {
		return numOfRow;
	}
	/**
	 * @param numOfRow the numOfRow to set
	 */
	public void setNumOfRow(int numOfRow) {
		this.numOfRow = numOfRow;
	}
	/**
	 * @return the numOfCols
	 */
	public int getNumOfCols() {
		return numOfCols;
	}
	/**
	 * @param numOfCols the numOfCols to set
	 */
	public void setNumOfCols(int numOfCols) {
		this.numOfCols = numOfCols;
	}
	/**
	 * @return the rows
	 */
	public List<Row> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("NumOfRows => ").append(numOfRow).append(" :: ");
		buf.append("NumOfCols => ").append(numOfCols);
		if(rows != null) {
			buf.append("\n");
			int counter = 1;
			for (Row row : rows) {
				buf.append("Row => ").append(counter++).append(" ").append(row.toString());
			}
		}
		return buf.toString();
	}
	
}
