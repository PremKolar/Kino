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
    private boolean _success = false;

    /**
     * Initialisiert das PlatzVerkaufsWerkzeug.
     */
    public boolean BarVerkaufsWerkzeug(int currentPrice)
    {
        _currentPrice = currentPrice;
        _ui = new BarVerkaufsWerkszeugUI(_currentPrice);
        _ui.zeigeFenster();
        registriereUIAktionen();

        return _success;

    }

    /**
     * Fügt der UI die Funktionalität hinzu mit entsprechenden Listenern.
     */
    private void registriereUIAktionen()
    {
        _ui.getOKButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _success = true;
                }
            });

        _ui.getabbrechenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _success = false;
                }
            });

        _ui.getText()
            .addPropertyChangeListener("text", new PropertyChangeListener()
            {
                @Override
                public void propertyChange(PropertyChangeEvent evt)
                {
                    _bargeld = Integer.parseInt(evt.getPropertyName());
                }
            });
    }

    private int berechneRueckGeld(int currentPrice, int cashReceived)
    {

        int rueckgeld = cashReceived - currentPrice;
        return rueckgeld;

    }
}
