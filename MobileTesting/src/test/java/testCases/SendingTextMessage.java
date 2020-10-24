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
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author ramak
 *
 */
public class SendingTextMessage {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.samsung.android.messaging");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.mms.ui.ConversationComposer");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("com.google.android.gms:id/c11n_tos_button_agree")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.samsung.android.messaging:id/fab")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.samsung.android.messaging:id/recipients_editor_to")).sendKeys("9962272134");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@resource-id='com.samsung.android.messaging:id/bubble_list_view_panel']//android.widget.LinearLayout")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.samsung.android.messaging:id/message_edit_text")).sendKeys("This is an automated message");
		Thread.sleep(2000);
		driver.findElement(By.id("com.samsung.android.messaging:id/send_button1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
