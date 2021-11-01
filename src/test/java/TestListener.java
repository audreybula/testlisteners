import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// not implemented
	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getName().toString().trim();

		try {
			testUtil.captureScreenshot(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {

		testUtil.zip(System.getProperty("user.dir") + "/screenshot");
		monitoringMail mail = new monitoringMail();
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody,
					TestConfig.attachmentPath, TestConfig.attachmentName);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
