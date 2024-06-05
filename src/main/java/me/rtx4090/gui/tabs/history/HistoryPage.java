package me.rtx4090.gui.tabs.history;

import javax.swing.*;
import java.io.File;
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
        ArrayList<String[]> histories = new ArrayList<>();
        for (File file : filesInsideHistoryFolder) {
            if (file.isDirectory()) {
                File propertiesFile = new File(file.getAbsolutePath() + "/properties.json");
                String[] reportProperties = new String[3];

            }
        }


    }
}
