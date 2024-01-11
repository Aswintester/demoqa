package com.demoqa.baseClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static WebDriver driver = null;

	@SuppressWarnings("deprecation")

	@BeforeTest // webdriver initiation
	public void driver() {
		System.setProperty("webdriver.chrome.driver", "/C:/Users/aswinkumar.r/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// URL navigation and Maximizing
	public void navigatetoSite() throws InterruptedException {
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	// closing the browser
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	// ExplicitWait method
	public void waitForElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	// SendKeys method
	public void sendValuestoElement(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	// click method
	public void clicktheElement(By by) {
		driver.findElement(by).click();
	}

	// getText method
	public String getTextElement(By by) {
		String value = driver.findElement(by).getText();
		return value;
	}

	// scroll to element method
	public void scrolltoElement(By by) throws InterruptedException {
		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}

	// getTitle method
	public String gettheTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static By webElement(By by) {
		driver.findElement(by);
		return by;
	}

	// getAttribute method
	public String getAttribute(By by, String value) {
		String attribute = driver.findElement(by).getAttribute(value);
		return attribute;
	}

	// Clear method
	public void clearTheField(By by) {
		driver.findElement(by).clear();
	}

	// DropDown selection by visible Text
	public void selectDDbyVisibleText(By by, String value) {
		Select DropDown = new Select((WebElement) by);
		DropDown.selectByVisibleText(value);

	}

	// Action class to handle click
	public void movetoElement(By by) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(by)).click().perform();
	}

}
