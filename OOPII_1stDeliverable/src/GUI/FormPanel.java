package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
//import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JList;
import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.border.Border;



@SuppressWarnings("serial")
public class FormPanel extends JPanel implements ActionListener{
	
	private JButton createCity;
	private JButton traveller;
	private JButton buissnessTraveller;
	private JButton touristTraveller;
	private JButton printCities;
	private JButton showTravellers;
	private JButton quit;
	private JLabel note;
	
	private static String tmp;
	
	private FormPanel formPanel;
	
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250000;
		setPreferredSize(dim);
		
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
		
//		Border innerBorder = BorderFactory.createTitledBorder("Main Menu");
//		Border outerBorder = BorderFactory.createEtchedBorder();
//		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setBorder(BorderFactory.createTitledBorder("Main Menu"));
		
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
			new CreateCityNameGui();
		} else if (clicked == traveller){
			new TravellerGui();
		}else if (clicked == buissnessTraveller) {
			new BusinessTravellerGui();
		}else if (clicked == touristTraveller) {
			new TouristTravellerGui();
		}else if (clicked == printCities) {
			new PrintCitiesGui();
		}else if (clicked == showTravellers) {
			new ShowTravellersGui();
		}else if (clicked == quit) {
			
<<<<<<< 47d93fbe711bb96c5a074d8b1dcd612bd4e8b93e
		}else {fff
=======
		}else {
>>>>>>> commit gui
			
		}
	}

	public static String getTmp() {
		return tmp;
	}

	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	
	
	

}
