package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DreamDiaryPage {
    WebDriver driver;
    public DreamDiaryPage(WebDriver driver){
        this.driver=driver;
    }
    public List<WebElement> getEntries(){
        return driver.findElements(By.cssSelector("#dreamsDiary tbody tr"));
    }
    public boolean DreamsValid(){
        for(WebElement row:getEntries()){
            String value=row.findElements(By.tagName("td")).get(2).getText().trim();
            if(!(value.equals("Good") || value.equals("Bad"))){
                return false;
            }
        }
        return true;
    }
    public boolean columnsFilled(){
        for(WebElement row:getEntries()){
            List<WebElement> value=row.findElements(By.tagName("td"));
            List<WebElement>val2=row.findElements(By.tagName("th"));
            for(WebElement val:value){
                if(val.getText().trim().isEmpty()){
                    return false;
                }
            }
            for(WebElement val:val2){
                if(val.getText().trim().isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }
    public List<String> AllDreamNames(){
        List<String>dreams=new ArrayList<>();
        for(WebElement row:getEntries()){
            dreams.add(row.findElements(By.tagName("td")).get(0).getText().trim());
        }
        return dreams;
    }
    public Set<String> recurring(){
        List<String> names=AllDreamNames();
        Set<String>seen=new HashSet<>();
        Set<String>recurring=new HashSet<>();
        for(String name:names){
            if(!seen.add(name)){
                recurring.add(name);
            }
        }
        return recurring;
    }
}
