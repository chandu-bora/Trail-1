package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SRreject {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        driver.manage().window().maximize();
        //driver.get("https://ops.demo.toucanus.net/#/");
		driver.get("https://bankunit.toucanus.net/#/");
		driver.findElement(By.name("f1")).sendKeys("nagaraju");
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("Password@2");
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[normalize-space()='LOGIN']")).click();
		driver.findElement(By.cssSelector("[id='smenu']")).click();
		driver.findElement(By.cssSelector("[id='sr']")).click();
		driver.findElement(By.cssSelector("[name='assigListValue']")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("[name='sInput']")).sendKeys("nagaraju");
		Thread.sleep(500);
		driver.findElement(By.cssSelector("[name='searchData']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[name='selectOne']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[3]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-service-request-search[1]/div[1]/div[3]/div[1]/div[3]/mat-form-field[2]/div[1]/div[1]/div[1]")).click();
		Thread.sleep(500);
		//driver.findElement(By.xpath("//span[normalize-space()='OPEN']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='REOPEN']")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[3]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-service-request-search[1]/div[1]/div[3]/div[1]/div[3]/mat-form-field[3]/div[1]/div[1]/div[1]")).click();
		//Thread.sleep(500);
		//driver.findElement(By.xpath("//span[normalize-space()='Sr Pos Terminal Initialization']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='Merchant Deinstallation']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='Merchant Active Inactive']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='Terminaldeinstallation']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='Operating Times']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='Terminal Active Inactive']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Additional Terminals']")).click();
		driver.findElement(By.cssSelector("[name='srSearch']")).click();
		Thread.sleep(500);
		int i;
		for(i=0;i<100;i++)
		{
			
		String srno = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[3]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-service-request-search[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")).getText();
	
		driver.findElement(By.cssSelector("[name='gotoInq']")).click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("actionsBtn")).click();
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("[id='rejectBtn']")).click();
		Thread.sleep(500);
	
		driver.findElement(By.cssSelector("[name='reason']")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("[id='reopt_0']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[normalize-space()='CONFIRM']")).click();
		Thread.sleep(500);
		System.out.println(srno);
		driver.findElement(By.cssSelector("[type='button']")).click();
		}
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
			
		}
		

    

}
