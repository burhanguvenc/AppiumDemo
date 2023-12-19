package bgacademy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest{
	
	@Test
	public void FillForm() throws InterruptedException {
		
		//Enters Full Name Field
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rebo Slatke");
		
		//Hides Keyboard
		driver.hideKeyboard();
		
		//Selects "Female" radio button
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		//Selects Country Dropdown
		driver.findElement(By.id("android:id/text1")).click();

		//Scroll Until You see Argentina
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		
		//Select Argentina
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		//Click Lets Shop
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Verify "Please enter your name" Toast Message when the user leave name field as a blank
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		

		
		
	}

}
