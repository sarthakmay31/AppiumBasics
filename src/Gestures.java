import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Gestures extends Capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		AndroidDriver<AndroidElement> driver=Capabilities("realDevice");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		Thread.sleep(2000);
		
		TouchAction t = new TouchAction(driver);
		AndroidElement webelem=driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		/*TAP*
		 * \
		 */
		
//		t.tap(tapOptions().withElement(element(webelem))).perform();
		
		/*Longpress*
		 * \
		 */
		
		t.longPress(longPressOptions().withElement(element(webelem))).perform();
		System.out.println("Display status " +driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed());
		Thread.sleep(2000);
		
		/*Swipe*
		 * \
		 */
	}

}
