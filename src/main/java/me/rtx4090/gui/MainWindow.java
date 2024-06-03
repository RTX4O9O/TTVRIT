package me.rtx4090.gui;

import me.rtx4090.gui.tabs.profile.ProfilePage;
import me.rtx4090.gui.tabs.report.ReportPage;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    ProfilePage profilePage = new ProfilePage();
    JPanel profilePanel = profilePage.profilePanel;
    ReportPage reportPage = new ReportPage();
    JPanel reportPanel = reportPage.reportPanel;

    public MainWindow() {
        this.setTitle("Taiwan Traffic Violation Reporting Integration Tool (TTVRIT) <alpha>");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add(profilePanel, "Profile");
        tabbedPane.add(reportPanel, "Report");

        this.add(profilePanel, BorderLayout.CENTER);



        this.setVisible(true);
    }



}
