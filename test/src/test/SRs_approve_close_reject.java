package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SRs_approve_close_reject {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver",  "/home/nagaraju/Drivers/chromedriver");
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        driver.manage().window().maximize();
        //JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://ops.dev.toucanus.net/#/");
		//driver.get("https://bankunit.toucanus.net/#/");
		driver.findElement(By.name("f1")).sendKeys("nagaraju");
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("Password@123");
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[normalize-space()='LOGIN']")).click();
		driver.findElement(By.cssSelector("[id='smenu']")).click();
		driver.findElement(By.cssSelector("[id='sr']")).click();
		/*
		 * driver.findElement(By.cssSelector("[name='assigListValue']")).click();
		 * Thread.sleep(500);
		 * driver.findElement(By.cssSelector("[name='sInput']")).sendKeys("nagaraju");
		 * Thread.sleep(500);
		 * driver.findElement(By.cssSelector("[name='searchData']")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.cssSelector("[name='selectOne']")).click();
		 * Thread.sleep(500);
		 */
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[3]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-service-request-search[1]/div[1]/div[3]/div[1]/div[3]/mat-form-field[2]/div[1]/div[1]/div[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[normalize-space()='OPEN']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='REOPEN']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='APPROVED']")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[3]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-service-request-search[1]/div[1]/div[3]/div[1]/div[3]/mat-form-field[3]/div[1]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Statement Option']")).click();
		driver.findElement(By.cssSelector("[name='srSearch']")).click();
		Thread.sleep(500);
		int i;
		for(i=0;i<300;i++)
		{
			
			
		driver.findElement(By.cssSelector("[name='gotoInq']")).click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("actionsBtn")).click();
		Thread.sleep(500);
		String options = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div")).getText();
		//System.out.println(options);
		if(options.contains("APPROVE")) {
			driver.findElement(By.cssSelector("[id='approveBtn']")).click();
			Thread.sleep(500);
			driver.navigate().refresh();
			driver.navigate().refresh();
			//driver.get(driver.getCurrentUrl());
			Thread.sleep(500);
			driver.switchTo().frame(0);
			driver.findElement(By.id("actionsBtn")).click();
			Thread.sleep(500);
			driver.findElement(By.id("closeBtn")).click();
			Thread.sleep(500);
		}
		if(options.contains("CLOSE")) {
			driver.findElement(By.cssSelector("[id='closeBtn']")).click();
		}
        Thread.sleep(1000);		
		driver.findElement(By.cssSelector("[name='comments']")).sendKeys("A Sr closed Successfully");
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[normalize-space()='CONFIRM']")).click();
		Thread.sleep(500);
		System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-bottom-sheet-container[1]/app-sr-no[1]/div[1]/div[3]/div[1]/div[1]/p[2]")).getText());
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[normalize-space()='SERVICE REQUEST']")).click();
		Thread.sleep(500);
		}
//		
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
			
		}
		

	}

		// TODO Auto-generated method stub

	

