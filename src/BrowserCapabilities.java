import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserCapabilities{

	public static AndroidDriver<AndroidElement> browserCaps() throws MalformedURLException{
		
		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Andorid Device");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		return driver;
		
		
		
		

	}

}
