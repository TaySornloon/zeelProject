package Automation_tasks.ui_task.zeel_ui;

import Automation_tasks.utilities.ConfigurationReader;
import Automation_tasks.utilities.Driver;
import Automation_tasks.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZeelUIAutomation {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome") ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

       @DisplayName("Zeel automation UI testing")
       @Test
       public void test1() throws InterruptedException, AWTException {

        driver.get(ConfigurationReader.getProperty("UI_URL"));

           WebElement letMeHackBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
           letMeHackBtn.click();

           WebElement contactName = driver.findElement(By.xpath("//input[@data-testid='ContactName']"));
           contactName.sendKeys("Ada Lovelace");

           WebElement contactEmail = driver.findElement(By.xpath("//input[@data-testid='ContactEmail']"));
           contactEmail.sendKeys("ada.lovelace@zeel.com");

           WebElement contactPhone = driver.findElement(By.xpath("//input[@data-testid='ContactPhone']"));
           contactPhone.sendKeys("347-555-1212");

           WebElement contactSubject = driver.findElement(By.xpath("//input[@data-testid='ContactSubject']"));
           contactSubject.sendKeys("Reservation");

           WebElement contactDescription = driver.findElement(By.xpath("//textarea[@data-testid='ContactDescription']"));
           contactDescription.sendKeys("Welcome yOffSet Shady Meadows, a delightful Bed & Breakfast nestled in the hills on Newingtonfordburyshire.");

           WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submitContact']"));
           submitBtn.click();
           WebElement test = driver.findElement(By.xpath("//div[@style='height: 412px;']"));
           String actualMsg = test.getText();
           String expectedMsg = "Thanks for getting in touch Ada Lovelace!\nWe\'ll get back to you about\nReservation\nas soon as possible.";
           Assertions.assertEquals(expectedMsg,actualMsg);
           WebElement bookRoomBtn = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary float-right openBooking']"));
           bookRoomBtn.click();

           WebElement sourceElement = driver.findElement(By.xpath("(//div[@class='rbc-row-bg'])[4]/div[2]"));

           WebElement targetElement = driver.findElement(By.xpath("(//div[@class='rbc-row-bg'])[4]/div[3]"));
           WebElement fromDate = driver.findElement(By.xpath("//button[.='22']"));
           WebElement toDate = driver.findElement(By.xpath("//button[.='23']"));

           WebElement selectMonth = driver.findElement(By.xpath("//span[.='February 2023']"));
           String month = selectMonth.getText();

           Point point = sourceElement.getLocation();
           int xcord = point.getX();
           int ycord = point.getY();

           Point point2 = targetElement.getLocation();
           int xcord2 = point2.getX();
           int ycord2 = point2.getY();

           xcord2 = (xcord2-xcord)+10;
           ycord2 = (ycord2-ycord)+20;


           if (month.equals("February 2023")){
               Actions move = new Actions(driver);
               move.moveToElement(fromDate).clickAndHold().moveToElement(toDate).release().perform();
               move.dragAndDrop(sourceElement,targetElement).perform();
               move.dragAndDropBy(sourceElement,xcord2,ycord2).perform();
               move.clickAndHold(sourceElement).moveToElement(targetElement,xcord2,ycord2).release().perform();
           }else {
               System.out.println("No month show");
           }

           WebElement booked = driver.findElement(By.xpath("//button[.='12']"));
           booked.click();

           WebElement roomFirstName = driver.findElement(By.xpath("//input[@class='form-control room-firstname']"));
           roomFirstName.sendKeys("Grace");

          WebElement roomLastName = driver.findElement(By.xpath("//input[@class='form-control room-lastname']"));
          roomLastName.sendKeys("Hopper");

          WebElement email = driver.findElement(By.xpath("//input[@class='form-control room-email']"));
          email.sendKeys("grace.hopper@zeel.com");

          WebElement phone = driver.findElement(By.xpath("//input[@class='form-control room-phone']"));
          phone.sendKeys("347-555-9898");

          WebElement book = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary float-right book-room']"));
          book.click();


    }

}
