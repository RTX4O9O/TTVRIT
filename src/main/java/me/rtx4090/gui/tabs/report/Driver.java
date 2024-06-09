package me.rtx4090.gui.tabs.report;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;
import java.util.Set;

public class Driver {
    public WebDriver edgeDriver;
    public Driver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless");
        edgeDriver = new EdgeDriver(options);
    }

}