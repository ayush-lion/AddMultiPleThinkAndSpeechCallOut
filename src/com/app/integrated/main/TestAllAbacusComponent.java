package com.app.integrated.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.app.abacus.Frame;
import com.app.abacus.panel.AbacusPanel;
import com.app.callout.Callout;
import com.app.callout.RightCallout;
import com.app.imagePanel.ImagePanel;
import com.app.instruction.panel.InstructionPanel;
import com.app.instructions.beans.Action;
import com.app.instructions.compiler.InstructionCompiler;
import com.app.instructions.compiler.exception.CompilerException;
import com.app.sound.DownloadSpeech;
import com.app.test.TextAreaRenderer;
import com.app.topic.panel.TopicPanel;

/**
 * @author prashant.joshi
 *
 */
public class TestAllAbacusComponent extends JFrame {

	private static final long serialVersionUID = 1L;

	// Top panels

	String txtRed = "This is a <colorred>Callout Demo</colorred>";
	String txtBlue = "This is a <colorblue>Callout Demo</colorblue>";

	LinkedHashMap<String, HashMap<String, List<Action>>> data;

	private JMenuBar menuBar;

	private JMenu menu;
	private JMenu natural;

	private JMenu menu1;
	private JMenu menu2;

	private JCheckBoxMenuItem robotics;
	private JCheckBoxMenuItem Sharon;
	private JCheckBoxMenuItem Rachel;
	private JCheckBoxMenuItem Deepa;

	private ButtonGroup vGroup = null;

	private JRadioButton voice1 = new JRadioButton("Sharon");
	private JRadioButton voice2 = new JRadioButton("Rachel");
	private JRadioButton voice3 = new JRadioButton("Deepa");

	private boolean isPlayRobotics = false;
	private boolean isPlayNatural = true;

	private DownloadSpeech downloadSpeech;
	private Frame frame;

	// private JPanel tablepanel;
	// private JPanel playPanel;

	String filenameatt;

	// Abacus Top Panel

	private JCheckBox doWeNeedFrame;
	private JCheckBox doWeNeedFingers;

	private JTextField attrTxt;

	private JButton loadAbacus;
	private JButton showAbacus;
	private JButton stopAbacus;
	private JButton killButton;

	private int posX = 0;
	private int posY = 0;
	private int mainPanelWidth = 1130;
	private int mainPanelheight = 700;

	private int topic_width = 100;
	private int topic_height = 5;

	private int abacus_width = 100;
	private int abacus_height = 50;

	private int instruction_width = 100;
	private int instruction_height = 20;

	private int image_width = 100;
	private int image_hight = 10;

	private TopicPanel topicPanel;
	private AbacusPanel abacusPanel;
	private InstructionPanel instructionpanel;
	private ImagePanel imagePanel;

	private Performer performer;
	private InstructionCompiler complier;

	// Abacus Bead Up Panel

	private String abacuspath;
	private String instructionpath;
	private String excelfile;

	private boolean isabacusprovided;
	private boolean isinstructionprovided;

	private JCheckBoxMenuItem abacusprop;
	private JCheckBoxMenuItem instprop;

	private JCheckBoxMenuItem loadinstructionfile;
	private JCheckBoxMenuItem startcheck;
	private JCheckBoxMenuItem refresh;
	private JCheckBoxMenuItem stop;

	private JTable table;
	private JPanel mainPanel;

	public TestAllAbacusComponent() throws Throwable {

		try {

			mainPanel = new JPanel();
			mainPanel.setBounds(getPosX(), getPosY(), getMainPanelWidth(), getMainPanelheight());

			/* Create Abacus Panel */

			setupMenuBar();
			setUpAbacusTopPanel();

			topicPanel = new TopicPanel();
			abacusPanel = new AbacusPanel();
			instructionpanel = new InstructionPanel();
			imagePanel = new ImagePanel();

			imagePanel.drawLeftLabel("");
			imagePanel.drawRightLabel("");

			setBoundsTopic();
			setBoundsAbacus();
			setBoundsInstruction();
			setBoundsImage();

			mainPanel.setLayout(null);
			mainPanel.add(topicPanel);
			mainPanel.add(abacusPanel);
			mainPanel.add(instructionpanel);
			mainPanel.add(imagePanel);

			this.setResizable(true);
			this.setTitle("Abacus. Lets start learning mind math !!!");
			this.setLocation(50, 50);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.getContentPane().setBackground(Color.white);

			this.setJMenuBar(menuBar);
			this.add(mainPanel);
			this.setSize(getMainPanelWidth(), getMainPanelheight());
			this.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// add the table to the frame

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Row");
		model.addColumn("Instructions");
		model.addColumn("Actions");

		table = new JTable(model);
		table.setGridColor(Color.LIGHT_GRAY);

		table.getColumn("Instructions").setCellRenderer(new TextAreaRenderer());
		table.getColumn("Actions").setCellRenderer(new TextAreaRenderer());

		TableColumn column = table.getColumnModel().getColumn(0);
		column.setPreferredWidth(100);

		column = table.getColumnModel().getColumn(1);
		column.setPreferredWidth(300);

		column = table.getColumnModel().getColumn(2);
		column.setPreferredWidth(600);
	}

	/** list of actions into an HashMap */

	public void setBoundsTopic() {
		topicPanel.setBounds(getPosX(), getPosY(), getMainPanelWidth() * getTopic_width() / 100,
				(getMainPanelheight() * getTopic_height() / 100));
		topicPanel.setBackground(Color.LIGHT_GRAY);
	}

	public void setBoundsAbacus() {
		abacusPanel.setBounds(getPosX(), getMainPanelheight() * getTopic_height() / 100,
				getMainPanelWidth() * getAbacus_width() / 100, (getMainPanelheight() * getAbacus_height() / 100));
		abacusPanel.setBackground(Color.white);

	}

	public void setBoundsInstruction() {
		instructionpanel.setBounds(getPosX(),
				(getMainPanelheight() * getTopic_height() / 100) + (getMainPanelheight() * getAbacus_height() / 100),
				(getMainPanelWidth() * getInstruction_width()) / 100,
				(getMainPanelheight() * getInstruction_height() / 100));
		instructionpanel.setBackground(Color.gray);

	}

	public void setBoundsImage() {
		imagePanel.setBounds(getPosX(),
				(getMainPanelheight() * getTopic_height() / 100) + (getMainPanelheight() * getAbacus_height() / 100)
						+ (getMainPanelheight() * getInstruction_height() / 100),
				(getMainPanelWidth() * getImage_width() / 100), (getMainPanelheight() * getImage_hight() / 100));

	}

	private void enableNaturalVoices(boolean enable) {
		Sharon.setEnabled(enable);
		Rachel.setEnabled(enable);
		Deepa.setEnabled(enable);

		if (enable) {
			Sharon.setSelected(true);
			Rachel.setSelected(false);
			Deepa.setSelected(false);
		} else {
			Sharon.setSelected(false);
			Rachel.setSelected(false);
			Deepa.setSelected(false);
		}
	}

	private void setupMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("Voices");
		menu.setMnemonic(KeyEvent.VK_V);
		menuBar.add(menu);

		natural = new JMenu("Natural");
		natural.setMnemonic(KeyEvent.VK_N);
		natural.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				robotics.setSelected(false);
				isPlayRobotics = false;
				isPlayNatural = true;

				/** Disabling the voice selection pane */

				enableNaturalVoices(true);
				killButton.setEnabled(true);
			}
		});

		menu.add(natural);

		robotics = new JCheckBoxMenuItem("Robotics");
		robotics.setMnemonic(KeyEvent.VK_R);
		robotics.setSelected(true);
		robotics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				natural.setSelected(false);
				isPlayRobotics = true;
				isPlayNatural = false;

				/** Disabling the voice selection pane */

				enableNaturalVoices(false);
				killButton.setEnabled(false);
			}
		});

		menu.add(robotics);

		Sharon = new JCheckBoxMenuItem("Sharon");
		Sharon.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				robotics.setSelected(false);
				isPlayRobotics = false;
				isPlayNatural = true;

				/** Disabling the voice selection pane */

				Rachel.setSelected(false);
				Deepa.setSelected(false);
				killButton.setEnabled(true);
			}
		});

		natural.add(Sharon);

		Rachel = new JCheckBoxMenuItem("Rachel");
		Rachel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				robotics.setSelected(false);
				isPlayRobotics = false;
				isPlayNatural = true;

				/** Disabling the voice selection pane */

				Sharon.setSelected(false);
				Deepa.setSelected(false);
				killButton.setEnabled(true);
			}
		});

		natural.add(Rachel);

		Deepa = new JCheckBoxMenuItem("Deepa");
		Deepa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				robotics.setSelected(false);
				isPlayRobotics = false;
				isPlayNatural = true;

				/** Disabling the voice selection pane */

				Sharon.setSelected(false);
				Rachel.setSelected(false);
				killButton.setEnabled(true);
			}
		});

		natural.add(Deepa);

		menu1 = new JMenu("Properties");
		menu1.setMnemonic(KeyEvent.VK_V);

		abacusprop = new JCheckBoxMenuItem("Load Abacus Properties");
		abacusprop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abacusprop.setSelected(false);
				try {
					JFileChooser jFileChooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Properties FILES", "properties");
					jFileChooser.setFileFilter(filter);
					int result = jFileChooser.showOpenDialog(new JFrame());
					if (result == JFileChooser.APPROVE_OPTION) {
						File selectedFile = jFileChooser.getSelectedFile();
						attrTxt.setText(selectedFile.getAbsolutePath());
						abacusPanel.setAbacusAttributesFileName(attrTxt.getText());
						showAbacus.setEnabled(true);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		instprop = new JCheckBoxMenuItem("Load Instruction Properties");
		instprop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				instprop.setSelected(false);
				// TODO Auto-generated method stub
				try {
					JFileChooser jFileChooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Properties FILES", "properties");
					jFileChooser.setFileFilter(filter);
					int result = jFileChooser.showOpenDialog(new JFrame());
					if (result == JFileChooser.APPROVE_OPTION) {
						File selectedFile = jFileChooser.getSelectedFile();
						attrTxt.setText(selectedFile.getAbsolutePath());
						setInstructionpath(attrTxt.getText());
						// System.out.println("instruction prop" + getInstructionpath());

						instructionpanel.setAttributespath(selectedFile.getAbsolutePath());
						instructionpanel.Initialize_Instruction_Panel(instructionpanel);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		menu1.add(abacusprop);
		menu1.add(instprop);
		menuBar.add(menu1);

		menu2 = new JMenu("Start");
		menu2.setMnemonic(KeyEvent.VK_V);

		loadinstructionfile = new JCheckBoxMenuItem("Load File");
		loadinstructionfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				loadinstructionfile.setSelected(false);
				// TODO Auto-generated method stub
				try {
					JFileChooser jFileChooser = new JFileChooser();
					int result = jFileChooser.showOpenDialog(new JFrame());
					if (result == JFileChooser.APPROVE_OPTION) {
						File selectedFile = jFileChooser.getSelectedFile();
						attrTxt.setText(selectedFile.getAbsolutePath());
						abacusPanel.setAbacusAttributesFileName(attrTxt.getText());
						showAbacus.setEnabled(true);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		startcheck = new JCheckBoxMenuItem("Start");
		startcheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				compile(attrTxt.getText().toString());
				startcheck.setSelected(false);

			}
		});

		refresh = new JCheckBoxMenuItem("Refresh");
		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refresh.setSelected(false);

				setTopic_height(Integer.parseInt(performer.getTopicHeight().replace("null", "")));
				setTopic_width(Integer.parseInt(performer.getTopicWidth().replace("null", "")));

				setAbacus_height(Integer.parseInt(performer.getAbacusHight().replace("null", "")));
				setAbacus_width(Integer.parseInt(performer.getAbacusWidth().replace("null", "")));

				setInstruction_height(Integer.parseInt(performer.getInstructionHight().replace("null", "")));
				setInstruction_width(Integer.parseInt(performer.getInstructionWidth().replace("null", "")));

				setImage_hight(Integer.parseInt(performer.getActorHight().replace("null", "")));
				setImage_width(Integer.parseInt(performer.getActorWidth().replace("null", "")));

				setBoundsTopic();
				setBoundsAbacus();
				setBoundsInstruction();
				setBoundsImage();

				topicPanel.setTopicName(performer.getTopicName());
				topicPanel.setFontName(performer.getTopicName());
				topicPanel.setFontSize(Integer.parseInt(performer.getComponentSize()));
				
				imagePanel.setTutorspeech(performer.getTutorSpeech());
				imagePanel.setStudentspeech(performer.getStudentSpeech());
				
				imagePanel.drawLeftLabel("");
				imagePanel.drawRightLabel("");
				
				topicPanel.repaint();
				instructionpanel.repaint();
				abacusPanel.repaint();
			
				// TODO Auto-generated method stub
			}
		});

		stop = new JCheckBoxMenuItem("Stop");
		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abacusPanel.showAbacus();
				performer.stopPlayback();
				try {
					instructionpanel.Initialize_Instruction_Panel(instructionpanel);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		menu2.add(loadinstructionfile);
		menu2.add(startcheck);
		menu2.add(refresh);
		menu2.add(stop);
		menuBar.add(menu2);

	}

	public void showPanel() throws IOException {
		this.setVisible(true);
		try {
			abacusPanel.hideFingers(Boolean.TRUE);
			abacusPanel.initializeAbacus();
			instructionpanel.Initialize_Instruction_Panel(instructionpanel);
			// compile("/Users/Panwar/Desktop/AppInstruction.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setUpAbacusTopPanel() {
		// Buttons

		loadAbacus = new JButton("Load Abacus Instructions");
		showAbacus = new JButton("Start");
		stopAbacus = new JButton("Stop");

		// Frame

		doWeNeedFrame = new JCheckBox("Show Frame");

		doWeNeedFrame.setSelected(true);
		doWeNeedFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (doWeNeedFrame.isSelected()) {
					abacusPanel.hideFrame(Boolean.TRUE);
				} else {
					abacusPanel.hideFrame(Boolean.FALSE);
				}
			}
		});

		// Fingers

		doWeNeedFingers = new JCheckBox("Show Fingers");
		doWeNeedFingers.setSelected(true);
		doWeNeedFingers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (doWeNeedFingers.isSelected()) {
					abacusPanel.hideFingers(Boolean.TRUE);
				} else {
					abacusPanel.hideFingers(Boolean.FALSE);
				}
			}
		});

		attrTxt = new JTextField();

		// Show Abacus Button

		showAbacus.setEnabled(Boolean.FALSE);
		showAbacus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startcompilation(attrTxt.getText());
			}
		});

		// Load Abacus

		loadAbacus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jFileChooser = new JFileChooser();
					int result = jFileChooser.showOpenDialog(new JFrame());
					if (result == JFileChooser.APPROVE_OPTION) {
						File selectedFile = jFileChooser.getSelectedFile();
						attrTxt.setText(selectedFile.getAbsolutePath());
						abacusPanel.setAbacusAttributesFileName(attrTxt.getText());
						showAbacus.setEnabled(true);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// Add components in Panel

		killButton = new JButton("Kill Demo");
		killButton.setBounds(945, 10, 90, 40);
		killButton.setEnabled(false);
		killButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abacusPanel.initializeAbacus();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// performer.stopPlayback();
				if (isPlayNatural) {
					voice1.setEnabled(true);
					voice2.setEnabled(true);
					voice3.setEnabled(true);
				}
			}
		});
	}

	public void startcompilation(String filename) {
		compile(filename);

	}

	private void compile(String filename) {
		try {
			complier = new InstructionCompiler(filename);
			boolean isAllSet = complier.compileInstructions();
			if (!isAllSet) {
				JOptionPane.showMessageDialog(null, "Found Errors!!!. Please resolve!!!", "InfoBox: Abacus Compiler",
						JOptionPane.INFORMATION_MESSAGE);
				displayErrors(complier.getMapOfErrors());
			} else {
				JOptionPane.showMessageDialog(null, "No Errors!!!.", "InfoBox: Abacus Compiler",
						JOptionPane.INFORMATION_MESSAGE);
				start_instructions(complier.getInstructionData());
			}
		} catch (CompilerException e1) {
			e1.printStackTrace();
		}
	}

	private void displayErrors(LinkedHashMap<String, HashMap<String, List<String>>> errors) {
		// TODO Auto-generated method stub

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();

		Set<Entry<String, HashMap<String, List<String>>>> entrySet = errors.entrySet();
		for (Entry<String, HashMap<String, List<String>>> entry : entrySet) {
			Object[] tableRow = new Object[3];
			String row = entry.getKey();
			tableRow[0] = row;

			HashMap<String, List<String>> errorMsgs = entry.getValue();
			List<String> errorList = errorMsgs.get("instructionError");
			StringBuffer insBuf = new StringBuffer();
			for (String errorMsg : errorList) {
				System.out.println(errorMsg);
				insBuf.append(errorMsg).append("\n");
			}

			tableRow[1] = insBuf.toString();

			StringBuffer actBuf = new StringBuffer();
			List<String> errorAList = errorMsgs.get("actionError");
			for (String errorMsg : errorAList) {
				actBuf.append(errorMsg).append("\n");
			}
			tableRow[2] = actBuf.toString();

			model.addRow(tableRow);
		}

		// JOptionPane.showConfirmDialog(null, tablepanel, "Error Details",
		// JOptionPane.CANCEL_OPTION);
	}

	public void start_instructions(LinkedHashMap<String, HashMap<String, List<Action>>> linkedHashMap) {

		performer = new Performer();
		performer.setAbacusPanel(abacusPanel);
		performer.setInstructionPanel(instructionpanel);
		performer.setData(linkedHashMap);
		performer.setPlayRobotics(isPlayRobotics);
		performer.setPlayNatural(false);
		performer.startReading();

	}

	/**
	 * @param args
	 * @throws Throwable
	 */

	public int getTopic_width() {
		return topic_width;
	}

	public JMenu getNatural() {
		return natural;
	}

	public void setNatural(JMenu natural) {
		this.natural = natural;
	}

	public int getImage_hight() {
		return image_hight;
	}

	public void setImage_hight(int image_hight) {
		this.image_hight = image_hight;
	}

	public int getImage_width() {
		return image_width;
	}

	public void setImage_width(int image_width) {
		this.image_width = image_width;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getMainPanelWidth() {
		return mainPanelWidth;
	}

	public void setMainPanelWidth(int mainPanelWidth) {
		this.mainPanelWidth = mainPanelWidth;
	}

	public int getMainPanelheight() {
		return mainPanelheight;
	}

	public void setMainPanelheight(int mainPanelheight) {
		this.mainPanelheight = mainPanelheight;
	}

	public int getTopic_height() {
		return topic_height;
	}

	public void setTopic_height(int topic_height) {
		this.topic_height = topic_height;
	}

	public int getAbacus_height() {
		return abacus_height;
	}

	public void setAbacus_height(int abacus_height) {
		this.abacus_height = abacus_height;
	}

	public int getAbacus_width() {
		return abacus_width;
	}

	public void setAbacus_width(int abacus_width) {
		this.abacus_width = abacus_width;
	}

	public int getInstruction_height() {
		return instruction_height;
	}

	public void setInstruction_height(int instruction_height) {
		this.instruction_height = instruction_height;
	}

	public int getInstruction_width() {
		return instruction_width;
	}

	public void setInstruction_width(int instruction_width) {
		this.instruction_width = instruction_width;
	}

	public void setTopic_width(int topic_width) {
		this.topic_width = topic_width;
	}

	/**
	 * @return the instructionpath
	 */
	public String getInstructionpath() {
		return instructionpath;
	}

	/**
	 * @param instructionpath
	 *            the instructionpath to set
	 */
	public void setInstructionpath(String instructionpath) {
		this.instructionpath = instructionpath;
	}

	/**
	 * @return the isabacusprovided
	 */
	public boolean isIsabacusprovided() {
		return isabacusprovided;
	}

	/**
	 * @param isabacusprovided
	 *            the isabacusprovided to set
	 */
	public void setIsabacusprovided(boolean isabacusprovided) {
		this.isabacusprovided = isabacusprovided;
	}

	/**
	 * @return the isinstructionprovided
	 */
	public boolean isIsinstructionprovided() {
		return isinstructionprovided;
	}

	/**
	 * @param isinstructionprovided
	 *            the isinstructionprovided to set
	 */
	public void setIsinstructionprovided(boolean isinstructionprovided) {
		this.isinstructionprovided = isinstructionprovided;
	}

	/**
	 * @return the excelfile
	 */
	public String getExcelfile() {
		return excelfile;
	}

	/**
	 * @param excelfile
	 *            the excelfile to set
	 */
	public void setExcelfile(String excelfile) {
		this.excelfile = excelfile;
	}

	/**
	 * @return the abacusprop
	 */
	public JCheckBoxMenuItem getAbacusprop() {
		return abacusprop;
	}

	/**
	 * @param abacusprop
	 *            the abacusprop to set
	 */
	public void setAbacusprop(JCheckBoxMenuItem abacusprop) {
		this.abacusprop = abacusprop;
	}

	public static void main(String[] args) throws Throwable {
		TestAllAbacusComponent ob = new TestAllAbacusComponent();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {

					ob.showPanel();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}