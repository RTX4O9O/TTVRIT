package me.rtx4090;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CaseTime CaseTime = new CaseTime();
        JPanel panel = CaseTime.CaseTime();
        panel.setBounds(50, 50, 400, 400); // Set the position and size of the panel
        frame.add(panel);

        frame.setVisible(true);
    }
}