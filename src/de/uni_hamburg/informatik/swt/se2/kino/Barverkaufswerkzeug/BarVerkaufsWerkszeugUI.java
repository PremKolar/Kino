package de.uni_hamburg.informatik.swt.se2.kino.Barverkaufswerkzeug;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarVerkaufsWerkszeugUI
{
    private JTextField _geldEingabe;
    private JFrame _frame;
    private JDialog _dialog;

    private JPanel _buttonpanel;
    private JPanel _preisAnzeigepanel;
    private JPanel _preisEingabepanel;
    private JPanel _restBetragpanel;

    private JButton _bezahlenButton;
    private JButton _abbrechenButton;

    private JLabel _preisLabel;
    private JLabel _textLabel;
    private JLabel _rueckGeldLabel;

    private int _rueckgeld;

    /**
     * Create the panel.
     */
    public BarVerkaufsWerkszeugUI(int currentPrice)
    {
        _dialog = new JDialog();
        _dialog.setModal(true);
        _dialog.setTitle("Barzahlung");
        _dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        _dialog.setLayout(new BoxLayout(_dialog.getContentPane(),
                BoxLayout.Y_AXIS));

        _bezahlenButton = new JButton("Bezahlen");
        _abbrechenButton = new JButton("Abbrechen");
        _buttonpanel = new JPanel();
        _buttonpanel.add(_bezahlenButton);
        _buttonpanel.add(_abbrechenButton);

        _preisLabel = new JLabel();
        _preisLabel.setText(centsIntToEuroString(currentPrice));
        _preisLabel.setFont(new Font("Courier New", Font.ITALIC, 10));
        _preisLabel.setFont(_preisLabel.getFont()
            .deriveFont(30f));
        _textLabel = new JLabel();
        _textLabel.setText("Zu zahlender Betrag:   ");
        _preisAnzeigepanel = new JPanel();
        _preisAnzeigepanel.add(_textLabel);
        _preisAnzeigepanel.add(_preisLabel);

        _preisEingabepanel = new JPanel();
        _geldEingabe = new JTextField(20);
        _preisEingabepanel.add(_geldEingabe);

        _restBetragpanel = new JPanel();
        _rueckGeldLabel = new JLabel();
        _rueckGeldLabel.setText("Rückgeld :   "
                + centsIntToEuroString(_rueckgeld));
        _restBetragpanel.add(_rueckGeldLabel);

        _dialog.add(_preisAnzeigepanel);
        _dialog.add(_preisEingabepanel);
        _dialog.add(_restBetragpanel);
        _dialog.add(_buttonpanel);

        _dialog.pack();
        //        _dialog.setVisible(true);

    }

    public JDialog get_dialog()
    {
        return _dialog;
    }

    public JTextField get_geldEingabe()
    {
        return _geldEingabe;
    }

    public JButton get_bezahlenButton()
    {
        return _bezahlenButton;
    }

    public JButton get_abbrechenButton()
    {
        return _abbrechenButton;
    }

    public JLabel get_textLabel()
    {
        return _textLabel;
    }

    public int get_rueckgeld()
    {
        return _rueckgeld;
    }

    public JLabel get_rueckgeldlabel()
    {
        return _rueckGeldLabel;
    }

    public void set_rueckgeld(int rueckgeld)
    {
        _rueckgeld = rueckgeld;

        _rueckGeldLabel.setText("Rückgeld :   "
                + centsIntToEuroString(_rueckgeld));
    }

    public String centsIntToEuroString(int cents)
    {
        return String.format("€%.2f", ((double) cents) / 100);
    }

}