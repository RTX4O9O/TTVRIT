package me.rtx4090.gui.tabs.report;

import javax.swing.*;
import java.awt.*;

public class ReportPage {

    public JPanel reportPanel = new JPanel();
    private RegionSelector regionSelector = new RegionSelector();
    private ContentScrollPane contentScrollPane = new ContentScrollPane();
    private SubmitButton submitButton = new SubmitButton();

    public ReportPage() {
        reportPanel.setLayout(new GridLayout(3, 1));
        reportPanel.add(regionSelector.regionSelector);
        reportPanel.add(contentScrollPane.scrollPane);
        reportPanel.add(submitButton.button);
    }
}
