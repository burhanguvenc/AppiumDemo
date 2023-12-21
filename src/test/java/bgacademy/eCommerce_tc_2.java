package bgacademy;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_2 extends BaseTest {

	@Test
	public void addingProductToCartValidation() throws InterruptedException {

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

		// Scroll Until You see Argentina
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));

		//Adding "Jordan 6 Rings" product in shopping cart 
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		int productCount = productPrices.size();

		for (int i = 0; i < productCount; i++) {
			String productName = productPrices.get(i)
					.getText();

			if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//Explicit Wait for Cart Page
		
		
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		  wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id(
		  "com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		 
		
		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		
		Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
		
		//Validating Terms and Conditions applying long press
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		
		String alertTitle = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "Terms Of Conditions");

		driver.findElement(By.id("android:id/button1")).click();
		
		//Checkbox future email promotions
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		//Visit to the website
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		
		//Hybrid --- Google Page -->
		Set<String> contexts =driver.getContextHandles();
		for(String contextName : contexts) {
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Linkedin");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}
}
