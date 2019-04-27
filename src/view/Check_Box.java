package view;


import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class Check_Box extends JCheckBox implements ListCellRenderer {
    public Check_Box() {
        super();
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        this.setText(value.toString());
        setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
        this.setSelected(isSelected);
        return this;
    }
}