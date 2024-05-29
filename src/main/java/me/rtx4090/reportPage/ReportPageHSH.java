package ReportPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReportPageHSH{

    public ReportPageHSH(){
        String url = "https://traffic.hchpb.gov.tw/index.php?catid=11";
        WebDriver driver = new EdgeDriver();
        driver.get(url);

        WebElement reporterName = driver.findElement(By.id("name"));
        WebElement reporterID = driver.findElement(By.id("idcard"));
        WebElement reporterEmail = driver.findElement(By.id("email"));
        WebElement reporterPhone = driver.findElement(By.id("tel"));
        WebElement reporterAddress = driver.findElement(By.id("address2"));

        Select caseDate = new Select(driver.findElement(By.id("select2-report_date-container")));
        Select caseHour = new Select(driver.findElement(By.id("select2-report_month")));



    }

}
