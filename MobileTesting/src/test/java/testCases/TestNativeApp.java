/**
 * 
 */
package testCases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/**
 * @author ramak
 *
 */
public class TestNativeApp {

	public static AndroidDriver<WebElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		//path where apk is stored
		//File app = new File("./app/selendroid-test-app-0.17.0.apk");
		
		//To Launch Appium server through program with logs created in a separate file
		//By default, time zone in log file will be GMT
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File(
						"C:\\Users\\ramak\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File("D:\\Project\\MobileTesting\\src\\test\\resources\\appiumLogs\\log.txt"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));

		service.start();
		
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		
		//To Install the apk file
		//cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		//To launch an app using "app package" and "app activity"
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.samsung.android.dialer");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".DialtactsActivity");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(5000);

		driver.quit();
		
		service.stop();
	}
}
