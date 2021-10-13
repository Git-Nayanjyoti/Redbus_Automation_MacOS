package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;
import com.timestamp.DateTimePicker;

import java.text.ParseException;

public class BusHirePage extends Base {
	static WebElement busHireOptions;
	DateTimePicker DTPicker = new DateTimePicker();

	// method to click on Bus Hire button in homepage
	public void clickBusHire() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("redBus Bus Hire")).click();
	}

	// method to click on outstatin button inside Bus Hire
	public void clickOutStation() throws InterruptedException {
		busHireOptions = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/object"));
		driver.switchTo().frame(busHireOptions);

		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[1]")).click();
		Thread.sleep(2000);
	}

	// method to click on Local button inside Bus Hire
	public void selectLocal() throws InterruptedException {
		WebElement frame = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/object"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]")).click();
		Thread.sleep(3000);
	}

	// method to click on Airport button inside Bus Hire
	public void clickAirport() throws InterruptedException {
		WebElement frame = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/object"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]")).click();
		Thread.sleep(3000);
	}

	// method to enter Pickup Loaction
	public void EnterPickupLocation(String pick) throws InterruptedException {
		driver.findElement(By.id("locationTextFieldLocal")).sendKeys(pick);
		Thread.sleep(2000);

		List<WebElement> option1 = driver.findElement(By.xpath("/html/body/ul[2]")).findElements(By.tagName("li"));
		for (int i = 0; i < option1.size(); i++) {
			List<WebElement> spans = option1.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(pick)) {
				spans.get(1).click();
			}
		}
	}

	// method to enter the destination
	public void EnterDestination(String destiny) throws InterruptedException {
		driver.findElement(By.id("local_dest_name")).sendKeys(destiny);
		Thread.sleep(2000);
		List<WebElement> option2 = driver.findElement(By.xpath("/html/body/ul[3]")).findElements(By.tagName("li"));
		for (int i = 0; i < option2.size(); i++) {
			List<WebElement> spans = option2.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(destiny)) {
				spans.get(1).click();
			}
		}
	}

	// method to enter date and time from when the bus is required
	public void EnterDateTime(String inDate, String intime) throws InterruptedException, ParseException {
		// Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("OSLeadGen_DoJStart")).click();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("OSLeadGen_DoJStart")));
		DTPicker.dateAndTime(inDate, intime);

	}

	// method to enter the return date and time
	public void EnterReturnDateandTime(String returnDate, String returnTime)
			throws InterruptedException, ParseException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("OSLeadGen_DoJEnd")).click();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("OSLeadGen_DoJEnd")));
		DTPicker.dateAndTime(returnDate, returnTime);

	}

	// method to enter the passenger count
	public void PassengerCount(String count) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("numberOfPax")).sendKeys(count);
	}

	public void selectCity() {
		driver.findElement(By.className("select-selected")).click();
		List<WebElement> select = driver.findElement(By.className("select-items"))
				.findElements(By.className("select-item"));

		for (int item = 0; item < select.size(); item++) {
			if (select.get(item).getText().equals("Hyderabad")) {
				select.get(item).click();
			}
		}
	}

	// method to click on proceed button of outstation
	public void ProceedOutstation() throws InterruptedException {
		driver.findElement(By.id("proceedButtonOutstation")).click();
		Thread.sleep(2000);
		closeDriver();
	}

	// mehtod to click on Oneway Trip option
	public void ClickOnewayTrip() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("oneway")).click();
	}

	// end of Bus Hire Outstation

	public void enterPickLocAirport(String pick) throws InterruptedException {
		driver.findElement(By.id("locationTextFieldLocal")).sendKeys(pick);
		Thread.sleep(2000);

		List<WebElement> option1 = driver.findElement(By.xpath("/html/body/ul")).findElements(By.tagName("li"));
		for (int i = 0; i < option1.size(); i++) {
			List<WebElement> spans = option1.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(pick)) {
				spans.get(1).click();
			}
		}
	}

	public void clickDropToAirport() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("to_airport")).click();
	}

	public void clicksProceedAirport() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("proceedButtonAirport")).click();
	}

	public void clicksLocal() throws InterruptedException {
		WebElement frame = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/object"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]")).click();
		Thread.sleep(3000);
	}

	public void selectDateforLocal() throws InterruptedException {
		Thread.sleep(2000);
		WebElement datefield = driver.findElement(By.id("from_datepicker"));
		Actions df = new Actions(driver);
		df.moveToElement(datefield).click().perform();
	}

}