package me.rtx4090;

import javax.swing.*;
import java.awt.*;

public class CaseTime {
    public JPanel CaseTime() {
        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setSize(500, 500);

        JLabel yearLabel1 = new JLabel("西元");
        JTextField yearField = new JTextField(4);
        JLabel yearLabel2 = new JLabel("年");

        JTextField monthField = new JTextField(2);
        JLabel monthLabel = new JLabel("月");

        JTextField dayField = new JTextField(2);
        JLabel dayLabel = new JLabel("日");

        JTextField hourField = new JTextField(2);
        JLabel hourLabel = new JLabel("時");

        JTextField minuteField = new JTextField(2);
        JLabel minuteLabel = new JLabel("分");

        panel.add(yearLabel1);
        panel.add(yearField);
        panel.add(yearLabel2);
        panel.add(monthField);
        panel.add(monthLabel);
        panel.add(dayField);
        panel.add(dayLabel);
        panel.add(hourField);
        panel.add(hourLabel);
        panel.add(minuteField);
        panel.add(minuteLabel);

        //panel.setBackground(Color.RED);
        panel.setVisible(true);

        return panel;

    }
}
