package me.rtx4090.gui.tabs.report;

import me.rtx4090.ProfileInUse;
import me.rtx4090.api.*;
import me.rtx4090.gui.Notify;
import org.jdesktop.swingx.JXPanel;

import javax.swing.*;
import javax.swing.JFileChooser;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public class ContentScrollPane {
    JPanel panel = new JPanel();
    public JScrollPane scrollPane = new JScrollPane(panel);

    private JTextField yearField;
    private JTextField minuteField;
    private JTextField hourField;
    private JTextField monthField;
    private JTextField dayField;
    private JTextField licenseNumField1;
    private JTextField licenseNumField2;
    private JTextField cityField;
    private JTextField roadField;
    private JTextField locationField;
    public Catalog catalog;
    public JButton submitButton;
    private JTextField reasonField;
    //private JTextField verifyField;
    private JButton data1Button;
    private JButton data2Button;
    private JButton data3Button;
    private JButton data4Button;
    private String data1Path;
    private String data2Path;
    private String data3Path;
    private String data4Path;
    private JLabel data1Label;
    private JLabel data2Label;
    private JLabel data3Label;
    private JLabel data4Label;
    private final boolean simulateSubmit = true;

    ContentScrollPane(String regionCode) {

        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submit());
        switch (regionCode) {
            case "KLU":
                catalog = new KLU();
                break;
            case "TPH":
                catalog = new TPH();
                break;
            case "TPE":
                catalog = new TPE();
                break;
            case "TYC":
                catalog = new TYC();
                break;
            case "HSH":
                catalog = new HSH();
                break;
            case "HSC":
                catalog = new HSC();
                break;
            case "MAL":
                catalog = new MAL();
                break;
            case "TXG":
                catalog = new TXG();
                break;
            case "CWH":
                catalog = new CWH();
                break;
            case "NTO":
                catalog = new NTO();
                break;
            case "YLH":
                catalog = new YLH();
                break;
            case "CHY":
                catalog = new CHY();
                break;
            case "CYI":
                catalog = new CYI();
                break;
            case "TNN":
                catalog = new TNN();
                break;
            case "KHH":
                catalog = new KHH();
                break;
            case "IUH":
                catalog = new IUH();
                break;
            case "ILN":
                catalog = new ILN();
                break;
            case "HWA":
                catalog = new HWA();
                break;
            case "TTT":
                catalog = new TTT();
                break;
            case "PEH":
                catalog = new PEH();
                break;
            case "KMN":
                catalog = new KMN();
                break;
            case "LNN":
                catalog = new LNN();
                break;
            case "DEFAULT":
                catalog = new Empty();
                break;
            default:
                throw new IllegalArgumentException("Invalid region code: " + regionCode);

        }
        try {
            setupGUI();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }

    void setupGUI() throws MalformedURLException {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel profileInUse = new JLabel("目前使用身分：" + ProfileInUse.profileNickname);

/*        WebElement imgElement = eDriver.findElement(By.className("captcha_img"));
        String imgSrc = imgElement.getAttribute("src");
        ImageIcon verifyImage = new ImageIcon(new URL(imgSrc));
        JLabel verifyImageLabel = new JLabel(verifyImage);*/

        panel.add(profileInUse);
        panel.add(caseTime());
        panel.add(licenseNum());
        panel.add(location());
        panel.add(reason());
        // panel.add(verifyImageLabel);
        // panel.add(verify());
        panel.add(fileSelector());

        panel.add(submitButton);
    }

    JPanel caseTime() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel yearLabel1 = new JLabel("西元");
        yearField = new JTextField(4);
        JLabel yearLabel2 = new JLabel("年");

        monthField = new JTextField(2);
        JLabel monthLabel = new JLabel("月");

        dayField = new JTextField(2);
        JLabel dayLabel = new JLabel("日");

        hourField = new JTextField(2);
        JLabel hourLabel = new JLabel("時");

        minuteField = new JTextField(2);
        JLabel minuteLabel = new JLabel("分");

        LocalDateTime now = LocalDateTime.now();
        yearField.setText(String.valueOf(now.getYear()));
        monthField.setText(String.valueOf(now.getMonthValue()));
        dayField.setText(String.valueOf(now.getDayOfMonth()));
        hourField.setText(String.valueOf(now.getHour()));
        minuteField.setText(String.valueOf(now.getMinute()));

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

        return panel;

    }

    JPanel licenseNum() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel licenseNumLabel = new JLabel("車牌號碼：");
        licenseNumField1 = new JTextField(3);
        JLabel licenseNumFieldDash = new JLabel("-");
        licenseNumField2 = new JTextField(4);

        panel.add(licenseNumLabel);
        panel.add(licenseNumField1);
        panel.add(licenseNumFieldDash);
        panel.add(licenseNumField2);

        return panel;
    }

    JPanel location() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel upper = new JPanel();
        JPanel lower = new JPanel();
        upper.setLayout(new BoxLayout(upper, BoxLayout.X_AXIS));
        lower.setLayout(new BoxLayout(lower, BoxLayout.X_AXIS));

        JLabel cityLabel = new JLabel("鄉鎮市區：");
        cityField = new JTextField(3);
        JLabel road = new JLabel("街道：");
        roadField = new JTextField(4);

        upper.add(cityLabel);
        upper.add(cityField);
        upper.add(road);
        upper.add(roadField);

        JLabel locationLabel = new JLabel("路段 / 號 / 說明：");
        locationField = new JTextField(10);
        lower.add(locationLabel);
        lower.add(locationField);

        panel.add(upper);
        panel.add(lower);
        return panel;
    }

    JPanel reason() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel reasonLabel = new JLabel("違規事由：");
        reasonField = new JTextField();
        panel.add(reasonLabel);
        panel.add(reasonField);

        return panel;
    }
    JPanel fileSelector() {
        JXPanel panel = new JXPanel();

        data1Label = new JLabel("檔案1：");
        data2Label = new JLabel("檔案2：");
        data3Label = new JLabel("檔案3：");
        data4Label = new JLabel("檔案4：");
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        labelsPanel.add(data1Label);
        labelsPanel.add(data2Label);
        labelsPanel.add(data3Label);
        labelsPanel.add(data4Label);

        data1Button = new JButton("選擇檔案");
        data2Button = new JButton("選擇檔案");
        data3Button = new JButton("選擇檔案");
        data4Button = new JButton("選擇檔案");
        data1Button.addActionListener(e -> selectFile(1));
        data2Button.addActionListener(e -> selectFile(2));
        data3Button.addActionListener(e -> selectFile(3));
        data4Button.addActionListener(e -> selectFile(4));
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.add(data1Button);
        buttonsPanel.add(data2Button);
        buttonsPanel.add(data3Button);
        buttonsPanel.add(data4Button);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(labelsPanel);
        panel.add(buttonsPanel);

        return panel;
    }

/*    JPanel verify() throws MalformedURLException {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel verifyLabel = new JLabel("驗證碼：");
        verifyField = new JTextField();

        panel.add(verifyLabel);
        panel.add(verifyField);

        return panel;
    }*/

    private void selectFile(int dataIndex) {
        Frame parent = new Frame();
        FileDialog fileDialog = new FileDialog(parent, "選擇檔案", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String selectedFile = fileDialog.getFile();
        if (selectedFile != null) {
            String directory = fileDialog.getDirectory();
            String path = directory + selectedFile;
            switch (dataIndex) {
                case 1:
                    data1Path = path;
                    data1Label.setText("檔案1：" + selectedFile);
                    break;
                case 2:
                    data2Path = path;
                    data2Label.setText("檔案2：" + selectedFile);
                    break;
                case 3:
                    data3Path = path;
                    data3Label.setText("檔案3：" + selectedFile);
                    break;
                case 4:
                    data4Path = path;
                    data4Label.setText("檔案4：" + selectedFile);
                    break;
            }
            System.out.println("Selected file path: " + path);  // Log the selected file path
        }
        parent.dispose();
    }

    boolean allFilled() {
        if (ProfileInUse.profileNickname != null && yearField.getText() != null && monthField.getText() != null && dayField.getText() != null && hourField.getText() != null && minuteField.getText() != null && licenseNumField1.getText() != null && licenseNumField2.getText() != null && cityField.getText() != null && roadField.getText() != null && locationField.getText() != null && reasonField.getText() != null) {
            return true;
        } else {
            return false;
        }
    }
    boolean fileSelected() {
        if (data1Path != null || data2Path != null || data3Path != null || data4Path != null) {
            return true;
        } else {
            return false;
        }
    }

    void submit() {
        if (allFilled() && fileSelected()) {

            String caseDate = yearField.getText() + "-" + monthField.getText() + "-" + dayField.getText();
            String caseHour = hourField.getText();
            if (caseHour.length() == 1) {
                caseHour = "0" + caseHour;
            }
            String caseMinute = minuteField.getText();
            if (caseMinute.length() == 1) {
                caseMinute = "0" + caseMinute;
            }
            String licenceNum = licenseNumField1.getText() + "-" + licenseNumField2.getText();
            //String verifyCode = verifyField.getText();

            if (simulateSubmit) {
                System.out.println("Submitted");
            } else {
                catalog.send(ProfileInUse.profileInUse.getName(),ProfileInUse.getProfileInUse().getId(), ProfileInUse.getProfileInUse().getNumber(), ProfileInUse.getProfileInUse().getEmail(), ProfileInUse.getProfileInUse().getAddress(),
                        caseDate, caseHour, caseMinute,
                        licenceNum, cityField.getText(), roadField.getText(), locationField.getText(), reasonField.getText(),
                        data1Path, data2Path, data3Path, data4Path);

            }

        } else if (!allFilled() && fileSelected()) {
            Notify.error("請先將所有欄位填寫完畢。");
        } else if (allFilled() && !fileSelected()) {
            Notify.error("請選擇檔案。");
        } else {
            Notify.error("請先將所有欄位填寫完畢並選擇檔案。");
        }

    }
}