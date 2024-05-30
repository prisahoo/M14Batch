package beauty;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchNykaa_Test {
	
	@Test
	public void nykaa() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		Thread.sleep(2000);
		driver.quit();
		
	}

}
