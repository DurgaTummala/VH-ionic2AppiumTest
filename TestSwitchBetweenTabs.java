package com.vh.mobile;

import java.net.MalformedURLException;
import org.openqa.selenium.Alert;
import com.vh.mobile.TestHomeScreen;
import io.appium.java_client.AppiumDriver;

public class TestSwitchBetweenTabs {
	
	@SuppressWarnings("rawtypes")
	public static AppiumDriver driverTabs = TestHomeScreen.driver;
	
	public void switchTabs() throws InterruptedException {
		driverTabs.findElementById("tab-t0-0").click();
		Thread.sleep(1000);
		
		driverTabs.findElementByClassName("tab-button has-title has-icon").click();
		Thread.sleep(1000);

		driverTabs.findElementById("tab-t0-2").click();
		Thread.sleep(1000);

		driverTabs.findElementById("tab-t0-0").click();
		/*Not good option to use sleep(). We can also use waitForPageToLoad().
		 *If all elements are identified by same locator method, we can just have reuse the statements
		 *and call the method with argument as their locator value. However, it's infrequent scenario in real time.
		*/

		driverTabs.findElementByClassName("button-inner").click();
		
		Alert alert = driverTabs.switchTo().alert();
    	alert.accept(); //Clicks 'ok' on alert window
	}

	public static void main(String[] args) throws MalformedURLException {
		TestSwitchBetweenTabs tabs = new TestSwitchBetweenTabs();
		TestHomeScreen homeScreen = new TestHomeScreen();
		
		homeScreen.setUp();
		try {
			tabs.switchTabs();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homeScreen.TearUp();
	}

}
