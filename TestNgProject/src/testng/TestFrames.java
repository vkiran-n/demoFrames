package testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFrames {
	WebDriver wd;
	List<WebElement> framesList;

	@BeforeClass
	public void beforeClass() throws Exception {
//		System.setProperty("webdriver.chrome.driver", path+"chromedriver107.exe");
		wd= new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));	
	}

	@AfterClass
	public void afterClass() {
		wd.quit();
	}
	@Test(priority = 1)
	public void TestLaunchFrames() {
		wd.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		wd.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));	
		Assert.assertEquals(wd.getTitle(), "Overview");
	}
	@Test(priority = 2, dependsOnMethods = "TestLaunchFrames")
	public void TestFramesInPage() {
		framesList = wd.findElements(By.tagName("iframe"));
		Assert.assertEquals(framesList.size(), 3);
	}
	@Test(priority = 3, dependsOnMethods = "TestFramesInPage")
	public void TestFrameNavigation() {
		for (WebElement frame : framesList) {
			String frameName = frame.getAttribute("name");
			System.out.println("-----" + frameName + "-----");
			wd.switchTo().frame(frameName);
 			WebElement links=wd.findElements(By.tagName("a"));
			for (WebElement link : links) {
				System.out.println(link.gettext();
			}
			wd.switchTo().defaultContent();
		}
	}

}
