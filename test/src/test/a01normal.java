package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class a01normal {

	private static String ouptut;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.get("https://unittest.dev.toucanus.net/");
		Thread.sleep(1000);
		driver.findElement(By.name("f1")).sendKeys("chandu");
		driver.findElement(By.name("f2")).sendKeys("Chandu@19");
		driver.findElement(By.name("login1")).click();
		Thread.sleep(2000);
		var Title = driver.getTitle();
		System.out.println(Title);

		// Excel data reading
		int i;
		int j = 401;
		for (i = 0; i < 1; i++)

		{
			int b = j + i;
			// driver.findElement(By.cssSelector("[id = 'a01']")).click();
			driver.get(
					"https://unittest.dev.toucanus.net/#/simulation/details?authType=Normal%20Authorization%20-%20Swipe%20and%20signature&screenIdDisplay=1&authCode=A01");
			Thread.sleep(1000);
			
			driver.findElement(By.cssSelector("[name = 'recardnumber']")).sendKeys("6078790000000001");
			driver.findElement(By.cssSelector("[name = 'cardExpiry']")).sendKeys("1023");
			driver.findElement(By.cssSelector("[name = 'DE03account']")).sendKeys("00");
			driver.findElement(By.cssSelector("[name ='DE03Toaccount']")).sendKeys("00");
			driver.findElement(By.cssSelector("[name = 'cvctrack']")).sendKeys("123");
			driver.findElement(By.cssSelector("[name = 'terminalid']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[name='sInput']")).sendKeys("86379560");
			driver.findElement(By.name("searchData")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[name='selectOne']")).click();
			driver.findElement(By.cssSelector("[name = 'encryptionInd']")).sendKeys("03");
			// driver.findElement(By.cssSelector("[name =
			// 'panentrymode']")).sendKeys(panentry);
			// driver.findElement(By.cssSelector("[name =
			// 'pinentrymode']")).sendKeys(pinentry);
			// driver.findElement(By.cssSelector("[name =
			// 'posentrymode']")).sendKeys(posservice);
			driver.findElement(By.cssSelector("[name = 'txnAmt']")).sendKeys(String.valueOf(b));
			driver.findElement(By.cssSelector("[name = 'invoicenumber']")).sendKeys("123456");
			jse.executeScript("window.scrollBy(0,-1500)");
			Thread.sleep(500);
			driver.findElement(By.cssSelector("[id='submitBtn']")).click();
			Thread.sleep(3500);
			// String rrn =
			// driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-bottom-sheet-container/app-auth-simulation-sheet/section/section/div[2]/div[1]/p[2]")).getText();
			// System.out.println(rrn);
			// extract RRN
			String popup = driver.findElement(By.xpath(
					"/html/body/div[2]/div[2]/div/mat-bottom-sheet-container/app-auth-simulation-sheet/section/section/div[1]/h3"))
					.getText();
			Thread.sleep(2000);
			System.out.println(popup);
			if (popup.equals("AUTHORIZATION RESPONSE DETAILS")) {
				String rrn = driver.findElement(By.xpath(
						"/html/body/div[2]/div[2]/div/mat-bottom-sheet-container/app-auth-simulation-sheet/section/section/div[2]/div[1]/p[2]"))
						.getText();
				System.out.println(rrn);
				ouptut = rrn;
				System.out.println("Transaction Submitted Successfully");
				Thread.sleep(1000);
			}
			driver.get("https://ops.dev.toucanus.net/");
			driver.findElement(By.cssSelector("[name='f1']")).sendKeys("nagaraju");
			driver.findElement(By.cssSelector("[name='f2']")).sendKeys("Password@123");
			driver.findElement(By.cssSelector("[name='login1']")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("[id='smenu']")).click();
			driver.findElement(By.cssSelector("[id='ter']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[name='tNumber']")).sendKeys("86379560");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("[id='searchBtn']")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("[id='inqBtn']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()=' Transactions ']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[text()='Unsettlement Txn']")).click();
			Thread.sleep(5000);
			WebElement output = driver.findElement(By.xpath("//*[text()=" + ouptut + "]"));
			if (output.isDisplayed()) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}

			Thread.sleep(3000);
		}

	}

}
