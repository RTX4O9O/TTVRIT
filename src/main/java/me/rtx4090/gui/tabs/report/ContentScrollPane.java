package me.rtx4090.gui.tabs.report;

import me.rtx4090.gui.Notify;
import me.rtx4090.reportWebsite.*;

import javax.swing.*;

public class ContentScrollPane {
    private JPanel panel = new JPanel();
    public JScrollPane scrollPane = new JScrollPane(panel);
    Driver driver = new Driver();
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
                catalog = new HSH();
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
            default:
                throw new IllegalArgumentException("Invalid region code: " + regionCode);

        }
        catalog.getElement(driver.edgeDriver);


    }
}