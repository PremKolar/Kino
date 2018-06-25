package de.uni_hamburg.informatik.swt.se2.kino.Barverkaufswerkzeug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
                    _success = true;
                }
            });

        _ui.get_abbrechenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                	_ui.get_dialog().dispose();
                    _success = false;
                }
            });

        _ui.get_geldEingabe()
            .addPropertyChangeListener("text", new PropertyChangeListener()
            {
                @Override
                public void propertyChange(PropertyChangeEvent evt)
                {
                    _bargeld = Integer.parseInt(evt.getPropertyName());
                    _rueckgeld = berechneRueckGeld(_currentPrice, _bargeld);
                    _ui.set_rueckgeld(_rueckgeld);
                }
            });
        
        
    }

    private int berechneRueckGeld(int currentPrice, int cashReceived)
    {

        int rueckgeld = cashReceived - currentPrice;
        return rueckgeld;

    }

    public boolean verkaufErfolgreich()
    {
        return _success;
    }

}
