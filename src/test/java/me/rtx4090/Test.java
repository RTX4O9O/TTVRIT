package me.rtx4090;


import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textField = new JTextField(4);
        textField.setBounds(50, 50, 100, 30);
        frame.add(textField);

        frame.setVisible(true);


    }

}