import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
	
	@Test(priority = 1)
	public void doLogin() {
		
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("olly.bula@gmail.com");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		
	}
	
	@Test(priority = 2)
	public void composeEmail() {
		
		Assert.fail("failing the compose email test");
		
	}

}
