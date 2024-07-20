package end_User;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScreenShot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\MyWebDriverChrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/index.html");
		// Thread.sleep(3000);

		// Instantiate a Date object
		Date currentDate = new Date();

		String actualCurrentDate = currentDate.toString().replace(":", "-");

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// move image file to new destination
		File DestFile = new File("C:\\Pictures\\"+actualCurrentDate + ".png");

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

}
