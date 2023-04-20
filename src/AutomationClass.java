import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutomationClass {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void myTest() {
		//Go to the website
		driver.get("https://subscribe.stctv.com");
		//Navigate to EN
		driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
		//Verify first package "Lite", Price and currency
		Assert.assertTrue(driver.findElement(By.xpath("//strong[@id='name-lite']")).getText().contains("LITE"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='currency-lite']/b")).getText().contains("0.25"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='currency-lite']/i")).getText().contains("USD"));

		//Verify second package "Classic", Price and currency
		Assert.assertTrue(driver.findElement(By.xpath("//strong[@id='name-classic']")).getText().contains("CLASSIC"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='currency-classic']/b")).getText().contains("0.5"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='currency-classic']/i")).getText().contains("USD"));

		//Verify second package "Premium", Price and currency
		Assert.assertTrue(driver.findElement(By.xpath("//strong[@id='name-premium']")).getText().contains("PREMIUM"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='currency-premium']/b")).getText().contains("1"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='currency-premium']/i")).getText().contains("USD"));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
