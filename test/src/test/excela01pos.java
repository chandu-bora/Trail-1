package test;

import java.io.File;
import java.io.FileInputStream;
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

public class excela01pos {

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
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		driver.get("https://unittest.dev.toucanus.net/");
		Thread.sleep(1000);
		driver.findElement(By.name("f1")).sendKeys("dubaitest");
		driver.findElement(By.name("f2")).sendKeys("Password@123");
		driver.findElement(By.name("login1")).click();
		Thread.sleep(1000);

		FileInputStream file = new FileInputStream("/home/chandrasekhar/Downloads/POS transactions.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet s = wb.getSheet("Dubai");
		int row = s.getLastRowNum();
		int coloumn = s.getRow(0).getLastCellNum();
		// System.out.println(coloumn);

		for (int rownum = 1; rownum <= row; rownum++) {
			XSSFRow currentrow = s.getRow(rownum);

			String cardno = currentrow.getCell(1).getStringCellValue();
			String recardno = currentrow.getCell(1).getStringCellValue();
			int expi = (int) currentrow.getCell(2).getNumericCellValue();
			String expiry = String.valueOf(expi);
			String def = currentrow.getCell(3).getStringCellValue();
			String det = currentrow.getCell(3).getStringCellValue();
			int cvctrack = (int) currentrow.getCell(4).getNumericCellValue();
			String cvc = String.valueOf(cvctrack);
			// int terminalno = (int) currentrow.getCell(0).getNumericCellValue();
			// String terminal = String.valueOf(terminalno);
			String terminal = currentrow.getCell(0).getStringCellValue();
			String encid = currentrow.getCell(5).getStringCellValue();
			int txnamount = (int) currentrow.getCell(6).getNumericCellValue();
			String amount = String.valueOf(txnamount);
			int invcno = (int) currentrow.getCell(7).getNumericCellValue();
			String invc = String.valueOf(invcno);
			// String invc = currentrow.getCell(7).getStringCellValue();

			driver.get(
					"https://unittest.dev.toucanus.net/#/simulation/details?authType=Normal%20Authorization%20-%20Swipe%20and%20signature&screenIdDisplay=1&authCode=A01");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[name = 'cardnumber']")).sendKeys(cardno);
			driver.findElement(By.cssSelector("[name = 'recardnumber']")).sendKeys(recardno);
			driver.findElement(By.cssSelector("[name = 'cardExpiry']")).sendKeys(expiry);
			driver.findElement(By.cssSelector("[name = 'DE03account']")).sendKeys(def);
			driver.findElement(By.cssSelector("[name ='DE03Toaccount']")).sendKeys(det);
			driver.findElement(By.cssSelector("[name = 'cvctrack']")).sendKeys(cvc);
			driver.findElement(By.cssSelector("[name = 'terminalid']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[name='sInput']")).sendKeys(terminal);
			driver.findElement(By.name("searchData")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[name='selectOne']")).click();
			driver.findElement(By.cssSelector("[name = 'encryptionInd']")).sendKeys(encid);
			// driver.findElement(By.cssSelector("[name =
			// 'panentrymode']")).sendKeys(panentry);
			// driver.findElement(By.cssSelector("[name =
			// 'pinentrymode']")).sendKeys(pinentry);
			// driver.findElement(By.cssSelector("[name =
			// 'posentrymode']")).sendKeys(posservice);
			driver.findElement(By.cssSelector("[name = 'txnAmt']")).sendKeys(amount);
			driver.findElement(By.cssSelector("[name = 'invoicenumber']")).sendKeys(invc);
			Thread.sleep(500);
			jse.executeScript("window.scrollBy(0,-1500)");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[id='submitBtn']")).click();
			Thread.sleep(1000);
			String rrn = driver.findElement(By.xpath(
					"/html/body/div[2]/div[2]/div/mat-bottom-sheet-container/app-auth-simulation-sheet/section/section/div[2]/div[1]/p[2]"))
					.getText();
			System.out.println(rrn);

			System.out.println("Transaction Submitted Successfully");
			Thread.sleep(1000);
			currentrow.createCell(8).setCellValue(rrn);
			FileOutputStream out = new FileOutputStream(
					new File("/home/chandrasekhar/Downloads/POS transactions.xlsx"));
			wb.write(out);
			Thread.sleep(1000);

		}

	}

}
