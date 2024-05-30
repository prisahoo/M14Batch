package beauty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchLakme_Test {
	
	@Test
	public void lakme() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.lakmeindia.com/");
		String url=System.getProperty("url");
		driver.get(url);
		Thread.sleep(2000);
		driver.quit();
	}

}
