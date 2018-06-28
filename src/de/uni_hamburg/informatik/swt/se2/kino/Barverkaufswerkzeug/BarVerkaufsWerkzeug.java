package de.uni_hamburg.informatik.swt.se2.kino.Barverkaufswerkzeug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class BarVerkaufsWerkzeug
{

    private BarVerkaufsWerkszeugUI _ui;
    private int _currentPrice;
    private int _bargeld;
    private int _rueckgeld;
    private boolean _success = false;

    /**
     * Initialisiert das BarVerkaufsWerkzeug.
     */
    public BarVerkaufsWerkzeug(int currentPrice)
    {
        _currentPrice = currentPrice;
        _ui = new BarVerkaufsWerkszeugUI(_currentPrice);
        registriereUIAktionen();
        _ui.get_dialog()
            .setVisible(true);
    }

    /**
     * Fügt der UI die Funktionalität hinzu mit entsprechenden Listenern.
     */
    private void registriereUIAktionen()
    {
        _ui.get_bezahlenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                	
                	if(_ui.getTextFieldLength() == 0)
                	{
                		
                	}
                	else
                	{
                	 _bargeld = Integer.parseInt(_ui.get_geldEingabe().getText());
                	}
                	if(_bargeld >= _currentPrice)
                	{
                	  _rueckgeld = _bargeld - _currentPrice;
                	  _success = true;
                	 _ui.get_dialog().dispose();
                	 JOptionPane.showMessageDialog(null, "Rueckgeld: " + _rueckgeld);
                	 
                	}

                }
            });

        _ui.get_abbrechenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.get_dialog()
                        .dispose();
                }
            });
        
        _ui.get_geldEingabe().addKeyListener(new KeyAdapter() {
        	
        	@Override
        	public void keyReleased(KeyEvent e) {
        		_ui.set_rueckgeld(berechneRueckGeld());
        	}
        	 
        	public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE ))
				{
					
					e.consume();
					
				}
				if(_ui.getTextFieldLength() > 6)
				{
					e.consume();
				}
		}});

    }

    public int berechneRueckGeld()
    {

        int rueckgeld = _ui.getTexFieldStringToInt() - _currentPrice;
        return rueckgeld;

    }

    public boolean verkaufErfolgreich()
    {
        return _success;
    }

}
