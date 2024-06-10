package me.rtx4090.reportWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HSH extends Catalog {

    public HSH(WebDriver driver) {
        this.driver = driver;
        verify();

    }

    @Override
    public void getElement() {

        reporterName = driver.findElement(By.id("name"));
        reporterID = driver.findElement(By.id("idcard"));
        reporterEmail = driver.findElement(By.id("email"));
        reporterNumber = driver.findElement(By.id("tel"));
        reporterAddress = driver.findElement(By.id("address2"));

        caseDate = driver.findElement(By.id("select2-report_date-container"));
        caseHour = driver.findElement(By.id("select2-hour-container"));
        caseMinute = driver.findElement(By.id("select2-minute-container"));

        licensePlateNum = driver.findElement(By.id("carcode"));

        city = driver.findElement(By.id("select2-cakeslt1-container"));
        road = driver.findElement(By.id("select2-cakeslt2-container"));
        no = driver.findElement(By.id("address"));

        reason = driver.findElement(By.cssSelector("select[name=legislation2]"));

        fileInput1 = driver.findElement(By.xpath("(//input[@id='data[]'])[1]"));
        fileInput2 = driver.findElement(By.xpath("(//input[@id='data[]'])[2]"));
        fileInput3 = driver.findElement(By.xpath("(//input[@id='data[]'])[3]"));
        fileInput4 = driver.findElement(By.xpath("(//input[@id='data[]'])[4]"));

        captcha = driver.findElement(By.id("checknum"));
        captchaImg = driver.findElement(By.className("captcha_img"));
        submitButton = driver.findElement(By.id("submit"));
    }

    @Override
    public void verify() {
        String urlBefore = "https://traffic.hchpb.gov.tw/10/13";
        String urlAfter = "https://traffic.hchpb.gov.tw/report";

        driver.get(urlBefore);

        //wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));

        // Define Checkbox
        WebElement checkbox = driver.findElement(By.cssSelector("label.agree > input[type='checkbox']"));
        // Scroll to view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        // Wait for the checkbox to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));

        // Click the checkbox
        try {
            checkbox.click();
        } catch (Exception e) {
            // Use JavaScript click as a last resort
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        }

        // Define Confirm Button
        WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'btn btn-primary') and contains(text(), '下一步')]")));
        // Scroll the confirm button into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmButton);
        // Wait for the confirm button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));

        // Click the confirm button
        try {
            confirmButton.click();
        } catch (Exception e) {
            // Use JavaScript click as a last resort
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmButton);
        }

        // Wait for redirect
        wait.until(ExpectedConditions.urlToBe(urlAfter));

    }

}
