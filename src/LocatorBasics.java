import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LocatorBasics extends Capabilities {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=Capabilities("realDevice");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		Thread.sleep(2000);
		driver.findElementByClassName("android.widget.CheckBox").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
		Thread.sleep(2000);
		driver.findElementByClassName("android.widget.EditText").sendKeys("Done BC");
		Thread.sleep(2000);
		List<AndroidElement> all= driver.findElements(By.className("android.widget.Button"));
		
		for(AndroidElement ae:all) {
			System.out.println(ae.getText());
		}
		
		all.get(1).click();
		
		
		
		
		
		

		
		
		
		

	}

}
