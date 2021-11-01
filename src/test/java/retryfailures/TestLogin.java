package retryfailures;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {
	
	@Test(priority = 1)
	public void doLogin() {
		
		System.out.println("Executing Login test");
		
	}
	
	static int count = 0;
	@Test(priority = 2)
	public void registerUsers() {
		
		count++;
		System.out.println(count);
		
		Assert.assertEquals(count, 2);
		
	}

}
