package me.rtx4090.gui.tabs.report;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.util.HashMap;

public class RegionSelector {
    public String regionCode;
    public JComboBox regionSelector = new JComboBox();

    public HashMap<String, String> regions = new HashMap<String, String>();

    RegionSelector() {
        initRegions();
        AutoCompleteDecorator.decorate(regionSelector);
        for (String key : regions.keySet()) {
            regionSelector.addItem(key);
        }

        regionSelector.addActionListener(e -> {
            regionCode = regions.get(regionSelector.getSelectedItem().toString());
            refreshScrollPane();
        });
    }

    public String getRegionCode() {
        return regionCode;
    }
    void refreshScrollPane() {

    }
    void initRegions() {
        regions.put("基隆市", "LUU");
        regions.put("新北市", "TPH");
        regions.put("台北市", "TPE");
        regions.put("桃園市", "TYC");
        regions.put("新竹縣", "HSH");
        regions.put("新竹市", "HSC");
        regions.put("苗栗縣", "MAL");
        regions.put("台中市", "TXG");
        regions.put("彰化縣", "CWH");
        regions.put("南投縣", "NTO");
        regions.put("雲林縣", "YLH");
        regions.put("嘉義縣", "CHY");
        regions.put("嘉義市", "CYI");
        regions.put("台南市", "TNN");
        regions.put("高雄市", "KHH");
        regions.put("屏東縣", "IUH");
        regions.put("宜蘭縣", "ILN");
        regions.put("花蓮縣", "HWA");
        regions.put("台東縣", "TTT");
        regions.put("澎湖縣", "PEH");
        regions.put("金門縣", "KMN");
        regions.put("連江縣", "LNN");
    }
}
