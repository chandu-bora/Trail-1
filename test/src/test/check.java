package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class check {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

				// TODO Auto-generated method stub
				
				//System.setProperty("webdriver.chrome.driver",  "/home/nagaraju/Drivers/chromedriver");
		        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		        driver.manage().window().maximize();
		        //JavascriptExecutor jse = (JavascriptExecutor)driver;
				
				driver.get("https://merchant.dev.toucanus.net/#/auth");
				driver.findElement(By.xpath("//span[normalize-space()='LOG IN']")).click();
				driver.findElement(By.xpath("//span[normalize-space()='User']")).click();
				driver.findElement(By.name("f1")).sendKeys("1gmycxnkm6");
				driver.findElement(By.cssSelector("[type='password']")).sendKeys("Password@123");
				Thread.sleep(500);
				driver.findElement(By.xpath("//span[normalize-space()='LOGIN']")).click();
				int i;
				int j=200;
				for(i=0;i<3;i++)
				{
					
					int b = j+i;
					
				//driver.findElement(By.xpath("//span[normalize-space()='menu']")).click();
				//Thread.sleep(2000);
				//driver.findElement(By.cssSelector("div[class='tou-pageContainer']")).click();
				//driver.findElement(By.xpath("//div[normalize-space()='Requests']")).click();
				//Thread.sleep(1000);
				//driver.findElement(By.xpath("//span[normalize-space()='menu']")).click();
				//Thread.sleep(2000);
				driver.findElement(By.cssSelector("[name='checkout']")).click();
				Thread.sleep(500);
				driver.switchTo().frame(0);
				Thread.sleep(500);
				driver.findElement(By.name("terminalid")).click();
				Thread.sleep(500);
				driver.findElement(By.name("sInput")).sendKeys("18794518");
				Thread.sleep(2000);
				driver.findElement(By.name("searchData")).click();
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("[name='selectOne']")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("[name='testPymt']")).click();
				driver.findElement(By.cssSelector("[name='txnAmt']")).sendKeys(String.valueOf(b));
				Thread.sleep(500);
				//jse.executeScript("window.scrollBy(0,-1500)");
				//Thread.sleep(500);
				//driver.findElement(By.cssSelector("p[class='m-14-06 spc-24']")).click();
				//Thread.sleep(1000);
				driver.findElement(By.cssSelector("[name='payBtn']")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("[name='cardNumber']")).sendKeys("5123450000000001");
				driver.findElement(By.cssSelector("[name='cardExpiry']")).sendKeys("1023");
				driver.findElement(By.cssSelector("[name='cvv']")).sendKeys("123");
				driver.findElement(By.cssSelector("[name='name']")).sendKeys("raju");
				driver.findElement(By.cssSelector("[name='payBtn']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[normalize-space()='SUBMIT']")).click();
				Thread.sleep(4000);
				System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[2]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-shopping-cart[1]/section[1]/div[1]/div[1]/div[6]/div[1]/p[2]")).getText());
					
				}
				

			}

		}

	