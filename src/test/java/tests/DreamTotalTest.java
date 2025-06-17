package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DreamTotalPage;

import static org.testng.Assert.assertEquals;

public class DreamTotalTest {
    WebDriver driver;
    DreamTotalPage dtp;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://arjitnigam.github.io/myDreams/dreams-total.html");
        dtp=new DreamTotalPage(driver);
    }
    @Test
    public void testing() throws InterruptedException{
        assertEquals(dtp.getCountBYLabel("Good Dreams"),6);
        assertEquals(dtp.getCountBYLabel("Bad Dreams"),4);
        assertEquals(dtp.getCountBYLabel("Total Dreams"),10);
        assertEquals(dtp.getCountBYLabel("Recurring Dreams"),2);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
