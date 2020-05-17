package testGUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	private JLabel note;
	private JButton createCity;
	private JButton traveller;
	private JButton buissnessTraveller;
	private JButton touristTraveller;
	private JButton printCities;
	private JButton showTravellers;
	private JButton quit;
	
	private StringListener textListener;
	
	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
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
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(createCity);
		add(traveller);
		add(buissnessTraveller);
		add(touristTraveller);
		add(printCities);
		add(showTravellers);
		add(quit);
		add(note);
	}
	
	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if (clicked == createCity) {
			if (textListener != null) {
				textListener.textEmitted("hello\n");
			}
			//textPanel.appendText("hello\n");
		} else if (clicked == traveller){
			if (textListener != null) {
				textListener.textEmitted("goodbye\n");
			}
		}
	}
}
