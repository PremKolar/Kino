package de.uni_hamburg.informatik.swt.se2.kino.Barverkaufswerkzeug;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@FunctionalInterface
public interface SimpleDocumentListener extends DocumentListener
{
    @Override
    void insertUpdate(DocumentEvent e);

    @Override
    void removeUpdate(DocumentEvent e);

    @Override
    void changedUpdate(DocumentEvent e);
}