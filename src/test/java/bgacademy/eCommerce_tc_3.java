package bgacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends BaseTest {

	@Test
	public void validatingCartPriceSum() throws InterruptedException {

		// Enters Full Name Field
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rebo Slatke");

		// Hides Keyboard
		driver.hideKeyboard();

		// Selects "Female" radio button
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		// Selects Country Dropdown
		driver.findElement(By.id("android:id/text1")).click();

		// Scroll Until You see Argentina
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));

		// Select Argentina
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

		// Click Lets Shop
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
			
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//Explicit Wait for Cart Page
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		
		//Calculating total amount off cart items
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		int count = productPrices.size();
		double totalSum=0;
		for(int i=0; i< count; i++) 
		{
			String amountString = productPrices.get(i).getText();
			Double price = convertStringToDouble(amountString);
			totalSum = totalSum + price;	//160.97 + 120 = 280.97
		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = convertStringToDouble(displaySum);
		
		Assert.assertEquals(totalSum, displayFormattedSum);
		
	}
}
