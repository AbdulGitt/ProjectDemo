package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	// public static WebDriver browserLaunch(String bname) {
	// if(bname.equalsIgnoreCase("chrome")) {
	// WebDriverManager.chromedriver().setup();
	// driver = new ChromeDriver();
	// }
	// else if(bname.equalsIgnoreCase("edge")) {
	// WebDriverManager.edgedriver().setup();
	// driver=new EdgeDriver();
	// }
	// else {
	// System.out.println("Invalid browser");
	// }
	// return driver;
	//
	// }

	public static WebDriver browserLaunch(String bname) {
		switch (bname) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Invalid browser");

		}
		return driver;

	}

	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void sendKeys(WebElement e, String value) {
		e.sendKeys(value);
	}

	public static void click(WebElement e) {
		e.click();
	}

	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void quit() {
		driver.quit();
	}

	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}

	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;

	}

	public static void accept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public static void dismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static void movetoElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	public static void draganddrop(WebElement src, WebElement des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des).perform();

	}

	public static void selectByindex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}

	public static void selectByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByValue(value);
	}

	public static void toUrl(String url) {
		driver.navigate().to(url);

	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void frameByindex(int index) {
		driver.switchTo().frame(index);
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public static String currentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}

	public static Set<String> allWindowId() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

//	public static String readExcel(String excelname,String sheet,int rowno,int cellno) throws IOException {
//		File f = new File("C:\\Users\\abdul\\eclipse-workspace\\MavenSep11AmBatch\\src\\test\\resources\\"+excelname+".xlsx");
//		FileInputStream fi = new FileInputStream(f);
//		Workbook w = new XSSFWorkbook(fi);
//		Sheet s = w.getSheet(sheet);
//		Row r = s.getRow(rowno);
//		Cell cell = r.getCell(cellno);		
//		int cellType = cell.getCellType();
//		String value=null;
//		if (cellType == 1) {
//			 value = cell.getStringCellValue();
//		} else if (DateUtil.isCellDateFormatted(cell)) {
//			Date d = cell.getDateCellValue();
//			SimpleDateFormat df = new SimpleDateFormat("DD-MM-YYYY");
//			 value = df.format(d);
//		} else {
//			double nc = cell.getNumericCellValue();
//			long l = (long) nc;
//			 value = String.valueOf(l);
//		}
//		return value;
//
//	}

}
