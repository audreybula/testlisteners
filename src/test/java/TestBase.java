import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		
		if(driver == null) {
			driver = new FirefoxDriver();
			driver.get("https://www.paypal.com/fj/signin?country.x=FJ&locale.x=en_FJ");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		
	}

}
