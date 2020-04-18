import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Swipe extends Capabilities {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=Capabilities("realDevice");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@content-desc='9']").click();
		Thread.sleep(2000);
		
		WebElement drag=driver.findElementByXPath("//*[@content-desc='15']");
		WebElement drop=driver.findElementByXPath("//*[@content-desc='45']");
		
		TouchAction actions=new TouchAction(driver);
		actions.longPress(longPressOptions().withElement(element(drag)).withDuration(ofSeconds(2))).moveTo(element(drop)).release().perform();
		
		

	}

}
