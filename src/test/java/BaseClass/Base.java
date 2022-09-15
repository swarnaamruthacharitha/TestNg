package BaseClass;

import java.sql.Driver;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base {
	public static WebDriver driver;
	
	@BeforeSuite
	public void beforesuite() {
		//timestamp
		Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        System.out.println(formatter.format(ts));   
	
	}
	@AfterSuite
	public void aftersuite() {
		
		//timestamp
		Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        System.out.println(formatter.format(ts));   
	
		
	}
	@BeforeTest
	public void beforetest() {
		
		//script for chrome browser and step
		//max screen
		System.setProperty("webdtriver.chrome.driver","C:\\Users\\sudha\\OneDrive\\Desktop\\TestNg\\new\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		
		
	}
	@BeforeClass
	public void beforeClass() {
		
		//Login application
		//username and password
		//login button
		driver.get("https://adactinhotelapp.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("phanindra1234");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
		
		String actualTitle="Adactin hotel- search";
		String expectedTitle = driver.getTitle();
		Assert.assertEquals("Adactin hotel- search",actualTitle,expectedTitle);
		
		
	}
	@AfterTest
	public void testafter() {
		driver.close();
		
		
		
	}

}
