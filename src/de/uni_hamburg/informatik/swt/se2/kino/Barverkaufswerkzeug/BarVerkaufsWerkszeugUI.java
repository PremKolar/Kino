package de.uni_hamburg.informatik.swt.se2.kino.Barverkaufswerkzeug;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BarVerkaufsWerkszeugUI extends JPanel {
	private JTextField txtFgfg;

	/**
	 * Create the panel.
	 */
	public BarVerkaufsWerkszeugUI() {
		
		txtFgfg = new JTextField();
		txtFgfg.setText("fgfg");
		add(txtFgfg);
		txtFgfg.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);

	}

}
