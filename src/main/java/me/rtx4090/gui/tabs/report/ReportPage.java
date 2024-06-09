package me.rtx4090.gui.tabs.report;

import javax.swing.*;
import java.awt.*;

public class ReportPage {

    public JPanel reportPanel = new JPanel();
    RegionSelector regionSelectorInstance = new RegionSelector();
    ContentScrollPane contentScrollPaneInstance;
    SubmitButton submitButton = new SubmitButton();
    JLabel profileInUse = new JLabel();

    public ReportPage() {
        Driver driver = new Driver();
        reportPanel.setLayout(new GridLayout(3, 1));
        setRegionSelectorAction();
        setSubmitButtonAction();
        reportPanel.add(regionSelectorInstance.regionSelector);
        //reportPanel.add(contentScrollPaneInstance.scrollPane);
        //reportPanel.add(submitButton.button);
    }

    private void setRegionSelectorAction() {
        regionSelectorInstance.regionSelector.addActionListener(e -> {
            regionSelectorInstance.regionCode = regionSelectorInstance.regions.get(regionSelectorInstance.regionSelector.getSelectedItem().toString());
            refreshScrollPane(regionSelectorInstance.regionCode);
        });
    }

    void setSubmitButtonAction() {
        submitButton.button.addActionListener(e -> {

        });
    }

    void refreshScrollPane(String regionCode) {
        contentScrollPaneInstance = new ContentScrollPane(regionCode);
        reportPanel.add(contentScrollPaneInstance.scrollPane);
        reportPanel.add(submitButton.button);
    }

}
