import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class MainWindow extends JFrame implements ActionListener {
    JPanel reportPage = new JPanel();
    JPanel profilePage = new JPanel();
    Profiles profilesInstance = new Profiles();
    JButton createProfileButton;
    JTextField profileNicknameField;
    JTextField nameField;
    JTextField idField;
    JTextField emailField;
    JTextField phoneField;
    JTextField addressField;
    JLabel hintLabel;
    JPanel existedProfilesPanel;

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
        profilePage.setLayout(new GridLayout(1, 2, 0, 0));
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

                JLabel profileNicknameLabel = new JLabel("檔案名稱");
                JLabel nameLabel = new JLabel("姓名");
                JLabel idLabel = new JLabel("身分證字號");
                JLabel emailLabel = new JLabel("電子郵件");
                JLabel phoneLabel = new JLabel("電話號碼");
                JLabel addressLabel = new JLabel("聯絡地址");

                profileNicknameField = new JTextField();
                nameField = new JTextField();
                idField = new JTextField();
                emailField = new JTextField();
                phoneField = new JTextField();
                addressField = new JTextField();

                gbc.weighty = 0.2;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridheight = 1;
                gbc.gridwidth = 1;

                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 0.3; // Set weightx to 0.3 for labels
                labelsPanel.add(profileNicknameLabel, gbc);
                gbc.gridy = 1;
                labelsPanel.add(nameLabel, gbc);
                gbc.gridy = 2;
                labelsPanel.add(idLabel, gbc);
                gbc.gridy = 3;
                labelsPanel.add(emailLabel, gbc);
                gbc.gridy = 4;
                labelsPanel.add(phoneLabel, gbc);
                gbc.gridy = 5;
                labelsPanel.add(addressLabel, gbc);

                gbc.gridy = 0;
                gbc.weightx = 0.7; // Set weightx to 0.7 for fields
                fieldsPanel.add(profileNicknameField, gbc);
                gbc.gridy = 1;
                fieldsPanel.add(nameField, gbc);
                gbc.gridy = 2;
                fieldsPanel.add(idField, gbc);
                gbc.gridy = 3;
                fieldsPanel.add(emailField, gbc);
                gbc.gridy = 4;
                fieldsPanel.add(phoneField, gbc);
                gbc.gridy = 5;
                fieldsPanel.add(addressField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 0.3; // Set weightx to 0.3 for labelsPanel
                personalInfoInput.add(labelsPanel, gbc);
                gbc.gridx = 1;
                gbc.weightx = 0.7; // Set weightx to 0.7 for fieldsPanel
                personalInfoInput.add(fieldsPanel, gbc);
            }

            hintLabel = new JLabel();
            hintLabel.setVisible(false);
            hintLabel.setHorizontalAlignment(JLabel.CENTER);

            createProfileButton = new JButton("新增");
            createProfileButton.addActionListener(this);

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
        existedProfiles.setLayout(new FlowLayout());
        //whole scroll area
        JScrollPane scrollPane;
        {
            //https://youtu.be/OJSAnlzXRDk
            existedProfilesPanel = new JPanel();
            existedProfilesPanel.setLayout(new GridLayout(64, 1, 0, 2));
            // create panel for existed profiles
            {

                for (String key : profilesInstance.savedProfiles().keySet()) {
                    JPanel jPanel = new JPanel();
                    jPanel.setName(key);
                    jPanel.setLayout(new GridBagLayout());
                    gbc.fill = GridBagConstraints.HORIZONTAL;

                    //add label
                    JLabel nameLabel = new JLabel(key);
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.gridwidth = 4;
                    gbc.weightx = 0.4;
                    jPanel.add(nameLabel, gbc);

                    //add buttons
                    JButton deleteButton = new JButton("刪除");
                    deleteButton.setBackground(Color.RED);
                    deleteButton.addActionListener(e -> deleteProfile(key));
                    gbc.gridx = 4;
                    gbc.gridwidth = 1;
                    gbc.weightx = 0.1;
                    jPanel.add(deleteButton, gbc);

                    JButton useButton = new JButton("使用");
                    useButton.setBackground(Color.GREEN);
                    useButton.addActionListener(e -> useProfile(key));
                    gbc.gridx = 5;
                    gbc.gridwidth = 1;
                    gbc.weightx = 0.1;
                    jPanel.add(useButton, gbc);

                    existedProfilesPanel.add(jPanel);
                }


                //add panels to scroll area

            }
            scrollPane = new JScrollPane(existedProfilesPanel);
        }
        existedProfiles.add(scrollPane);
        existedProfiles.setBorder(BorderFactory.createLineBorder(Color.white, 5));

        /*gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5; // Set weightx to 0.5
        gbc.weighty = 1; // Set weighty to 1*/


        //gbc.gridx = 0;
        profilePage.add(createProfiles);
        //gbc.gridx = 1;
        profilePage.add(scrollPane, gbc);

        profilePage.setBackground(Color.black);
        profilePage.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //hide hint when labels are clear
        if (e.getSource() == profileNicknameField || e.getSource() == nameField || e.getSource() == idField || e.getSource() == emailField || e.getSource() == phoneField || e.getSource() == addressField) {
            if (!allTextfieldFilled()) {
                hintLabel.setVisible(false);
            }
        }
        //create profile
        if (e.getSource() == createProfileButton) {

            if (allTextfieldFilled()) {

                Profile profile = new Profile(nameField.getText(), idField.getText(), emailField.getText(), phoneField.getText(), addressField.getText());
                addProfile(profile, profileNicknameField.getText());
                hintLabel.setText("新增成功");
                hintLabel.setVisible(true);
                nameField.setText("");
                idField.setText("");
                emailField.setText("");
                phoneField.setText("");
                addressField.setText("");

            } else {
                if (nameField.getText().isEmpty()) {
                    hintLabel.setText("請輸入姓名");
                    hintLabel.setVisible(true);
                } else if (idField.getText().isEmpty()) {
                    hintLabel.setText("請輸入身分證字號");
                    hintLabel.setVisible(true);
                } else if (emailField.getText().isEmpty()) {
                    hintLabel.setText("請輸入電子郵件");
                    hintLabel.setVisible(true);
                } else if (phoneField.getText().isEmpty()) {
                    hintLabel.setText("請輸入電話號碼");
                    hintLabel.setVisible(true);
                } else if (addressField.getText().isEmpty()) {
                    hintLabel.setText("請輸入聯絡地址");
                    hintLabel.setVisible(true);
                }
            }
        }

    }

    boolean allTextfieldFilled() {
        return !nameField.getText().isEmpty() && !idField.getText().isEmpty() && !emailField.getText().isEmpty() && !phoneField.getText().isEmpty() && !addressField.getText().isEmpty();
    }

    void addProfile(Profile profile, String nickname) {
        if (nickname.isEmpty()) {
            int profileCount = profilesInstance.savedProfiles().size();
            nickname = "Profile " + profileCount;
        }

        //加入到profileInstance
        Map<String, Profile> profiles = profilesInstance.savedProfiles();
        profiles.put(nickname, profile);
        //覆寫入json
        Gson gson = new Gson();
        String json = gson.toJson(profiles);
        try {
            Files.write(Paths.get(profilesInstance.jsonProfiles.getPath()), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            Notify.error(e.getMessage());
        }
        updateExistedProfilesPanel();
    }

    void updateExistedProfilesPanel() {
        // Clear all components from the panel
        existedProfilesPanel.removeAll();

        // Add all profiles to the panel
        for (String key : profilesInstance.savedProfiles().keySet()) {
            JPanel jPanel = new JPanel();
            jPanel.setName(key);
            jPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // Add label
            JLabel nameLabel = new JLabel(key);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 4;
            gbc.weightx = 0.4;
            jPanel.add(nameLabel, gbc);

            // Add buttons
            JButton deleteButton = new JButton("刪除");
            deleteButton.setBackground(Color.RED);
            deleteButton.addActionListener(e -> deleteProfile(key));
            gbc.gridx = 4;
            gbc.gridwidth = 1;
            gbc.weightx = 0.1;
            jPanel.add(deleteButton, gbc);

            JButton useButton = new JButton("使用");
            useButton.setBackground(Color.GREEN);
            useButton.addActionListener(e -> useProfile(key));
            gbc.gridx = 5;
            gbc.gridwidth = 1;
            gbc.weightx = 0.1;
            jPanel.add(useButton, gbc);

            existedProfilesPanel.add(jPanel);
        }

        // Refresh the panel
        existedProfilesPanel.revalidate();
        existedProfilesPanel.repaint();
    }
    void deleteProfile(String nickname) {
        //delete from profileInstance
        Map<String, Profile> profiles = profilesInstance.savedProfiles();
        profiles.remove(nickname);
        //覆寫入json
        Gson gson = new Gson();
        String json = gson.toJson(profiles);
        try {
            Files.write(Paths.get(profilesInstance.jsonProfiles.getPath()), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            Notify.error(e.getMessage());
        }

        updateExistedProfilesPanel();
    }
    void useProfile(String nickname) {

    }

}
