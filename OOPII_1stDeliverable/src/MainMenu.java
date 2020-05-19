import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


public class MainMenu extends JFrame implements ActionListener{
	
	private JButton createCity;
	private JButton traveller;
	private JButton buissnessTraveller;
	private JButton touristTraveller;
	private JButton printCities;
	private JButton showTravellers;
	private JButton quit;
	private JLabel note;	
	private static String tmp;
	private static int returnValue;
	//private FormPanel formPanel;
	
	public MainMenu() {
		super("Main Menu");
		
		createCity = new JButton("createCity");
		traveller = new JButton("traveller");
		buissnessTraveller = new JButton("buissnessTraveller");
		touristTraveller = new JButton("touristTraveller");
		printCities = new JButton("printCities");
		showTravellers = new JButton("showTravellers");
		quit = new JButton("quit");
		note = new JLabel("note: you must firtst create city and traveller before doing anything else!");
		
		createCity.addActionListener(this);
		traveller.addActionListener(this);
		buissnessTraveller.addActionListener(this);
		touristTraveller.addActionListener(this);
		printCities.addActionListener(this);
		showTravellers.addActionListener(this);
		quit.addActionListener(this);
		
		createCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		int i = 0;
		String[] buttons = { "create city", "Traveller", "buisiness Traveller", "tourist Traveller", "Print Cities", "Show travellers", "Quit" };    
		returnValue = JOptionPane.showOptionDialog(null, "Main Menu", "Narrative",
		        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[i]);
		System.out.println(returnValue);
		
		
		setLayout(new BorderLayout());
		
		//formPanel = new FormPanel();
		//add(formPanel, BorderLayout.WEST);
		
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(createCity, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(traveller, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(buissnessTraveller, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(touristTraveller, gc);

		gc.gridx = 0;
		gc.gridy = 4;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(printCities, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(showTravellers, gc);
		
		gc.gridx = 0;
		gc.gridy = 6;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(quit, gc);
		
		gc.gridx = 0;
		gc.gridy = 7;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(note);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if (clicked == createCity) {
			tmp = "1";
		} else if (clicked == traveller){
			tmp = "2";
		}else if (clicked == buissnessTraveller) {
			tmp = "3";
		}else if (clicked == touristTraveller) {
			tmp = "4";
		}else if (clicked == printCities) {
			tmp = "5";
		}else if (clicked == showTravellers) {
			tmp = "6";
		}else if (clicked == quit) {
			tmp = "7";
		}else {
			tmp = "wtf nigga";
		}
	}

	public static int getReturnValue() {
		return returnValue;
	}

	public static void setReturnValue(int returnValue) {
		MainMenu.returnValue = returnValue;
	}
	
	
}