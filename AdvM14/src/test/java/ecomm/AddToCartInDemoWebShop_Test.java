package ecomm;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddToCartInDemoWebShop_Test {
	
	@Test
	public void addToCart() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("pri.test11@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Polu@9621");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Books")).click();
		driver.findElement(By.xpath("//a[@title='Show details for Computing and Internet']")).click();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button-13']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
		driver.findElement(By.name("updatecart")).click();
		Thread.sleep(3000);
		String successMessage=driver.findElement(By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]")).getText();
		assertEquals(successMessage,"Your Shopping Cart is empty!","Item not added to cart");
		driver.findElement(By.partialLinkText("Log out")).click();
		driver.quit();
		
		
		
	}

}
