package de.uni_hamburg.informatik.swt.se2.kino.Barverkaufswerkzeug;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarVerkaufsWerkszeugUI extends JPanel
{
    private JTextField txtFgfg;
    private JFrame _frame;
    private static final String TITEL = "Barzahlung";
    private JPanel _hauptPanel;
    private JButton _bezahlenButton;
    private JButton _stornierenButton;
    private JLabel _preisLabel;

    /**
     * Create the panel.
     */
    public BarVerkaufsWerkszeugUI(int currentPrice)
    {

        _frame = new JFrame(TITEL);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        _hauptPanel = erstellePanel(currentPrice);

        _frame.add(_hauptPanel);

        //        txtFgfg = new JTextField();
        //        txtFgfg.setText("fgfg");
        //        topPanel.add(txtFgfg);
        //        txtFgfg.setColumns(10);
        //
        //        JLabel lblNewLabel = new JLabel("New label");
        //        add(lblNewLabel);

    }

    private JPanel erstellePanel(int currentPrice)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //        panel.add(new JScrollPane(_platzplan), BorderLayout.CENTER);

        //        JPanel southPanel = new JPanel(new BorderLayout());
        //        southPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,0));
        //        
        //        JPanel preisPanel = new JPanel(new BorderLayout());
        _preisLabel = new JLabel();
        panel.add(_preisLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        _bezahlenButton = new JButton("Verkaufen");
        buttonPanel.add(_bezahlenButton);
        _stornierenButton = new JButton("Stornieren");
        buttonPanel.add(_stornierenButton);

        panel.add(buttonPanel, BorderLayout.EAST);

        _preisLabel.add(currentPrice);

        return panel;
    }

    private JTextField makeTextFeld()
    {
        JTextField feld = new JTextField("hier Betrag eingeben");
        return feld;
    }

    private int textfeldToInt(JTextField feld)
    {
        String text = feld.getText();
        int geldInCents = Integer.parseInt(text);
        return geldInCents;
    }

    //    
    //    
    //    String strV0TextBox = v0TextField.getText();   
    //
    //    double initialvelocity = Double.parseDouble(strV0TextField);
    //    
    //    

    private int berechneRueckGeld(int currentPrice, int cashReceived)
    {

        int rueckgeld = cashReceived - currentPrice;
        return rueckgeld;

    }

    public void zeigeFenster()
    {
        _frame.setSize(600, 500);
        _frame.setVisible(true);
    }

    public void schliesseFenster()
    {
        _frame.dispose();
    }

}