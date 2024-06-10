package me.rtx4090;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test {
    public static void main(String[] args) {
        // Create a new instance of the Edge driver
        WebDriver edgeDriver = new EdgeDriver();


        edgeDriver.get("https://traffic.hchpb.gov.tw/10/13");

        WebDriverWait wait = new WebDriverWait(edgeDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));

        // Scroll the checkbox into view
        WebElement checkbox = findElement(edgeDriver, By.cssSelector("label.agree > input[type='checkbox']"));
        ((JavascriptExecutor) edgeDriver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

        // Wait for the checkbox to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));

        // Click the checkbox
        try {
            checkbox.click();
        } catch (Exception e) {
            // Use JavaScript click as a last resort
            ((JavascriptExecutor) edgeDriver).executeScript("arguments[0].click();", checkbox);
        }

        // Wait for the confirm button to be present using class and text
        WebElement confirmButton = findElement(edgeDriver, By.xpath("//button[contains(@class, 'btn btn-primary') and contains(text(), '下一步')]"));

        // Scroll the confirm button into view
        ((JavascriptExecutor) edgeDriver).executeScript("arguments[0].scrollIntoView(true);", confirmButton);

        // Wait for the confirm button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));

        // Click the confirm button using JavaScript to avoid interception
        try {
            confirmButton.click();
        } catch (Exception e) {
            // Use JavaScript click as a last resort
            ((JavascriptExecutor) edgeDriver).executeScript("arguments[0].click();", confirmButton);
        }

        // Wait for the redirect to the next page
        wait.until(ExpectedConditions.urlToBe("https://traffic.hchpb.gov.tw/report"));

        WebElement reporterName = findElement(edgeDriver, By.id("name"));
        WebElement reporterID = findElement(edgeDriver, By.id("idcard"));
        WebElement reporterEmail = findElement(edgeDriver, By.id("email"));
        WebElement reporterPhone = findElement(edgeDriver, By.id("tel"));
        WebElement reporterAddress = findElement(edgeDriver, By.id("address2"));

        WebElement caseDate = findElement(edgeDriver, By.id("select2-report_date-container"));
        WebElement caseHour = findElement(edgeDriver, By.id("select2-hour-container"));
        WebElement caseMinute = findElement(edgeDriver, By.id("select2-minute-container"));

        WebElement licensePlateNum = findElement(edgeDriver, By.id("carcode"));

        WebElement city = findElement(edgeDriver, By.id("select2-cakeslt1-container"));
        WebElement road = findElement(edgeDriver, By.id("select2-cakeslt2-container"));
        WebElement no = findElement(edgeDriver, By.id("address"));

        WebElement reason = findElement(edgeDriver, By.cssSelector("select[name=legislation2]"));

        WebElement fileInput1 = findElement(edgeDriver, By.xpath("(//input[@id='data[]'])[1]"));
        WebElement fileInput2 = findElement(edgeDriver, By.xpath("(//input[@id='data[]'])[2]"));
        WebElement fileInput3 = findElement(edgeDriver, By.xpath("(//input[@id='data[]'])[3]"));
        WebElement fileInput4 = findElement(edgeDriver, By.xpath("(//input[@id='data[]'])[4]"));

        WebElement captcha = findElement(edgeDriver, By.id("checknum"));
        WebElement captchaImg = findElement(edgeDriver, By.className("captcha_img"));
        WebElement submitButton = findElement(edgeDriver, By.id("submit"));


    }
    private static WebElement findElement(WebDriver driver, By by) {
        try {
            WebElement element = driver.findElement(by);
            System.out.println("Element found: " + by);
            return element;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + by);
            return null;
        }
    }

}