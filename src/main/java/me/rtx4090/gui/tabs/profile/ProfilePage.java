package me.rtx4090.gui.tabs.profile;

import com.google.gson.Gson;
import me.rtx4090.Profile;
import me.rtx4090.Profiles;
import me.rtx4090.gui.Notify;
import me.rtx4090.gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ProfilePage implements ActionListener{
    Profiles profilesInstance = new Profiles();
    public JPanel profilePanel = new JPanel();
    JTextField profileNicknameField;
    JTextField nameField;
    JTextField idField;
    JTextField emailField;
    JTextField phoneField;
    JTextField addressField;
    JLabel hintLabel;
    JButton createProfileButton;
    JPanel existedProfilesPanel;
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
                personalInfoInput.setBackground(new Color(225,235,241));
                //JPanel labelsPanel = new JPanel();
                //labelsPanel.setLayout(new FlowLayout());
                //JPanel fieldsPanel = new JPanel();
                //fieldsPanel.setLayout(new GridBagLayout());

                JLabel profileNicknameLabel = new JLabel("檔案名稱");
                setsizelable(profileNicknameLabel);
                JLabel nameLabel = new JLabel("姓名");
                setsizelable(nameLabel);
                JLabel idLabel = new JLabel("身分證字號");
                setsizelable(idLabel);
                JLabel emailLabel = new JLabel("電子郵件");
                setsizelable(emailLabel);
                JLabel phoneLabel = new JLabel("電話號碼");
                setsizelable(phoneLabel);
                JLabel addressLabel = new JLabel("地址");
                setsizelable(addressLabel);

                profileNicknameField = new JTextField();
                setextfield(profileNicknameField);
                nameField = new JTextField();
                setextfield(nameField);
                idField = new JTextField();
                setextfield(idField);
                emailField = new JTextField();
                setextfield(emailField);
                phoneField = new JTextField();
                setextfield(phoneField);
                addressField = new JTextField();
                setextfield(addressField);
                /////////////////////////////////////////////////
                profileNicknameLabel.setHorizontalAlignment(SwingConstants.LEFT);
                nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
                idLabel.setHorizontalAlignment(SwingConstants.LEFT);
                emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
                phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
                addressLabel.setHorizontalAlignment(SwingConstants.LEFT);

                /////////////////////////////////////////

                gbc.weighty = 0.2;
                gbc.fill = GridBagConstraints.BOTH;
                //gbc.gridheight = 1;
                //gbc.gridwidth = 1;

                //////////////////
                gbc.weighty = 0.2;
                gbc.fill = GridBagConstraints.BOTH;
                //gbc.gridheight = 1;
                //gbc.gridwidth = 1;
                gbc.insets = new Insets(0,0,5,2);
                //////////////////

                gbc.gridx=0;
                gbc.gridy=0;
                gbc.weightx=0.1;
                personalInfoInput.add(profileNicknameLabel,gbc);

                gbc.gridx=1;
                gbc.weightx=0.9;
                personalInfoInput.add(profileNicknameField,gbc);
///////////////////////////////////////////////////////////////////

                gbc.gridx=0;
                gbc.gridy=1;
                personalInfoInput.add(nameLabel,gbc);

                gbc.gridx=1;
                personalInfoInput.add(nameField,gbc);
                /////////////////////////////////////////
                gbc.gridx=0;
                gbc.gridy=2;
                personalInfoInput.add(idLabel,gbc);

                gbc.gridx=1;
                personalInfoInput.add(idField,gbc);

                ////////////////////////////////////////////
                gbc.gridx=0;
                gbc.gridy=3;
                personalInfoInput.add(emailLabel,gbc);

                gbc.gridx=1;
                personalInfoInput.add(emailField,gbc);
                ////////////////////////////
                gbc.gridwidth=1;
                gbc.gridx=0;
                gbc.gridy=4;
                personalInfoInput.add(phoneLabel,gbc);

                gbc.gridx=1;
                personalInfoInput.add(phoneField,gbc);
                ////////////////////////////////////////////
                gbc.gridx=0;
                gbc.gridy=5;
                personalInfoInput.add(addressLabel,gbc);

                gbc.gridx=1;
                personalInfoInput.add(addressField,gbc);
            }
            //提示介面與新增按鈕
            hintLabel = new JLabel();
            hintLabel.setVisible(false);
            hintLabel.setHorizontalAlignment(JLabel.CENTER);
            createProfileButton = new JButton("新增檔案");
            createProfileButton.addActionListener(this);
            createProfileButton.setBackground(new Color(0,0,255));
            createProfileButton.setFont(new Font("SimSun", Font.PLAIN, 18));
            createProfileButton.setForeground(new Color(225,235,241));
            //button blank
            JPanel buttonLeftBlankPanel = new JPanel();
            buttonLeftBlankPanel.setBackground(new Color(225,235,241));

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
        createProfiles.setBackground(new Color(225,235,241));



        //right part/////////////////////////////////////////////////////////
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
        profilePanel.add(createProfiles);
        //gbc.gridx = 1;
        profilePanel.add(scrollPane, gbc);

        profilePanel.setBackground(Color.black);
        profilePanel.setVisible(true);


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


    boolean allTextfieldFilled() {
        return !nameField.getText().isEmpty() && !idField.getText().isEmpty() && !emailField.getText().isEmpty() && !phoneField.getText().isEmpty() && !addressField.getText().isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //create profile
        if (e.getSource() == createProfileButton) {
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
        }
    }

    ////////////////////////////////////////////////////////////////////
    RoundBorder roundBorder = new RoundBorder(15,new Color(37, 150, 190));
    private  void setsizelable(JLabel label){
        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width = metrics.stringWidth(label.getText());
        int height = metrics.getHeight();
        label.setPreferredSize(new Dimension(width, height));
        label.setForeground(new Color(170,106,255));
        label.setBackground(new Color(225,235,241));
        label.setOpaque(true);
        label.setBorder(roundBorder);
        label.setFont(new Font("SimSun", Font.PLAIN, 15));
    }

    private  void setextfield(JTextField textField) {
        textField.setBorder(roundBorder);
        textField.setForeground(new Color(170,106,255));
        textField.setFont(new Font("Dialog", Font.PLAIN, 18));
        textField.setBackground(new Color(225,235,241));
    }
}


