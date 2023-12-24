package bgacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class Assignment extends BaseTest {

	@Test(enabled=false)
	public void alertAccept() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		try {
			WebElement alert =driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message"));
			Thread.sleep(1000);
			alert.click();
			String alertText = alert.getText();
			System.out.println(alertText);
		} catch (Exception e) {
			// TODO: handle exception
            e.printStackTrace();
		}	
	}
	
	@Test
	public void radioButton() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Satellite']")).click();
	}
	
	@Test
	public void listDialog() {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Command two']")).click();
		String text = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText();
		Assert.assertEquals(text, "You selected: 1 , Command two");
	}
	
	@Test 
	public void textEntryDialog() {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Rebo Slatke");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Rebo2121");
		driver.findElement(By.id("android:id/button1")).click();
	}
}
