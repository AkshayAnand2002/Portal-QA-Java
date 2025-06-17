package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.indexPage;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class indexPageTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://arjitnigam.github.io/myDreams/");
    }
    @Test
    public void testing() throws InterruptedException{
        indexPage idx=new indexPage(driver);
        assertTrue(idx.isSpinnerVisible());
        Thread.sleep(3000);
        assertTrue(idx.isSpinnerGone());
        assertTrue(idx.isMainContentVisible());
        assertTrue(idx.ButtonVisible());
        idx.clickButton();
        Set<String>st= driver.getWindowHandles();
        assertEquals(st.size(),3);
//        Thread.sleep(10000);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
