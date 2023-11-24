package main_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class main_class1 {

    public WebDriver driver;

@FindBy (xpath = "(//div[@class=\"sc-htoDjs kyqvCq\"])[1]" )
WebElement from; 

    public main_class1 (WebDriver driver) //class name same as main class name "main_class1==main_class1"
    {
        PageFactory.initElements(driver, this);
    }


    
    public void from_place()
    {
        from.sendKeys("Mumbai");
        from.submit();
    }

    
}
