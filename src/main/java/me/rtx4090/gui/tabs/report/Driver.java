package me.rtx4090.gui.tabs.report;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class Driver {
    public WebDriver edgeDriver;

    public Driver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless");
        edgeDriver = new EdgeDriver(options);
    }

}