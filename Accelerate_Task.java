package com.demoqa.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.baseClass.BaseClass;
import com.demoqa.dataUtile.DataUtile;
import com.demoqa.dataUtile.WriteExcel;

public class Accelerate_Task extends BaseClass {

	public static int Count1 = 1;
	public static int Count2 = 1;

	@Test(priority = 1, dataProvider = "getData", dataProviderClass = DataUtile.class)

	public void Fillthetextboxform(String data[]) throws InterruptedException, IOException {
		navigatetoSite();
		// public void Fillthetextboxform () throws InterruptedException, IOException {
		// driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		By elementTextbox = By.xpath("//h5[text()='Elements']");
		waitForElement(elementTextbox);
		scrolltoElement(elementTextbox);
		clicktheElement(elementTextbox);

		// driver.findElement(By.linkText("Text Box")).click();
		By TextBox = By.xpath("//span[text()='Text Box']");
		waitForElement(TextBox);
		clicktheElement(TextBox);

		String FullName = data[0] + " " + data[1];
//		System.out.println("FName: "+data[0]);
//		System.out.println("LName: "+data[1]);
//		System.out.println("FullName: "+FullName);
//		System.out.println("Email: "+data[1]);
//		System.out.println("CurrentAddress: "+data[6]);
//		System.out.println("PermanentAddress: "+data[6]);

		// driver.findElement(By.id("userName")).sendKeys("Aswin");
		By usernameTextbox = By.id("userName");
		waitForElement(usernameTextbox);
		sendValuestoElement(usernameTextbox, FullName);
		// driver.findElement(By.id("userEmail")).sendKeys("ar_23@gmail.com");
		By emailTextbox = By.id("userEmail");
		waitForElement(emailTextbox);
		sendValuestoElement(emailTextbox, data[2]);
		// driver.findElement(By.id("currentAddress")).sendKeys("Test");
		By currentAddressTextbox = By.id("currentAddress");
		waitForElement(currentAddressTextbox);
		sendValuestoElement(currentAddressTextbox, data[7]);
		// driver.findElement(By.id("permanentAddress")).sendKeys("Test");
		By permanentAddressTextbox = By.id("permanentAddress");
		waitForElement(permanentAddressTextbox);
		sendValuestoElement(permanentAddressTextbox, data[7]);
		// driver.findElement(By.id("submit")).click();
		By submitTextbox = By.id("submit");
		waitForElement(submitTextbox);
		scrolltoElement(submitTextbox);
		clicktheElement(submitTextbox);

		// driver.findElement(By.xpath("//button[.='LOGIN']")).click();
		// String output1 = driver.findElement(By.id("userForm")).getText();
		By getTextTextbox = By.id("userForm");
		waitForElement(getTextTextbox);
		String output1 = getTextElement(getTextTextbox);
		System.out.println("Output1 is: " + output1);

		// writing in excel
		WriteExcel obj = new WriteExcel();
		obj.writeData("Student_data", output1, Count1, 8);
		Count1++;
	}

	@Test(priority = 2, dataProvider = "getData", dataProviderClass = DataUtile.class)
	public void FillthePracticeform(String data[]) throws InterruptedException, IOException {
		navigatetoSite();

		By elementTextbox = By.xpath("//h5[text()='Elements']");
		waitForElement(elementTextbox);
		scrolltoElement(elementTextbox);
		clicktheElement(elementTextbox);

		By clickForms = By.xpath("//div[text()='Forms']");
		waitForElement(clickForms);
		scrolltoElement(clickForms);
		clicktheElement(clickForms);

		By clickPracticeform = By.xpath("//span[text()='Practice Form']");
		waitForElement(clickPracticeform);
		clicktheElement(clickPracticeform);

		By titleOfTheForm = By.xpath("//div[text()='Practice Form']");
		String actualFormHeader = getTextElement(titleOfTheForm);
		String expectedFormheader = "Practice Form";
		Assert.assertEquals(actualFormHeader, expectedFormheader);
		System.out.println("Assertion is true and actual header matches with the expected header of Practice form");

		By fnameTextForm = By.id("firstName");
		waitForElement(fnameTextForm);
		sendValuestoElement(fnameTextForm, data[0]);

		By lnameTextForm = By.id("lastName");
		waitForElement(lnameTextForm);
		sendValuestoElement(lnameTextForm, data[1]);

		By emailTextForm = By.id("userEmail");
		waitForElement(emailTextForm);
		sendValuestoElement(emailTextForm, data[2]);

		By MaleRadio = By.xpath("//input[@value='Male']");
		String Male = getAttribute(MaleRadio, "value");

		By FemaleRadio = By.xpath("//input[@value='Female']");
		String Female = getAttribute(FemaleRadio, "value");

		By otherRadio = By.xpath("//input[@value='Other']");
		String Others = getAttribute(otherRadio, "value");

		if (Male.equals(data[3])) {
			By MaleRadioButton = By.xpath("//input[@value='Male']//parent::*//label");
			// scrolltoElement(MaleRadioButton);
			movetoElement(MaleRadioButton);

		} else if (Female.equals(data[3])) {
			By FemaleRadioButton = By.xpath("//input[@value='Female']//parent::*//label");
			// scrolltoElement(FemaleRadioButton);
			movetoElement(FemaleRadioButton);
		} else if (Others.equals(data[3])) {
			By otherRadioButton = By.xpath("//input[@value='Other']//parent::*//label");
			// scrolltoElement(otherRadioButton);
			movetoElement(otherRadioButton);
		}

		By mobileTextForm = By.id("userNumber");
		waitForElement(mobileTextForm);
		sendValuestoElement(mobileTextForm, data[4]);

		// Find the date picker element and click it
		By datePicker = By.id("dateOfBirthInput");
		waitForElement(datePicker);
		clicktheElement(datePicker);

		String date = data[5];
		// System.out.println("date is:"+ date);
		String[] parts = date.split("-");
		String day = parts[0];
		// System.out.println("day is:"+ day);
		String month = parts[1];
		// System.out.println("month is:"+ month);
		String year = parts[2];
		// System.out.println("year is:"+ year);

		// Select the month from the drop-down list
		Select monthDropdown = new Select(
				driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));

		switch (month) {
		case "Jan":
			monthDropdown.selectByVisibleText("January");
			break;
		case "Feb":
			monthDropdown.selectByVisibleText("February");
			break;
		case "Mar":
			monthDropdown.selectByVisibleText("March");
			break;
		case "Apr":
			monthDropdown.selectByVisibleText("April");
			break;
		case "May":
			monthDropdown.selectByVisibleText("May");
			break;
		case "Jun":
			monthDropdown.selectByVisibleText("June");
			break;
		case "Jul":
			monthDropdown.selectByVisibleText("July");
			break;
		case "Aug":
			monthDropdown.selectByVisibleText("August");
			break;
		case "Sep":
			monthDropdown.selectByVisibleText("September");
			break;
		case "Oct":
			monthDropdown.selectByVisibleText("October");
			break;
		case "Nov":
			monthDropdown.selectByVisibleText("November");
			break;
		case "Dec":
			monthDropdown.selectByVisibleText("December");
			break;
		}

		// Select the year from the drop-down list
		Select yearDropdown = new Select(
				driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		yearDropdown.selectByVisibleText(year);

		// Select the day from the calendar
		By dayElement = By.xpath(
				"//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div/div[contains(text()," + day + ")]");
		clicktheElement(dayElement);

		String sub = data[6];
		System.out.println("sub is:" + sub);
		String[] parts1 = sub.split(",");
		String sub1 = parts1[0];
		System.out.println("sub1 is:" + sub1);
		String sub2 = parts1[1];
		System.out.println("sub2 is:" + sub2);

		By subject1 = By.xpath("//div[contains(@class,'--is-multi css-1hwfws3')]/div/div/input");
		sendValuestoElement(subject1, sub1);
		By suggestion0 = By.id("react-select-2-option-0");
		movetoElement(suggestion0);

		By subject2 = By.xpath("//*[@class='css-1g6gooi']/div/input");
		sendValuestoElement(subject2, sub2);
		By suggestion1 = By.id("react-select-2-option-0");
		movetoElement(suggestion1);

		By checkboxdefault = By.xpath("//label[contains(text(),'Sports')]");
		waitForElement(checkboxdefault);
		scrolltoElement(checkboxdefault);
		clicktheElement(checkboxdefault);

		By currentAddressTextForm = By.id("currentAddress");
		waitForElement(currentAddressTextForm);
		sendValuestoElement(currentAddressTextForm, data[7]);
		Thread.sleep(3000);

		By state = By.id("state");
		waitForElement(state);
		movetoElement(state);
		By stateSelection = By.id("react-select-3-option-1");
		waitForElement(stateSelection);
		movetoElement(stateSelection);
		// clicktheElement(stateSelection);
		Thread.sleep(3000);

		By city = By.id("city");
		waitForElement(city);
		clicktheElement(city);
		// sendValuestoElement(city, "Lucknow");
		By citySelection = By.id("react-select-4-option-1");
		waitForElement(citySelection);
		clicktheElement(citySelection);

		By submitTextForm = By.id("submit");
		waitForElement(submitTextForm);
		clicktheElement(submitTextForm);
		Thread.sleep(3000);

		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		driver.switchTo().window(windowHandle);

		By SubmitWindow = By.id("example-modal-sizes-title-lg");
		System.out.println("Submit Form window geetings: " + getTextElement(SubmitWindow));
		String tyPage = getTextElement(SubmitWindow);

		WriteExcel obj = new WriteExcel();
		obj.writeData("Student_data", tyPage, Count2, 9);
		Count2++;

		By closeButton = By.id("closeLargeModal");
		clicktheElement(closeButton);

	}
}