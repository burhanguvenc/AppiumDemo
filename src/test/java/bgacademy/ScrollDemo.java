package bgacademy;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {

	@Test
	public void ScrollDemoTest() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Scrolling Method 1
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		
		//Scrolling method 2
		scrollToEndAction();
		Thread.sleep(2000);

	}
}
