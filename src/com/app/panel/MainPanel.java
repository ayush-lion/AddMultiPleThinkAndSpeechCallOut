/**
 * 
 */
package com.app.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

import com.app.integrated.main.Performer;

/**
 * @author prashant.joshi (198joshi@gmail.com)
 * @version 13-Sept-2017
 */
public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private StudentPanel sPanel;
	private TeacherPanel tPanel;
	private CalloutsPanel cPanel;
	private Performer performer;

	ArrayList<String> aList = new ArrayList<String>();


	public MainPanel(ArrayList<String> aList) {
		this.setLayout(new GridBagLayout());

		performer = new Performer();
		sPanel = new StudentPanel();
		tPanel = new TeacherPanel();
		cPanel = new CalloutsPanel(aList, "");

		// Add constraints
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.ipadx = 100;

//		showInstruction();
		
		// Add Student Panel
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 0.20;
		constraints.weighty = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(sPanel, constraints);

		// Add Callout panel
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 0.60;
		constraints.weighty = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		this.add(cPanel, constraints);

		// Add teacher Panel
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.weightx = 0.20;
		constraints.weighty = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(tPanel, constraints);
	}

	public MainPanel() {
		this.setLayout(new GridBagLayout());

		sPanel = new StudentPanel();
		tPanel = new TeacherPanel();
		JPanel jPanel = new JPanel();

		// Add constraints
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.ipadx = 100;

		// Add Student Panel
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 0.20;
		constraints.weighty = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(sPanel, constraints);

		// Add blank Panel
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 0.60;
		constraints.weighty = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		this.add(jPanel, constraints);

		// Add teacher Panel
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.weightx = 0.20;
		constraints.weighty = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(tPanel, constraints);
	}
	
	public void showInstruction(Performer per) {
		System.out.println(per.getInstruction());
	}

	public void reset() {

		new MainPanel();

	}
}
