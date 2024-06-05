package me.rtx4090.gui.tabs.history;

import com.google.gson.Gson;
import me.rtx4090.ReportProperties;
import me.rtx4090.gui.Notify;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class HistoryPage {
    public JPanel historyPanel = new JPanel();
    File historyFolder = new File(System.getProperty("user.home") + "/TTVRIT/Reports");

    public HistoryPage() {
        historyPanel.setLayout(null);
        // if history folder exists
        if (!historyFolder.exists()) {
            historyFolder.mkdirs();
        }

        File[] filesInsideHistoryFolder = historyFolder.listFiles();
        ArrayList<ReportProperties> histories = new ArrayList<>();
        Gson gson = new Gson();
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
            JLabel label = new JLabel(reportProperties.city + " " + reportProperties.road + " " + reportProperties.no);
            label.setBounds(10, 10 + i * 20, 300, 20);
            historyPanel.add(label);
        }
    }


}

