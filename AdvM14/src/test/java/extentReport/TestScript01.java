package extentReport;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestScript01 {
	
	@Test
	public void script1() {
		WebDriver driver;
		ScreenshotMethod ss=new ScreenshotMethod();
		ExtentReports reports=new ExtentReports();
		LocalDateTime dateTime=LocalDateTime.now();
		String date=dateTime.toString().replace(":", "-");
		ExtentSparkReporter reporter=new ExtentSparkReporter("./Reports/reportLogin"+date+".html");
		reports.attachReporter(reporter);
		ExtentTest test=reports.createTest("login");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		test.log(Status.INFO, "Browser is maximized");
		driver.get("https://demowebshop.tricentis.com/");
		test.log(Status.INFO, "URL is launched");
		driver.findElement(By.partialLinkText("Log in")).click();
		test.log(Status.INFO, "Login page is displayed");
		driver.findElement(By.id("Email")).sendKeys("pri.test11@gmail.com");
		test.log(Status.INFO, "Email is entered");
		driver.findElement(By.id("Password")).sendKeys("Polu@9621");
		test.log(Status.INFO, "Password is entered");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		test.log(Status.INFO, "Clicked on Login button");
		try {
			if(driver.findElement(By.linkText("Log out")).isDisplayed()) {
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenShot(driver)).build());
			}
		}catch (Exception e){
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenShot(driver)).build());
		}
		driver.close();
		reports.flush();
	}

}
