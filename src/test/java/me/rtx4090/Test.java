package me.rtx4090;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Frame");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        MyComboBox comboBox = new MyComboBox();
        comboBox.setBounds(250, 275, 300, 50);

        frame.add(comboBox);

        frame.setVisible(true);
    }
}
