package bgacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {

		// Code to start server service
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\burha\\local\\lib\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		//service.start();

		// Download App Under Test
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Rebophone");
		options.setApp("C:\\Users\\burha\\eclipse-workspace\\Appium\\ApiDemos-debug.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		//service.stop();
	}

}
