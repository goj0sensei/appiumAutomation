package appiumTests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base extends ExtentReportBase {

	static AppiumDriver driver;
	
	@BeforeTest
	public void setup( ) throws MalformedURLException {
		
		String platform = "android";
		DesiredCapabilities cap = new DesiredCapabilities();
		
		// Store apk file location
		File resources = new File("src/test/resources");
		File calcFile = new File(resources, "Calculator.apk");
		cap.setCapability(MobileCapabilityType.APP, calcFile.getAbsolutePath());
		
		if(platform.equalsIgnoreCase("android")) {
			
			// Set desired capabilities for android emulator
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "pixelEmulator");
			cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
			//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomater2");
		}
		else if(platform.equalsIgnoreCase("ios")) {			

			// Set desired capabilities for android emulator
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhoneSimulator");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		}				
		
		// Set capability for native apps here for testing
		//cap.setCapability("appPackage", "com.google.android.calculator");
		//cap.setCapability("appActivity", "com.android.calculator2");
		
		// Pass server url and above set capabilities
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver(url, cap);
	}
}
