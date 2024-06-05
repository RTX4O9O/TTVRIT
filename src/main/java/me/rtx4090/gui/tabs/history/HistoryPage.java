package me.rtx4090.gui.tabs.history;

import com.google.gson.Gson;
import me.rtx4090.ReportProperties;
import me.rtx4090.gui.Notify;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class HistoryPage {
    public JPanel contentPanel = new JPanel();

    public JScrollPane historyPanel;
    File historyFolder = new File(System.getProperty("user.home") + "/TTVRIT/Reports");

    public HistoryPage() {
        // if history folder exists
        if (!historyFolder.exists()) {
            historyFolder.mkdirs();
        }

        File[] filesInsideHistoryFolder = historyFolder.listFiles();
        ArrayList<ReportProperties> histories = new ArrayList<>();

        for (File file : filesInsideHistoryFolder) {
            if (file.isDirectory()) {
                File propertiesFile = new File(file.getAbsolutePath() + "/properties.json");
                try (FileReader reader = new FileReader(propertiesFile)) {
                    ReportProperties reportProperties = new Gson().fromJson(reader, ReportProperties.class);
                    histories.add(reportProperties);
                } catch (Exception e) {
                    e.printStackTrace();
                    Notify.error(e.getMessage());
                }

            }

        }

        // display histories
        for (int i = 0; i < histories.size(); i++) {
            ReportProperties reportProperties = histories.get(i);
            JLabel label = new JLabel("檢舉區域：" + reportProperties.region + "；檢舉時間：" + reportProperties.year + "/" + reportProperties.month + "/" + reportProperties.day + "；車牌號碼：" + reportProperties.licensePlateNumber);
            label.setBounds(10, 10 + i * 20, 300, 20);
            contentPanel.add(label);
        }
        historyPanel = new JScrollPane(contentPanel);
    }


}

