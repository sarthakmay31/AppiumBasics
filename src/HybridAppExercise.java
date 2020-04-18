import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;

public class HybridAppExercise extends Capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=Capabilities("emulator");
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));").click();;
	
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Brazil\").instance(0))")).click();;
		
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("AutoTest");
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12 \"));").click();;
		
		List<AndroidElement> allProd=driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		
		System.out.println(allProd.size());
		for(AndroidElement ele:allProd) {
			System.out.println(ele.getText());
			if(ele.getText().equals("LeBron Soldier 12 "))
			{
				System.out.println("In if");
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();;
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		System.out.println(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText());
		
		AndroidElement check=driver.findElement(By.className("android.widget.CheckBox"));
		AndroidElement longPress=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		TouchAction actions=new TouchAction(driver);
		
		actions.tap(tapOptions().withElement(element(check))).perform();
		
		actions.longPress(longPressOptions().withElement(element(longPress)).withDuration(ofSeconds(3))).release().perform();
		
		driver.findElement(By.id("android:id/button1")).click();

		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(5000);
		
		Set<String> context=driver.getContextHandles();
		
		for(String con:context)
		{
			System.out.println(con.toString());
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Valar Morghulis");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP");
		

		
	}

}
