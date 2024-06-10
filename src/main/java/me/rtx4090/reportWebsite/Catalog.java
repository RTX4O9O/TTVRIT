package me.rtx4090.reportWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class Catalog {
    public abstract void getElement(WebDriver driver);
    public abstract void verifySteps();
    String urlBefore;
    String urlAfter;
    WebElement reporterName;
    WebElement reporterID;
    WebElement reporterEmail;
    WebElement reporterPhone;
    WebElement reporterAddress;

    Select caseDate;
    Select caseHour;
    Select caseMinute;

    WebElement licensePlateNum;

    Select city;
    Select road;
    WebElement no;

    Select reason;

    WebElement fileInput1;
    WebElement fileInput2;
    WebElement fileInput3;
    WebElement fileInput4;

    WebElement captcha;
    WebElement captchaImg;
    WebElement submitButton;

}
