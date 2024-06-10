package me.rtx4090.gui.tabs.profile;

import com.google.gson.Gson;
import me.rtx4090.Main;
import me.rtx4090.Profile;
import me.rtx4090.ProfileInUse;
import me.rtx4090.Profiles;
import me.rtx4090.gui.Notify;
import me.rtx4090.gui.*;
import me.rtx4090.gui.tabs.report.ReportPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ProfilePage {
    static Profiles profilesInstance = new Profiles();
    public static JPanel profilePanel = new JPanel();
    static JTextField profileNicknameField;
    static JTextField nameField;
    static JTextField idField;
    static JTextField emailField;
    static JTextField phoneField;
    static JTextField addressField;
    static JLabel hintLabel;
    static JButton createProfileButton;
    static JPanel existedProfilesPanel;

    public ProfilePage() {

        profilePanel.setLayout(new GridLayout(1, 2, 0, 0));
        profilePanel.setSize(800, 600);
        GridBagConstraints gbc = new GridBagConstraints();

        //left part
        JPanel createProfiles = new JPanel();
        createProfiles.setLayout(new GridBagLayout());
        {

            //upper part
            JPanel personalInfoInput = new JPanel();
            {
                personalInfoInput.setLayout(new GridBagLayout());
                personalInfoInput.setBackground(new Color(225, 235, 241));

                JLabel profileNicknameLabel = new JLabel("檔案名稱");
                setSizeLabel(profileNicknameLabel);
                JLabel nameLabel = new JLabel("姓名");
                setSizeLabel(nameLabel);
                JLabel idLabel = new JLabel("身分證字號");
                setSizeLabel(idLabel);
                JLabel emailLabel = new JLabel("電子郵件");
                setSizeLabel(emailLabel);
                JLabel phoneLabel = new JLabel("電話號碼");
                setSizeLabel(phoneLabel);
                JLabel addressLabel = new JLabel("地址");
                setSizeLabel(addressLabel);

                profileNicknameField = new JTextField();
                setTextField(profileNicknameField);
                nameField = new JTextField();
                setTextField(nameField);
                idField = new JTextField();
                setTextField(idField);
                emailField = new JTextField();
                setTextField(emailField);
                phoneField = new JTextField();
                setTextField(phoneField);
                addressField = new JTextField();
                setTextField(addressField);

                profileNicknameLabel.setHorizontalAlignment(SwingConstants.LEFT);
                nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
                idLabel.setHorizontalAlignment(SwingConstants.LEFT);
                emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
                phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
                addressLabel.setHorizontalAlignment(SwingConstants.LEFT);

                gbc.weighty = 0.2;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(0, 0, 5, 2);

                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 0.1;
                personalInfoInput.add(profileNicknameLabel, gbc);

                gbc.gridx = 1;
                gbc.weightx = 0.9;
                personalInfoInput.add(profileNicknameField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                personalInfoInput.add(nameLabel, gbc);

                gbc.gridx = 1;
                personalInfoInput.add(nameField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                personalInfoInput.add(idLabel, gbc);

                gbc.gridx = 1;
                personalInfoInput.add(idField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                personalInfoInput.add(emailLabel, gbc);

                gbc.gridx = 1;
                personalInfoInput.add(emailField, gbc);

                gbc.gridwidth = 1;
                gbc.gridx = 0;
                gbc.gridy = 4;
                personalInfoInput.add(phoneLabel, gbc);

                gbc.gridx = 1;
                personalInfoInput.add(phoneField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 5;
                personalInfoInput.add(addressLabel, gbc);

                gbc.gridx = 1;
                personalInfoInput.add(addressField, gbc);
            }

            hintLabel = new JLabel();
            hintLabel.setVisible(false);
            hintLabel.setHorizontalAlignment(JLabel.CENTER);
            createProfileButton = new JButton("新增檔案");
            createProfileButton.addActionListener(e -> {
                hintLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
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
            });
            createProfileButton.setBackground(new Color(0, 0, 255));
            createProfileButton.setFont(new Font("SimSun", Font.PLAIN, 18));
            createProfileButton.setForeground(new Color(225, 235, 241));
            //button blank
            JPanel buttonLeftBlankPanel = new JPanel();
            buttonLeftBlankPanel.setBackground(new Color(225, 235, 241));

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
        existedProfiles.setLayout(new FlowLayout());
        //whole scroll area
        JScrollPane scrollPane;
        {
            //https://youtu.be/OJSAnlzXRDk
            existedProfilesPanel = new JPanel();
            existedProfilesPanel.setLayout(new GridLayout(64, 1, 0, 2));
            // create panel for existed profiles
            {
                updateExistedProfilesPanel();


                //add panels to scroll area

            }
            scrollPane = new JScrollPane(existedProfilesPanel);
        }
        existedProfiles.add(scrollPane);
        existedProfiles.setBorder(BorderFactory.createLineBorder(Color.white, 5));

        profilePanel.add(createProfiles);

        profilePanel.add(scrollPane, gbc);

        profilePanel.setBackground(Color.black);
        profilePanel.setVisible(true);

    }

    static void addProfile(Profile profile, String nickname) {
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

    static void updateExistedProfilesPanel() {
        // Clear all components from the panel
        existedProfilesPanel.removeAll();

        // Add all profiles to the panel
        for (String key : profilesInstance.savedProfiles().keySet()) {
            JPanel jPanel = new JPanel();
            jPanel.setBackground(new Color(225, 235, 241));
            jPanel.setName(key);
            jPanel.setLayout(new GridLayout(1,3,0,0));

            // Add label
            JLabel nameLabel = new JLabel(key);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setPreferredSize(new Dimension(120,20));
            nameLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
            nameLabel.setBackground(new Color(225, 235, 241));
            nameLabel.setForeground(new Color(170, 106, 255));
            jPanel.add(nameLabel);

            // Add buttons
            JButton deleteButton = new JButton("刪除");
            deleteButton.setBackground(new Color(255,122,122));
            deleteButton.addActionListener(e -> deleteProfile(key));
            jPanel.add(deleteButton);

            JButton useButton = new JButton("使用");
            useButton.setBackground(new Color(122,255,122));
            useButton.addActionListener(e -> useProfile(key));
            jPanel.add(useButton);
            existedProfilesPanel.setBackground(new Color(225, 235, 241));
            existedProfilesPanel.add(jPanel);
        }

        // Refresh the panel
        existedProfilesPanel.revalidate();
        existedProfilesPanel.repaint();
    }

    static void deleteProfile(String nickname) {
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

    static void useProfile(String nickname) {
        Profile profile = profilesInstance.savedProfiles().get(nickname);
        ProfileInUse.setProfileInUse(profile, nickname);
        Notify.normal("使用中的檔案已切換為 " + nickname);

    }


    static boolean allTextfieldFilled() {
        return !nameField.getText().isEmpty() && !idField.getText().isEmpty() && !emailField.getText().isEmpty() && !phoneField.getText().isEmpty() && !addressField.getText().isEmpty();
    }


    static RoundBorder roundBorder = new RoundBorder(15, new Color(37, 150, 190));

    private static void setSizeLabel(JLabel label) {
        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width = metrics.stringWidth(label.getText());
        int height = metrics.getHeight();
        label.setPreferredSize(new Dimension(width, height));
        label.setForeground(new Color(170, 106, 255));
        label.setBackground(new Color(225, 235, 241));
        label.setOpaque(true);
        label.setBorder(roundBorder);
        label.setFont(new Font("SimSun", Font.PLAIN, 15));
    }

    private static void setTextField(JTextField textField) {
        textField.setBorder(roundBorder);
        textField.setForeground(new Color(170, 106, 255));
        textField.setFont(new Font("Dialog", Font.PLAIN, 18));
        textField.setBackground(new Color(225, 235, 241));
    }
}


