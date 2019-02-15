package FrameWork;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AppTest 
{
   
    @Test
    public void launchApp() throws MalformedURLException, InterruptedException
    {
    	DesiredCapabilities cap = new DesiredCapabilities();
		File file = new File("src");
		File fs = new File(file,"KettleMind-release_beta(0.3.05).apk");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
//		cap.setCapability("wdaLaunchTimeout",240000);S
//		cap.setCapability("wdaConnectionTimeout",240000);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>( new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Get Started']")));
		
		try {
			 driver.findElementByAndroidUIAutomator("text(\"Get Started\")").click();
			
			}catch(Exception e) {
			System.out.println("ElementNotFound exception");
		}
		System.out.println("App Launched successfully");
    }
}
