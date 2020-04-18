import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capabilities {
	
	public static AndroidDriver<AndroidElement> Capabilities(String Device) throws MalformedURLException {
		File file=new File("src");
		File fs=new File(file,"GeneralStore.apk");
		DesiredCapabilities cap= new DesiredCapabilities();
		if(Device.equals("emulator")) {
		
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "apnaVE");
			
		}
		else if(Device.equals("realDevice"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Andorid Device");
		}
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		return driver;
		

	}

}
