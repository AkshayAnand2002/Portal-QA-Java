package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DreamTotalPage {
    WebDriver driver;
    public DreamTotalPage(WebDriver driver){
        this.driver=driver;
    }
    public int getCountBYLabel(String str){
        List<WebElement> values=driver.findElements(By.cssSelector("#dreamsTotal tbody tr"));
        for(WebElement val:values){
            List<WebElement> vals=val.findElements(By.tagName("td"));
            if(vals.size()==2 && vals.get(0).getText().trim().equals(str)){
                return Integer.parseInt(vals.get(1).getText().trim());
            }
        }
        return 0;
    }
}
