package extentReport;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotMethod {
	
	public String takeScreenShot(WebDriver driver) {
		LocalDateTime dateTime=LocalDateTime.now();
		String date=dateTime.toString().replace(":", "-");
		String path="./ScreenShots/"+date+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(path);
		try {
			FileHandler.copy(src,trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "."+path;
	}

}
