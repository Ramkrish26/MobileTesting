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

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

/**
 * @author ramak
 *
 */
public class AddingNewContactAndDeleting {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.samsung.android.dialer");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".DialtactsActivity");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@resource-id='com.samsung.android.dialer:id/contactlist_tab_button']//android.widget.TextView")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("com.samsung.android.dialer:id/menu_create_contact")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.samsung.android.app.contacts:id/nameEdit")).sendKeys("Dummy");
		Thread.sleep(2000);
		driver.findElement(By.id("com.samsung.android.app.contacts:id/titleText")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[5]")).sendKeys("123456789");
		Thread.sleep(2000);
		driver.findElement(By.id("com.samsung.android.app.contacts:id/menu_done")).click();
		Thread.sleep(2000);
		
		try {
			
		Assert.assertEquals("Dummy", driver.findElement(By.id("com.samsung.android.app.contacts:id/header")).getText());
		
		driver.findElement(MobileBy.AccessibilityId("More options")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.samsung.android.app.contacts:id/title")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.samsung.android.app.contacts:id/button1")).click();
		Thread.sleep(2000);
		}catch(AssertionError e) {
			
			e.printStackTrace();
			System.out.println("Name mismatch");
		}
		
		driver.quit();
	}

}
