package de.uni_hamburg.informatik.swt.se2.kino.Barverkaufswerkzeug;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarVerkaufsWerkszeugUI extends JPanel
{
    private JTextField _bargeldFeld;
    private JFrame _frame;
    private static final String TITEL = "Barzahlung";
    private JPanel _hauptPanel;
    private JButton _bezahlenButton;
    private JButton _stornierenButton;
    private JLabel _preisLabel;

    private int _rueckgeld;

    /**
     * Create the panel.
     */
    public BarVerkaufsWerkszeugUI(int currentPrice)
    {

        _bargeldFeld = new JTextField("hier Bargeld eingeben!");

        _frame = new JFrame(TITEL);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        _hauptPanel = erstellePanel(currentPrice);

        _frame.add(_hauptPanel);

    }

    private JPanel erstellePanel(int currentPrice)
    {

        JPanel panel = new JPanel();
        _bezahlenButton = new JButton("Verkaufen");
        _stornierenButton = new JButton("Stornieren");
        panel.add(_bezahlenButton);
        panel.add(_stornierenButton);

        //        panel.setLayout(new BorderLayout());
        //        //        panel.add(new JScrollPane(_platzplan), BorderLayout.CENTER);
        //
        //        //        JPanel southPanel = new JPanel(new BorderLayout());
        //        //        southPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,0));
        //        //        
        //        //        JPanel preisPanel = new JPanel(new BorderLayout());
        //        _preisLabel = new JLabel();
        //        panel.add(_preisLabel, BorderLayout.CENTER);
        //
        //        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //        _bezahlenButton = new JButton("Verkaufen");
        //        buttonPanel.add(_bezahlenButton);
        //        _stornierenButton = new JButton("Stornieren");
        //        buttonPanel.add(_stornierenButton);
        //
        //        panel.add(buttonPanel, BorderLayout.EAST);
        //
        //        _preisLabel.add(currentPrice);

        return panel;
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

    public JButton getOKButton()
    {
        return _bezahlenButton;
    }

    public JButton getAbbrechenButton()
    {
        return _stornierenButton;
    }

    public JTextField getText()
    {
        return _bargeldFeld;
    }

    public void setRueckGeld(int rueckgeld)
    {
        _rueckgeld = rueckgeld;
    }

}