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

public class TestScript02 {
	
	@Test
	public void script2() {
		
		ScreenshotMethod s2=new ScreenshotMethod();
		LocalDateTime dateTime=LocalDateTime.now();
		String date=dateTime.toString().replace(":","-");
		
		ExtentReports reports=new ExtentReports();
		ExtentSparkReporter reporter=new ExtentSparkReporter("./Reports/reportBooks"+date+".html");
		reports.attachReporter(reporter);
		ExtentTest test=reports.createTest("books page");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		test.log(Status.INFO, "Browser is maximized");
		driver.get("https://demowebshop.tricentis.com/");
		test.log(Status.INFO, "Application is launched");
		driver.findElement(By.partialLinkText("Books")).click();
		test.log(Status.INFO, "Books page is opened");
		driver.findElement(By.linkText("Computing and Internet")).click();
		test.log(Status.INFO, "User clicked on Computing and Internet");
		driver.findElement(By.id("add-to-cart-button-13")).click();
		test.log(Status.INFO, "User clicked on Add to Cart button");
		try {
			if(driver.getTitle().equals("Demo Web Shop. Computing and Internet"))
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(s2.takeScreenShot(driver)).build());
		}catch(Exception e) {
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(s2.takeScreenShot(driver)).build());
		}
		driver.close();
		reports.flush();
		
	}

}
