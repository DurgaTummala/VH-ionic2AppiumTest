package com.vh.mobile;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
 
public class TestHomeScreen {
 
	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver;
 
    @SuppressWarnings("rawtypes")
    @BeforeTest
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceName", "iPhone 6");
        caps.setCapability("app", "Users/Durga1/Library/Developer/Xcode/DerivedData/MyApp-gayimxpaezehondcunkctzzglpug/Build/Products/Debug-iphonesimulator/MyApp.app");
        caps.setCapability("appiumVersion", "1.6.5");
 
        try {
			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.MILLISECONDS);
    }
    
    @Test
    public void HomeScreen(String textBox, String textArea) {
    	System.out.println("Home Screen testing started..");
    	driver.findElementByName("textBoxContent").sendKeys(textBox);
    	driver.findElementByName("textAreaContent").sendKeys(textArea);
    	//driver.findElementByClassName("ng-pristine ng-valid ng-touched").sendKeys(textArea);
    	driver.findElementByClassName("button-inner").click();
    	
    	Alert alert = driver.switchTo().alert();
    	String msg = alert.getText();
    	alert.accept(); //Clicks 'ok' on alert window
    	
    	System.out.println("Text on alert box:" + msg);
    }
    
    @AfterTest
    public void TearUp(){
    	driver.close();
    }
 
    public static void main(String[] args) throws Exception {
    	TestHomeScreen home = new TestHomeScreen();
    	home.setUp();
    	home.HomeScreen("Jenny", "Life isn't about finding yourself. Life is about creating yourself..");
    	home.HomeScreen("", "Hello XXX! You didn't enter Name in above text box");
    	home.HomeScreen("Tran","");
    	home.HomeScreen("",""); //Both text fields with no inputs
    	home.TearUp();
    }
}





//driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/Users/Durga1/Desktop/SeleniumFiles"), cap);
