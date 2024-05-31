package beauty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchLoreal {
	
	@Test
	public void nykaa() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.loreal-finance.com/");
		Thread.sleep(2000);
		driver.quit();
		
	}

}
