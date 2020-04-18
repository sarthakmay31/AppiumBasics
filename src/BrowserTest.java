import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserTest extends BrowserCapabilities {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver=browserCaps();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get("https://news.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		
		
		List<AndroidElement> allNews=driver.findElements(By.xpath("//article[@class=' MQsxIb xTewfe tXImLc Xpocq R7GTQ keNKEd keNKEd Au3bp VkAdve GU7x0c g1F8Ld mSjmrf msTxEe']//following::h4"));
		
		for(AndroidElement ele:allNews) {
			
			 jse.executeScript("arguments[0].scrollIntoView();", ele);
			 System.out.println(ele.getText());
			
			
		}
		
	}

}
