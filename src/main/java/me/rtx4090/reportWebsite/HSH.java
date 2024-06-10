package me.rtx4090.reportWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HSH extends Catalog {

    @Override
    public void getElement(WebDriver driver) {


        reporterName = driver.findElement(By.id("name"));
        reporterID = driver.findElement(By.id("idcard"));
        reporterEmail = driver.findElement(By.id("email"));
        reporterPhone = driver.findElement(By.id("tel"));
        reporterAddress = driver.findElement(By.id("address2"));

        caseDate = new Select(driver.findElement(By.id("select2-report_date-container")));
        caseHour = new Select(driver.findElement(By.id("select2-hour-container")));
        caseMinute = new Select(driver.findElement(By.id("select2-minute-container")));

        licensePlateNum = driver.findElement(By.id("carcode"));

        city = new Select(driver.findElement(By.id("select2-cakeslt1-container")));
        road = new Select(driver.findElement(By.id("select2-cakeslt2-container")));
        no = driver.findElement(By.id("address"));

        reason = new Select(driver.findElement(By.cssSelector("select[name=legislation2]")));

        fileInput1 = driver.findElement(By.xpath("(//input[@id='data[]'])[1]"));
        fileInput2 = driver.findElement(By.xpath("(//input[@id='data[]'])[2]"));
        fileInput3 = driver.findElement(By.xpath("(//input[@id='data[]'])[3]"));
        fileInput4 = driver.findElement(By.xpath("(//input[@id='data[]'])[4]"));

        captcha = driver.findElement(By.id("checknum"));
        captchaImg = driver.findElement(By.className("captcha_img"));
        submitButton = driver.findElement(By.id("submit"));
    }

    @Override
    public void verifySteps() {

    }

}
