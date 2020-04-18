import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class UIAutomatator extends Capabilities {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=Capabilities("realDevice");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		List<AndroidElement> allClickable=driver.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")");
		
		System.out.println(allClickable.size());
		
		
		

	}

}
