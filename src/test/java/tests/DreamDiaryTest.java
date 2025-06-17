package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DreamDiaryPage;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DreamDiaryTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");
    }
    @Test
    public void testing() throws InterruptedException{
        DreamDiaryPage dd=new DreamDiaryPage(driver);
        assertEquals(dd.getEntries().size(),10);
        assertTrue(dd.DreamsValid());
        assertTrue(dd.columnsFilled());
        Set<String> recurringElems=dd.recurring();
        assertTrue(recurringElems.contains("Flying over mountains"));
        assertTrue(recurringElems.contains("Lost in maze"));
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
