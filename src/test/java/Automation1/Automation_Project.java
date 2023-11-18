package Automation1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import main_package.main_class;

public class Automation_Project 
{
	WebDriver driver;
	ExtentHtmlReporter htmlreport;
	ExtentReports extent;
	public main_class CM;
	
	@BeforeTest
	public void launch_browser()
	{
		ChromeOptions handlingSSL = new ChromeOptions();
		handlingSSL.setAcceptInsecureCerts(true);
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Sahil\\Study Material\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver(handlingSSL); //Initialize WebDriver
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.get("https://www.flipkart.com/");
		
		
		CM = new main_class(driver); //Called Main Method
	}
	@BeforeClass
	public void before_class()
	{
		htmlreport = new ExtentHtmlReporter("C:\\Users\\Admin\\eclipse-workspace\\Project1\\Reports\\Report01.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		htmlreport.config().setDocumentTitle("HTML Report");
		htmlreport.config().setReportName("Report01");
		
	
	}
	@Test( priority = 1)
	public void test1() throws InterruptedException, IOException 
	{
		ExtentTest t1 = extent.createTest("Test Case 1-->URL Open");
		t1.log(Status.INFO, "Enter URL and Open in Chrome Browser");
		t1.log(Status.PASS, "URL Opened Successfully in chromebrowser");
		
		ExtentTest t2 = extent.createTest("Test Case 2-->Username and password" , "To Check the Username and Password with valid Credentials");
		
		driver.findElement(By.xpath("//*[@class=\"_30XB9F\"]")).click();
		Thread.sleep(3000);
		//Send Username and password
		t2.log(Status.INFO, "Enter searching product");
		CM.flipkart_search();     //Main method called
		t2.log(Status.PASS, "Product is search correctly");
		
		t2.log(Status.INFO, "Click on 1st product");
		CM.flipkart_search1();    //Main method called
		t2.log(Status.PASS, "1st product click is successfull");
		
		t2.log(Status.INFO, "Add product to cart");
		CM.flipkart_AddToCart();  //Main method called
		t2.log(Status.PASS, "Product added in cart successfully");
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		String Actual_Title = "TMC Visitor Management System";
		Assert.assertEquals(title, Actual_Title);
		t2.addScreenCaptureFromPath("C:\\Users\\Admin\\Pictures\\Screenshots\\Screenshot (90).png", "Screenshot");
		
	}
	
	@Test( priority = 2)
	public void test2() throws InterruptedException
	{
		ExtentTest t3 = extent.createTest("Test Case 3-->Orange HRM Login", "To check the Login functionality");
		t3.log(Status.INFO, "Check the login functionality with valid username and password");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		t3.log(Status.INFO, "Enter valid Username");
		CM.un();
		t3.log(Status.PASS, "Username Enter Successfully");
		
		t3.log(Status.INFO, "Enter Valid Password");
		CM.pw();
		t3.log(Status.PASS, "Password Enter Successfully");
		
		t3.log(Status.INFO, "Click on login");
		CM.HRM_login_button();
		t3.log(Status.PASS, "Clicking on login successfully");
		Thread.sleep(3000);
		
		//Additional Script
		String title = driver.getTitle();
		String actual_title = "OrangeHRM";
		Assert.assertEquals(title, actual_title);
		
		//All Method called after login from main class
		CM.admin();  
		CM.s_u();
		CM.u_r(driver);
		CM.emp_search();
		
	}
	
	@AfterTest
	public void after_test()
	{
		//driver.close;
  	}
	@AfterClass
	public void after_class()
	{
		extent.flush();
	}
		
	
	
}
