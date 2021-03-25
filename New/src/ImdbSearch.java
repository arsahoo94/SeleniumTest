import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImdbSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\New folder (2)\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.imdb.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input#suggestion-search")).sendKeys("games of thrones");
		driver.findElement(By.cssSelector("button#suggestion-search-button")).click();

		driver.findElement(By.cssSelector(".findResult:nth-child(4) > .result_text:nth-child(2) > a")).click();
		System.out.println(driver.getTitle());
		String Title = driver.getTitle();
		if (Title.contains("Video Game")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("C:\\New folder (2)\\homePageScreenshot.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
