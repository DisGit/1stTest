package pcg1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

	String username = "";
	String password = "";
	//final int C = 900;
	WebDriver driver;
	//boolean acceptNextAlert = true;
	//StringBuffer verificationErrors = new StringBuffer();
	final String URL = "https://moj.dispecer.sk/gweb/";
	
	@BeforeTest
    public void setUp(){
		
		username = "andrejkovic";
		password = "iisLog1n";
		
		String geckodriverPath = "/home/testai/Downloads/geckodriver";
		//String geckodriverPath = "D:\\AI\\FFDriver\\geckodriver.exe";
		
		System.setProperty("webdriver.gecko.driver",geckodriverPath);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    capabilities.setCapability("marionette", true);
	    capabilities.setJavascriptEnabled(true);
	    
	    //driver = new RemoteWebDriver(DesiredCapabilities.firefox());
		
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();   // maximize window
	    driver.get(URL);
		
		System.out.println("Debug: Zacal program zacne vykonavanie testu");
		driver.findElement(By.cssSelector("[id$=username]")).sendKeys(username);
		driver.findElement(By.cssSelector("[id$=password]")).sendKeys(password);
		driver.findElement(By.xpath(".//input[contains(@id,'login')] | .//input[@id='submit'] | .//*[@id='login']")).click();
		
    }
	
	@Test			//(dependsOnMethod="methodNamewihtout()") //alwaysRun=true
	public void test() throws InterruptedException, IOException{
		
		driver.findElement(By.linkText("Nastavenia")).click();
		driver.findElement(By.xpath(".//*[@id='person-settings']")).click();
		System.out.println("Test success");
		
	}
	
	@AfterTest
    public void tearDown(){
		
		driver.quit();
		System.out.println("Debug: Zacal program zacne inicializacia");
		
    }
}
