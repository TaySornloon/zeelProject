package Automation_tasks.ui_task.page_class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ZeelUIAutomation {
    @Test
    public void automation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationintesting.online/");
        driver.manage().window().maximize();

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


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      WebElement test = driver.findElement(By.xpath("//div[@style='height: 412px;']"));


       String actualMsg = test.getText();
       String expectedMsg = "Thanks for getting in touch Ada Lovelace!\nWe\'ll get back to you about\nReservation\nas soon as possible.";
       Assertions.assertEquals(expectedMsg,actualMsg);
      // Assertions.assertTrue(expectedMsg.equals(actualMsg));

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




        WebElement bookRoomBtn = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary float-right openBooking']"));
        bookRoomBtn.click();

        //Web Element Calendar 1
       // WebElement bookDate1 = driver.findElement(By.xpath("//button[.='21']"));
       // WebElement bookDate2 = driver.findElement(By.xpath("//button[.='22']"));

        //Web element Calendar2
        WebElement fromElement = driver.findElement(By.xpath("(//div[@class='rbc-day-bg'])[13]"));
        WebElement toElement = driver.findElement(By.xpath("(//div[@class='rbc-day-bg'])[14]"));

        Actions action = new Actions(driver);

       // action.dragAndDrop(fromElement,toElement).perform();

     //  JS.mouseLocationSecond(10);


       // action.clickAndHold(fromElement).moveToElement(toElement).release().perform();
        Thread.sleep(3000);
        action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).perform();
        action.dragAndDrop(fromElement,toElement).release(toElement).build().perform();
        //JavascriptExecutor js = ((JavascriptExecutor) driver);
        //js.executeScript("window.scrollBy(617,824)");
        Thread.sleep(5000);

       // driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      // action.moveToElement(fromElement).clickAndHold().moveToElement(toElement).release().perform();
       // action.clickAndHold(bookDate1).perform();


        /* action.dragAndDrop(bookDate1,bookDate2).perform();
        Thread.sleep(3000);
        action.clickAndHold(bookDate1).moveToElement(bookDate2).release().perform();
        Thread.sleep(3000);
        action.clickAndHold(bookDate1).dragAndDrop(bookDate1,bookDate2).perform();
        Thread.sleep(3000);

        action.dragAndDrop(fromElement,toElement).release().build().perform();
        Thread.sleep(3000);
        action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
        Thread.sleep(3000);


       int xOffset1 = fromElement.getLocation().getX();
       int yOffSet1 = fromElement.getLocation().getY();
        System.out.println("xOffset1 = " + xOffset1);
        System.out.println("yOffSet = " + yOffSet1);

        int xOffSet = toElement.getLocation().getX();
        System.out.println("xOffSet = " + xOffSet);
        int yOffSet = toElement.getLocation().getY();
        System.out.println("yOffSet = " + yOffSet);

        xOffSet = (xOffSet-xOffset1)+10;
        yOffSet = (yOffSet-yOffSet1)+20;
        Thread.sleep(3000);

        System.out.println("xOffset1 = " + xOffSet);
        System.out.println("yOffSet = " + yOffSet);

        action.dragAndDropBy(fromElement,xOffSet,yOffSet).build().perform();
        Thread.sleep(2000);

        Thread.sleep(3000);

         */

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       // action.dragAndDrop(bookDate1,bookDate2).build().perform();

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




       //driver.close();

    }
}
