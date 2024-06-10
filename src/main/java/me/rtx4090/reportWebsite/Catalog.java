package me.rtx4090.reportWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class Catalog {
    WebDriver driver;
    public abstract void getElement();
    public abstract void verifySteps();

    WebElement reporterName;
    WebElement reporterID;
    WebElement reporterEmail;
    WebElement reporterPhone;
    WebElement reporterAddress;

    WebElement caseDate;
    WebElement caseHour;
    WebElement caseMinute;

    WebElement licensePlateNum;

    WebElement city;
    WebElement road;
    WebElement no;

    WebElement reason;

    WebElement fileInput1;
    WebElement fileInput2;
    WebElement fileInput3;
    WebElement fileInput4;

    WebElement captcha;
    WebElement captchaImg;
    WebElement submitButton;

}
