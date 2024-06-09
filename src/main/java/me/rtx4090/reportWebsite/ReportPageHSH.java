package me.rtx4090.reportWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReportPageHSH {

    public ReportPageHSH(WebDriver driver) {
        String url = "https://traffic.hchpb.gov.tw/index.php?catid=11";
        driver.get(url);

        WebElement reporterName = driver.findElement(By.id("name"));
        WebElement reporterID = driver.findElement(By.id("idcard"));
        WebElement reporterEmail = driver.findElement(By.id("email"));
        WebElement reporterPhone = driver.findElement(By.id("tel"));
        WebElement reporterAddress = driver.findElement(By.id("address2"));

        Select caseDate = new Select(driver.findElement(By.id("select2-report_date-container")));
        Select caseHour = new Select(driver.findElement(By.id("select2-hour-container")));
        Select caseMinute = new Select(driver.findElement(By.id("select2-minute-container")));

        WebElement licensePlateNum = driver.findElement(By.id("carcode"));

        Select city = new Select(driver.findElement(By.id("select2-cakeslt1-container")));
        Select road = new Select(driver.findElement(By.id("select2-cakeslt2-container")));
        WebElement no = driver.findElement(By.id("address"));

        Select reason = new Select(driver.findElement(By.cssSelector("select[name=legislation2]")));

        WebElement fileInput1 = driver.findElement(By.xpath("(//input[@id='data[]'])[1]"));
        WebElement fileInput2 = driver.findElement(By.xpath("(//input[@id='data[]'])[2]"));
        WebElement fileInput3 = driver.findElement(By.xpath("(//input[@id='data[]'])[3]"));
        WebElement fileInput4 = driver.findElement(By.xpath("(//input[@id='data[]'])[4]"));

        WebElement captcha = driver.findElement(By.id("checknum"));
        WebElement captchaImg = driver.findElement(By.className("captcha_img"));
        WebElement submitButton = driver.findElement(By.id("submit"));
    }

}
