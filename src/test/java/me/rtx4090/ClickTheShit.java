package me.rtx4090;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class ClickTheShit {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://traffic.hchpb.gov.tw/report");
        WebElement shit = driver.findElement(By.id("select2-report_date-container"));
        System.out.println(shit.getLocation());
        System.out.println(shit.getText());

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shit);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1)); // wait for up to 10 seconds
        wait.until(ExpectedConditions.visibilityOf(shit));

        Actions actions = new Actions(driver);
        actions.moveToElement(shit).click().perform();
    }
}
