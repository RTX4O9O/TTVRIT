package me.rtx4090.reportWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Catalog {
    public WebDriver driver;
    public abstract void getElement();
    public abstract void verify();

    public WebElement reporterName;
    public WebElement reporterID;
    public WebElement reporterEmail;
    public WebElement reporterNumber;
    public WebElement reporterAddress;

    public WebElement caseDate;
    public WebElement caseHour;
    public WebElement caseMinute;

    public WebElement licensePlateNum;

    public WebElement city;
    public WebElement road;
    public WebElement no;

    public WebElement reason;

    public WebElement fileInput1;
    public WebElement fileInput2;
    public WebElement fileInput3;
    public WebElement fileInput4;

    public WebElement captcha;
    public WebElement captchaImg;
    public WebElement submitButton;
}