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
        reportPanel.setLayout(new GridLayout(2, 1));
        setRegionSelectorAction();
        setSubmitButtonAction();
        reportPanel.add(regionSelectorInstance.regionSelector);
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

        });
    }

    public static void refreshScrollPane(String regionCode) {
        boolean containsPane = false;
        for (Component component : reportPanel.getComponents()) {
            if (component == contentScrollPaneInstance.scrollPane) {
                containsPane = true;
            }
        }
        if(containsPane){
            reportPanel.remove(contentScrollPaneInstance.scrollPane);
        }
        contentScrollPaneInstance = new ContentScrollPane(regionCode);
        reportPanel.add(contentScrollPaneInstance.scrollPane);

    }

}
