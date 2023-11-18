package main_package;

	import java.awt.Desktop.Action;
import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class main_class
	{
		public WebDriver driver;
		
		
			@FindBy (xpath = "//*[@class=\"Pke_EE\"]")
			WebElement search;
		
			@FindBy (xpath = "(//div[@class=\"_4rR01T\"])[1]")
			WebElement search1;
			
			@FindBy (xpath = "//*[@class=\"_1KOMV2\"]") 
			WebElement add_to_cart;
			
			/*    Before Login   */
			//Oranage HRM Admin username and password
			@FindBy (xpath = "//*[@name=\"username\"]")
			WebElement username_HRM;
			
			@FindBy (xpath = "//*[@name=\"password\"]")
			WebElement password_HRM;
			
			@FindBy(xpath = "//*[@type=\"submit\"]")
			WebElement login_HRM;
			
			/*    After Login   */
			//Click on admin in Dashboard
			@FindBy(xpath = "(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[1]")
			WebElement Admin;
			
			@FindBy (xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
			WebElement Search_username;
			
			@FindBy(xpath = "(//div[@class=\"oxd-select-text--after\"])[1]")
			WebElement user_role;
			
			@FindBy(xpath = "//*[@type=\"submit\"]")
			WebElement employee_search;
			
		public main_class(WebDriver driver)
		{
			
			PageFactory.initElements(driver,this);
		}
		
		/*    Flipkart Login   */
		public void flipkart_search()
		{
			search.sendKeys("Iphone 15 pro");
			search.submit();
		}
		public void flipkart_search1()
		{
			search1.click();
		}
		public void flipkart_AddToCart()
		{
			
			add_to_cart.click();
		}
		
		
		/*    Before Login  */
		public void un()
		{
			username_HRM.sendKeys("Admin");
		}
		public void pw()
		{
			password_HRM.sendKeys("admin123");
		}
		public void HRM_login_button()
		{
			login_HRM.submit(); //Click on login
		}
		
		
		/*    After Login   */
		public void admin()
		{
			Admin.click();    //Click on Admin on sidebar
		}
		public void s_u()
		{
			Search_username.sendKeys("Cheeku"); //enter username
		}
		public void u_r(WebDriver driver) throws InterruptedException
		{
			user_role.click();          //select user role as a admin
			Actions action = new Actions(driver);
			Thread.sleep(2000);
			action.keyDown(Keys.ARROW_DOWN).build().perform();
			action.keyDown(Keys.ENTER).build().perform();
			//Using Action Class
			//Or keys
		}
		public void emp_search()
		{
			employee_search.click();  //Click on search
		}
	}

