package me.rtx4090.gui.tabs.report;

import me.rtx4090.ProfileInUse;
import me.rtx4090.reportWebsite.*;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class ContentScrollPane {
    JPanel panel = new JPanel();
    public JScrollPane scrollPane = new JScrollPane(panel);

    Driver driver = new Driver();
    WebDriver eDriver = driver.edgeDriver;

    ContentScrollPane(String regionCode) {
        Catalog catalog;
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
                catalog = new HSH(eDriver);
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
                catalog = new HSH(eDriver);
                break;
            default:
                throw new IllegalArgumentException("Invalid region code: " + regionCode);

        }
        setupGUI();
        catalog.getElement();


    }

    void setupGUI() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel profileInUse = new JLabel("目前使用身分：" + ProfileInUse.profileNickname);
        panel.add(profileInUse);

        panel.add(CaseTime());

    }
    JPanel CaseTime() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

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
}