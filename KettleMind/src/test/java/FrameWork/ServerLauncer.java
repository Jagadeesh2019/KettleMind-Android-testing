package FrameWork;

import org.testng.annotations.BeforeSuite;

public class ServerLauncer {
	
	@BeforeSuite
	public void launchAppiumServer() throws Exception {
		Runtime.getRuntime().exec("cmd /c start F:\\Appium\\serverStart.bat");
		Thread.sleep(6000);
	}

}
