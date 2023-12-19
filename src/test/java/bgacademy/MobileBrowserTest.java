package bgacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {
	
	@Test
	
	public void browserTest() {
		
		/*
		 * driver.get("https://www.google.com/"); System.out.println(driver.getTitle());
		 * driver.findElement(By.name("q")).sendKeys("Linkedin");
		 * driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		 */
		
		//Opens target URL and clicks the hamburger icon 
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		
		driver.findElement(By.cssSelector("a[routerlink='/products']")).click();
		
		//Scrolls mobile browser window
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		Assert.assertEquals(text, "Devops");
		
	}

}
