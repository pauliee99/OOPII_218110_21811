


import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import weather.Main;

public class CreateCityNameGui extends JFrame {
	
	private JLabel cityNameLbl;
	private JTextField cityNameTxt;
	private JButton okBtn;
	private static String tmp;
	
	private String cityName;
	private String countryName;
	
	public CreateCityNameGui() {
		super("Create City");
		
		setLayout(new BorderLayout());
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		cityNameLbl = new JLabel("give the city you want to visit: ");
		cityNameTxt = new JTextField(10);
		okBtn = new JButton("OK");
		
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action(e);
			}
		});

		
		
		////////first row/////////////////////////
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END; //allignment
		gc.insets = new Insets(0, 0, 0, 5);
		add(cityNameLbl);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_END;
		add(cityNameTxt);
		
		////////second row/////////////////////////
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridy = 3;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);
		
		
	}
	
	public void action(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		if (clicked == okBtn) {
			System.out.println(cityNameTxt.getText());
			//tmp = cityNameTxt.getText();
		}else {
			// null;
		}
		
	}

	public String getTmp() {
		return tmp;
	}

	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	
	
			
}
