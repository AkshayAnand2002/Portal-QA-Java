package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class indexPage {
    WebDriver driver;
    public indexPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean isSpinnerVisible(){
        try{
            return driver.findElement(By.id("loadingAnimation")).isDisplayed();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
    public boolean isSpinnerGone(){
        try{
            return !(driver.findElement(By.id("loadingAnimation")).isDisplayed());
        }
        catch(java.util.NoSuchElementException e){
            return false;
        }
    }
    public boolean isMainContentVisible(){
        try{
            return driver.findElement(By.id("mainContent")).isDisplayed();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
    public boolean ButtonVisible(){
        try{
            return driver.findElement(By.id("dreamButton")).isDisplayed();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
    public void clickButton(){
        driver.findElement(By.id("dreamButton")).click();
    }
}
