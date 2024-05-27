import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame {
    JPanel reportPage = new JPanel();
    JPanel profilePage = new JPanel();

    MainWindow() {
        this.setTitle("Taiwan Traffic Violation Reporting Integration Tool (TTVRIT) <alpha>");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);

        reportPage();
        profilePage();


        this.add(profilePage, BorderLayout.CENTER);


        this.setVisible(true);
    }

    void reportPage() {
        reportPage.setLayout(new FlowLayout());


    }

    void profilePage() {
        profilePage.setLayout(new GridBagLayout());
        profilePage.setSize(800, 600);
        GridBagConstraints gbc = new GridBagConstraints();

        //left part
        JPanel createProfiles = new JPanel();
        createProfiles.setLayout(new GridBagLayout());
        {

            //upper part
            JPanel personalInfoInput = new JPanel();
            {
                personalInfoInput.setLayout(new GridBagLayout());

                JPanel labelsPanel = new JPanel();
                labelsPanel.setLayout(new GridBagLayout());
                JPanel fieldsPanel = new JPanel();
                fieldsPanel.setLayout(new GridBagLayout());

                JLabel nameLabel = new JLabel("姓名");
                JLabel idLabel = new JLabel("身分證字號");
                JLabel emailLabel = new JLabel("電子郵件");
                JLabel phoneLabel = new JLabel("電話號碼");
                JLabel addressLabel = new JLabel("聯絡地址");

                JTextField nameField = new JTextField();
                JTextField idField = new JTextField();
                JTextField emailField = new JTextField();
                JTextField phoneField = new JTextField();
                JTextField addressField = new JTextField();

                gbc.weighty = 0.2;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridheight = 1;
                gbc.gridwidth = 1;

                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 0.3; // Set weightx to 0.3 for labels
                labelsPanel.add(nameLabel, gbc);
                gbc.gridy = 1;
                labelsPanel.add(idLabel, gbc);
                gbc.gridy = 2;
                labelsPanel.add(emailLabel, gbc);
                gbc.gridy = 3;
                labelsPanel.add(phoneLabel, gbc);
                gbc.gridy = 4;
                labelsPanel.add(addressLabel, gbc);

                gbc.gridy = 0;
                gbc.weightx = 0.7; // Set weightx to 0.7 for fields
                fieldsPanel.add(nameField, gbc);
                gbc.gridy = 1;
                fieldsPanel.add(idField, gbc);
                gbc.gridy = 2;
                fieldsPanel.add(emailField, gbc);
                gbc.gridy = 3;
                fieldsPanel.add(phoneField, gbc);
                gbc.gridy = 4;
                fieldsPanel.add(addressField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 0.3; // Set weightx to 0.3 for labelsPanel
                personalInfoInput.add(labelsPanel, gbc);
                gbc.gridx = 1;
                gbc.weightx = 0.7; // Set weightx to 0.7 for fieldsPanel
                personalInfoInput.add(fieldsPanel, gbc);
            }

            JLabel hintLabel = new JLabel("hello world, im the hint");
            hintLabel.setHorizontalAlignment(JLabel.CENTER);

            JButton createProfileButton = new JButton("新增");

            //button blank
            JPanel buttonLeftBlankPanel = new JPanel();


            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 10;
            gbc.weighty = 0.625;
            createProfiles.add(personalInfoInput, gbc);

            gbc.gridy = 10;
            gbc.gridheight = 2;
            gbc.weighty = 0.125;
            createProfiles.add(hintLabel, gbc);

            gbc.gridy = 12;
            gbc.gridheight = 3;
            gbc.weighty = 0.1875;
            createProfiles.add(createProfileButton, gbc);

            gbc.gridy = 15;
            gbc.gridheight = 8;
            gbc.weighty = 0.5;
            createProfiles.add(buttonLeftBlankPanel, gbc);


        }
        createProfiles.setBorder(BorderFactory.createLineBorder(Color.white, 5));


        //right part
        JPanel existedProfiles = new JPanel();
        existedProfiles.setBackground(Color.red);
        {

        }

        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5; // Set weightx to 0.5
        gbc.weighty = 1; // Set weighty to 1


        gbc.gridx = 0;
        profilePage.add(createProfiles, gbc);
        gbc.gridx = 1;
        profilePage.add(existedProfiles, gbc);

        profilePage.setBackground(Color.black);
        profilePage.setVisible(true);


    }
}
