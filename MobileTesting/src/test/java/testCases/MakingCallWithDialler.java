/**
 * 
 */
package testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author ramak
 *
 */
public class MakingCallWithDialler {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.samsung.android.dialer");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".DialtactsActivity");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
		
		driver.findElement(By.id("com.samsung.android.dialer:id/dialButtonImage")).click();
		
		driver.findElement(By.id("com.samsung.android.incallui:id/guide_area_disconnect")).click();
		
		System.out.println(driver.findElement(By.id("com.samsung.android.incallui:id/call_state_label")).getText());
		
		driver.quit();

	}

}
