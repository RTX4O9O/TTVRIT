package me.rtx4090.gui.tabs.report;

import javax.swing.*;
import java.awt.*;

public class ReportPage {

    public static JPanel reportPanel = new JPanel();
    RegionSelector regionSelectorInstance = new RegionSelector();
    static ContentScrollPane contentScrollPaneInstance = new ContentScrollPane("DEFAULT");
    SubmitButton submitButton = new SubmitButton();
    public static String regionCode = "DEFAULT";

    public ReportPage() {
        reportPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.25;
        gbc.fill = GridBagConstraints.BOTH;
        reportPanel.add(regionSelectorInstance.regionSelector, gbc);

        setRegionSelectorAction();
        setSubmitButtonAction();

        gbc.gridy = 1;
        gbc.weighty = 0.75;
        reportPanel.add(contentScrollPaneInstance.scrollPane, gbc);
    }

    private void setRegionSelectorAction() {
        regionSelectorInstance.regionSelector.addActionListener(e -> {
            regionSelectorInstance.regionCode = regionSelectorInstance.regions.get(regionSelectorInstance.regionSelector.getSelectedItem().toString());
            regionCode = regionSelectorInstance.regionCode;
            refreshScrollPane(regionCode);
        });
    }

    void setSubmitButtonAction() {
        submitButton.button.addActionListener(e -> {
            // Action for submit button
        });
    }

    public static void refreshScrollPane(String regionCode) {
        boolean containsPane = false;
        for (Component component : reportPanel.getComponents()) {
            if (component == contentScrollPaneInstance.scrollPane) {
                containsPane = true;
            }
        }
        if (containsPane) {
            reportPanel.remove(contentScrollPaneInstance.scrollPane);
        }
        contentScrollPaneInstance = new ContentScrollPane(regionCode);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.75;
        gbc.fill = GridBagConstraints.BOTH;
        reportPanel.add(contentScrollPaneInstance.scrollPane, gbc);

        reportPanel.revalidate();
        reportPanel.repaint();
    }

}
