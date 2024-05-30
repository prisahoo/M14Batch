package ecomm;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterInDemoWebShop_Test {
	
	@Test
	public void registerTestCase() {
		
		Random rand = new Random();
		int rand_int = rand.nextInt(1000);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.partialLinkText("Register")).click();
		
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Pri"+rand_int);
		driver.findElement(By.id("LastName")).sendKeys("S"+rand_int);
		driver.findElement(By.id("Email")).sendKeys("pritestx"+rand_int+"@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Test123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Test123");
		driver.findElement(By.id("register-button")).click();
		
		String successMessage=driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();
		assertEquals(successMessage,"Your registration completed","User is not regirsted");
		driver.quit();
		
	}

}
