/**
 * 
 */
package testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @author ramak
 *
 */
public class DragAndDrop {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws MalformedURLException {
		
		/*AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File(
						"C:\\Users\\ramak\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File("D:\\Project\\MobileTesting\\src\\test\\resources\\appiumLogs\\log.txt"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		
		service.start();*/
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mobeta.android.demodslv");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.mobeta.android.demodslv.Launcher");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"),cap);
		
		try {
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
			
			List<WebElement> element = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));
			
			Thread.sleep(2000);
			element.get(0).click();
			
			Thread.sleep(2000);
			element.get(3).click();
			
			Thread.sleep(3000);
			
			/*new TouchAction((PerformsTouchActions) driver).press(ElementOption.element(element.get(0))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
			moveTo(ElementOption.element(element.get(3))).release().perform();*/
			
			//new TouchAction((MobileDriver) driver).longPress(element.get(0)).moveTo(element.get(3)).release().perform();
			
			new TouchAction(driver).press(ElementOption.element(element.get(0)))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(ElementOption.element(element.get(3))).release().perform();
			
			new TouchAction((MobileDriver) driver).press(ElementOption.element(element.get(0)))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(ElementOption.element(element.get(3))).release().perform();
			
			/*TouchAction action = new TouchAction(driver);
			action.press((PointOption) element.get(0)).moveTo((PointOption) element.get(3)).release().perform();*/
			
			/*TouchAction action = new TouchAction(driver);

			//performing the long press
			action.longPress(new LongPressOptions().withElement(new 
			                       ElementOption().withElement(element.get(0)))).perform();

			//performing the move to touch operation
			action.moveTo(new ElementOption().withElement(element.get(3))).perform();*/
			
			//TouchAction action = new TouchAction(driver);
//			action.press(element.get(0)).waitAction(3000).moveTo(element.get(3)).perform().release();

			
			Thread.sleep(5000);
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			driver.quit();
//			service.stop();
		}
		
		driver.quit();
//		service.stop();
	}

}
