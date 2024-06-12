package me.rtx4090.gui.tabs.report;

import me.rtx4090.ProfileInUse;
import me.rtx4090.api.*;
import me.rtx4090.gui.Notify;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public class ContentScrollPane {
    JPanel panel = new JPanel();
    public JScrollPane scrollPane = new JScrollPane(panel);

    Driver driver = new Driver();
    WebDriver eDriver = driver.edgeDriver;
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
    private JTextField verifyField;

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

        WebElement imgElement = eDriver.findElement(By.className("captcha_img"));
        String imgSrc = imgElement.getAttribute("src");
        ImageIcon verifyImage = new ImageIcon(new URL(imgSrc));
        JLabel verifyImageLabel = new JLabel(verifyImage);

        panel.add(profileInUse);
        panel.add(caseTime());
        panel.add(licenseNum());
        panel.add(location());
        panel.add(reason());
        panel.add(verifyImageLabel);
        panel.add(verify());

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

    JPanel verify() throws MalformedURLException {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel verifyLabel = new JLabel("驗證碼：");
        verifyField = new JTextField();

        panel.add(verifyLabel);
        panel.add(verifyField);

        return panel;
    }

    boolean allFilled() {
        if (ProfileInUse.profileNickname != null && yearField.getText() != null && monthField.getText() != null && dayField.getText() != null && hourField.getText() != null && minuteField.getText() != null && licenseNumField1.getText() != null && licenseNumField2.getText() != null && cityField.getText() != null && roadField.getText() != null && locationField.getText() != null && reasonField.getText() != null) {
            return true;
        } else {
            return false;
        }
    }

    void submit() {
        if (ReportPage.allFilled()) {
            /*catalog.getElement();

            // fill in personal information
            catalog.reporterName.sendKeys(ProfileInUse.getProfileInUse().getName());
            catalog.reporterID.sendKeys(ProfileInUse.getProfileInUse().getId());
            catalog.reporterEmail.sendKeys(ProfileInUse.getProfileInUse().getEmail());
            catalog.reporterNumber.sendKeys(ProfileInUse.getProfileInUse().getNumber());
            catalog.reporterAddress.sendKeys(ProfileInUse.getProfileInUse().getAddress());

            // fill in case information **BASED ON HSH**



*/
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
            String verifyCode = verifyField.getText();

            String command =
                    "const f = new FormData()\n" +
                            "\n" +
                            "f.append(\"name\", \"" + ProfileInUse.getProfileInUse().getName() + "\")\n" +
                            "f.append(\"idcard\", \"" + ProfileInUse.getProfileInUse().getId() + "\")\n" +
                            "f.append(\"tel\", \"" + ProfileInUse.getProfileInUse().getNumber() + "\")\n" +
                            "f.append(\"email\", \"" + ProfileInUse.getProfileInUse().getEmail() + "\")\n" +
                            "f.append(\"address2\", \"" + ProfileInUse.getProfileInUse().getAddress() + "\")\n" +
                            "f.append(\"report_date\", \"" + caseDate + "\")\n" +
                            "f.append(\"hour\", \"" + caseHour + "\")\n" +
                            "f.append(\"minute\", \"" + caseMinute + "\")\n" +
                            "f.append(\"carcode\", \"" + licenceNum + "\")\n" +
                            "f.append(\"district\", \"" + cityField + "\")\n" +
                            "f.append(\"road_id\", \"" + roadField + "\")\n" +
                            "f.append(\"address\", \"" + locationField + "\")\n" +
                            "f.append(\"legislation2\", \"" + reasonField + "\")\n" +
                            "f.append(\"data[]\", new Blob(['Hello World!\\n']), \"hi.txt\")\n" +
                            "f.append(\"data[]\", \"\")\n" +
                            "f.append(\"data[]\", \"\")\n" +
                            "f.append(\"data[]\", \"\")\n" +
                            "f.append(\"checknum\", \"" + verifyCode + "\")\n" +
                            "\n" +
                            "fetch(\"https://traffic.hchpb.gov.tw/index.php?catid=11&action=add\", {\n" +
                            "  method: \"POST\",\n" +
                            "  body: f\n" +
                            "});";


            ((JavascriptExecutor) eDriver).executeScript(command);

        } else {
            Notify.error("請先將所有欄位填寫完畢。");
        }

    }
}