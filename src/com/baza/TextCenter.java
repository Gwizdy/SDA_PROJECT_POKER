package com.baza;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TextCenter implements TableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof JLabel) {
            JLabel lab = (JLabel) value;
            lab.setHorizontalAlignment(JLabel.CENTER);
            return lab;
        } else if (value instanceof Component) {
            return (Component) value;
        }
        return new JLabel(String.valueOf(value), JLabel.CENTER);
    }
}
