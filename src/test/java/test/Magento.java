package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Magento {
	@Test(priority=1)
	public void register() { 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://magento.com");
		driver.findElement(By.partialLinkText("Sign in")).click();
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("Sravika");
		driver.findElement(By.id("lastname")).sendKeys("Valluri");
		driver.findElement(By.id("email_address")).sendKeys("sravi.valluri@gmail.com");
		driver.findElement(By.id("self_defined_company")).sendKeys("YesMSystems");
		
		Select cp = new Select(driver.findElement(By.id("company_type")));
		//cp.selectByIndex(2);
		//cp.selectByValue("development");
		cp.selectByVisibleText("Develops Magento extensions");
		Select cp1 = new Select(driver.findElement(By.id("individual_role")));
		cp1.selectByVisibleText("Technical/developer");
		Select cp2 = new Select(driver.findElement(By.id("country")));
		cp2.selectByVisibleText("India");
		
		driver.findElement(By.id("password")).sendKeys("Welcome@123");
		driver.findElement(By.id("password-confirmation")).sendKeys("Welcome@123");
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"recaptcha-f979c2ff515d921c34af9bd2aee8ef076b719d03\"]/div/div/iframe")));
		driver.findElement(By.className("recaptcha-checkbox-border")).click();
		driver.switchTo().defaultContent();
		
		if (!driver.findElement(By.id("agree_terms")).isSelected()){
			driver.findElement(By.id("agree_terms")).click();
		}
		driver.quit();
		}
	@Test(priority=2)
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Magento");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul/li[1]/div/div[2]/div[1]/span")).click();

	
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3")).click();
		driver.findElement(By.xpath("//*[@id=\"gnav_565\"]/span/span/span/span")).click();
		//driver.findElement(By.id("email")).sendKeys("sravi.valluri@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/label/span")).click();
		driver.findElement(By.name("login[username]")).sendKeys("sravi.valluri@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[2]/label/span")).click();
		driver.findElement(By.name("login[password]")).sendKeys("welcome");
		driver.findElement(By.name("send")).click();
		Thread.sleep(5000);
		String error= driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
		System.out.println(error);
		driver.quit();
	}

}
