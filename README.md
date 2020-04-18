Steps to setup Appium on Windows machine:

1-Java Environment variable
2-Android Studio download
3.Launch Android studio to set AVD
4.Make sure to install tools and platform tools from sdk manager
5.We can directly run the avd from command prompt
6.Download Selenium jars
7.Download Appium jars
8.Download apache lang libraries add no click will work



Run the Android Virtual Device(AVD) created without opening android studio from command prompt:

1.emulator.exe -avd OnePlus


To setup Desired Capabilities(To initiate the appium test it is the most important step):
 

	File file=new File("src");
	File fs=new File(file,"original.apk");//path to the apk
	DesiredCapabilities cap= new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus");//name of the AVD (In case of Virtual Device)
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");// new line added by appium without this latest android wont work
	cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	AndroidDriver<AndroidElement> ad= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);//4723 is generally the port no on which the server is initiated
		
	

Locators allowed in appium native app:

(class name as tag name	)

1.xpath //tagname[@attribute='value']
2.id
3.classNamme
4.androidUIautomator:
				
					driver.findElementByAndroidUIAutomator("text(\"Views\")")
					attribute=text
					value=views

special character in xpath cannot be used in xpath for e.g in class name or id there is &$* we cannot use that



In cases to check properties are working we use the below:

List<AndroidElement> allClickable=driver.findElementsByAndroidUIAutomator("new UiSelector.clickable(true)");

(http://www.automationtestinghub.com/uiselector-android/ more about UiSeletor)




Touch Actions(Gestures)

You need to import some static imports that wont be imported automatically by IDE

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

Initiate Touch Action Object

TouchAction actions= new TouchActions(driver)

1.Tap:
	
	actions.tap(tapOptions().withElement(element(check))).perform();

2.Long Press:
	
	actions.longPress(longPressOptions().withElement(element(longPress)).withDuration(ofSeconds(3))).release().perform();

3.Scroll:

	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");

	OR
	
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Brazil\").instance(0))")).click();;


	

Switch Context from native to browser and vice versa:

													Set<String> context=driver.getContextHandles();
														
														for(String con:context)
														{
															System.out.println(con.toString());
														}
														
														driver.context("NATIVE_APP");
														driver.context("Web");




Configuring Real Physical device:

https://developers.google.com/web/tools/chrome-devtools/remote-debugginghttps://developers.google.com/web/tools/chrome-devtools/remote-debugging

Steps:
		1.Allow usb debugging in developer options
		2.Make sure in chrome browser USB debugging is on in machine
		3.To check the device hit the adb list command
		4.Chane in Desired Capabilities:
										cap.setCapability(MobileCapabilityType.DEVICE_NAME, "apnaVM"); comment this
										cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Andorid Device");
		5.For debugging browser application hit remote devices in chrome browser or go to chrome://inspect/#devices 




Imp Notes:

1. Inspect will work only when you hit the url in real time on the device
2. There is an ongoing issue with chrome driver that appium picks up in order to run it by specific chrome browser use the below commands:
	
	appium --chromedriver-executable "W:\chromedriver.exe"




To install an application in the device:

1.adb install "W:\GeneralStore.apk"



To hide keyboard:
1.driver.hideKeyboard();


To scroll in Browser app:
1.Use java script executor(Once you switch the context from native to web you can use all selenium function(css jse etc).



Toast Error Msgs:

Toast error messages basically are pop up error msgs which we encounter for a shorter period of time and they are automaically exits. To capture them is difficult and by default in appium we use the below tag to identify toast elements:

1.andorid.widget.Toast[index]




More details on how to run hybrid(native+browser) apps:
1.http://appium.io/docs/en/writing-running-appium/web/hybrid/







		
