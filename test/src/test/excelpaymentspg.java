package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class excelpaymentspg {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        driver.manage().window().maximize();
        //JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		/*
		 * driver.get("https://merchantunit.toucanus.net/#/auth");
		 * driver.findElement(By.xpath("//span[normalize-space()='LOG IN']")).click();
		 * driver.findElement(By.xpath("//span[normalize-space()='User']")).click();
		 * driver.findElement(By.name("f1")).sendKeys("gg1tcrkvet");
		 * driver.findElement(By.cssSelector("[type='password']")).sendKeys(
		 * "Password@14"); Thread.sleep(500);
		 * driver.findElement(By.xpath("//span[normalize-space()='LOGIN']")).click();
		 */
		
		FileInputStream file = new FileInputStream("/home/chandrasekhar/Downloads/PG transactions.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet s = wb.getSheet("Dubai");
		int row = s.getLastRowNum();
		int coloumn = s.getRow(0).getLastCellNum();
		//System.out.println(coloumn);
		
		for(int rownum=1; rownum<=row; rownum++)
		{
			XSSFRow currentrow = s.getRow(rownum);
			
			int  tid = (int) currentrow.getCell(2).getNumericCellValue();
			String terminal = String.valueOf(tid);
			//String terminal = currentrow.getCell(1).getStringCellValue();
			int txnamount = (int) currentrow.getCell(3).getNumericCellValue();
			String amount = String.valueOf(txnamount);
			//String amount = currentrow.getCell(2).getStringCellValue();
			String cardno = currentrow.getCell(4).getStringCellValue();
			//int card = (int) currentrow.getCell(2).getNumericCellValue();
			//String cardno = String.valueOf(card);
			
			int expir = (int) currentrow.getCell(5).getNumericCellValue();
			String expiry = String.valueOf(expir);
			int cvc = (int) currentrow.getCell(6).getNumericCellValue();
			String cvctrack = String.valueOf(cvc);
			//String name = currentrow.getCell(5).getStringCellValue();
			//String userid = String.valueOf(cvc);
			String userid = currentrow.getCell(0).getStringCellValue();
			//String passwd = String.valueOf(cvc);
			String passwd = currentrow.getCell(1).getStringCellValue();
			
			
			
			driver.get("https://merchant.dev.toucanus.net/#/auth");
			driver.findElement(By.xpath("//span[normalize-space()='LOGIN']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='User']")).click();
			driver.findElement(By.name("f1")).sendKeys(userid);
			driver.findElement(By.cssSelector("[type='password']")).sendKeys(passwd);
			
			driver.findElement(By.xpath("//span[normalize-space()='LOGIN']")).click();
			
			driver.findElement(By.cssSelector("[name='checkout']")).click();
			Thread.sleep(500);
			driver.switchTo().frame(0);
			Thread.sleep(500);
			driver.findElement(By.cssSelector("[name='terminalid']")).click();
			Thread.sleep(500);
			driver.findElement(By.name("sInput")).sendKeys(terminal);
			Thread.sleep(1000);
			driver.findElement(By.name("searchData")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[name='selectOne']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[id='testPymt']")).click();
			driver.findElement(By.cssSelector("[name='txnAmt']")).sendKeys(amount);
			Thread.sleep(500);
			driver.findElement(By.cssSelector("[name='payBtn']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[name='cardNumber']")).sendKeys(cardno);
			driver.findElement(By.cssSelector("[name='cardExpiry']")).sendKeys(expiry);
			driver.findElement(By.cssSelector("[name='cvv']")).sendKeys(cvctrack);
			driver.findElement(By.cssSelector("[name='name']")).sendKeys("raju");
			driver.findElement(By.cssSelector("[name='payBtn']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='SUBMIT']")).click();
			Thread.sleep(1000);
			String rrn = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[2]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-shopping-cart[1]/section[1]/div[1]/div[1]/div[6]/div[1]/p[2]")).getText();
			Thread.sleep(1000);
			System.out.println(rrn);
		
			System.out.println("Transaction Submitted Successfully");
			Thread.sleep(1000);	
			currentrow.createCell(8).setCellValue(rrn);
			FileOutputStream out = new FileOutputStream(new File("/home/chandrasekhar/Downloads/PG transactions.xlsx"));
			wb.write(out);
			Thread.sleep(1000);	
			
			
		}
		

	}

}
