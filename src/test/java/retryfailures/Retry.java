package retryfailures;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int count = 0;
	private static int maxTry = 2;

	@Override
	public boolean retry(ITestResult iTestResult) {
		
		if (!iTestResult.isSuccess()) { 
			
			iTestResult.setStatus(ITestResult.FAILURE); // Mark test as failed
			
			if (count < maxTry) { // Check if maxtry count is reached
				
				System.out.println("Retrying test " + iTestResult.getName() + " with status "
	                    + iTestResult.getStatus() + " for the " + (count + 1) + " time(s).");
				
				count++;
				
				return true; // Tells TestNG to re-run the test
			}
			
		}
		iTestResult.setStatus(ITestResult.SUCCESS);
		
		return false;
	}
}
