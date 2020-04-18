import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scroll extends Capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=Capabilities("realDevice");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		Thread.sleep(2000);
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
	
		
	}

}
