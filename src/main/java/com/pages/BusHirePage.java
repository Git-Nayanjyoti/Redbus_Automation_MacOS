package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;
import com.timestamp.DateTimePicker;

import java.text.ParseException;

public class BusHirePage extends Base {
	DateTimePicker DTPicker = new DateTimePicker();

	// Page Factory Implementation
	@FindBy(id = "redBus Bus Hire")
	WebElement BushireButton;

	@FindBy(xpath = "/html/body/div[1]/div/div[5]/div[2]/object")
	WebElement BusHireOptions;

	@FindBy(xpath = "/html/body/div[1]/div/div[4]/div[1]")
	WebElement OutstationButton;
	
	@FindBy(id = "locationTextFieldLocal")
	WebElement LocationField;
	
	@FindBy(id = "local_dest_name")
	WebElement DestinationField;

	@FindBy(id = "OSLeadGen_DoJStart")
	WebElement StartDateField;

	@FindBy(id = "OSLeadGen_DoJEnd")
	WebElement EndDateField;

	@FindBy(id = "numberOfPax")
	WebElement PassengerCountField;

	@FindBy(id = "proceedButtonOutstation")
	WebElement ProceedButtonOutstation;
	
	@FindBy(id = "oneway")
	WebElement OnewayButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[4]/div[2]")
	WebElement LocalButton;
	
	@FindBy(id = "LocalLeadGen_Pckage_Tap")
	WebElement PackageOptions;
	
	@FindBy(xpath = "/html/body/ul[2]")
	WebElement PickupLocDropdown;
	
	@FindBy(xpath = "/html/body/ul[3]")
	WebElement DestinationDropdown;
	
	@FindBy(id = "from_datepicker")
	WebElement DateFieldLocal;

	@FindBy(id = "proceedButtonLocal")
	WebElement ProceedLocal;
	
	@FindBy(className = "select-selected")
	WebElement CityField;
	
	@FindBy(className = "select-items")
	WebElement CityDropdown;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[4]/div[3]")
	WebElement AirportButton;
	
	@FindBy(id = "AirporLeadGen_DoJ")
	WebElement DateFieldAirport;
	
	@FindBy(id = "to_airport")
	WebElement DropToAirportButton;
	
	@FindBy(id = "proceedButtonAirport")
	WebElement ProceedButtonAirport;
	
	@FindBy(xpath = "/html/body/ul")
	WebElement AirportLocationDropdown; 
	
	// methods for Bus Hire Page

	// start of the methods for Bus Hire Outstation

	// method to click on Bus Hire button in homepage
	public void clickBusHire() throws InterruptedException {
		// initialising PageFactory
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BushireButton.click();
	}

	// method to click on outstation button inside Bus Hire
	public void clickOutStation() throws InterruptedException {
		driver.switchTo().frame(BusHireOptions);
		OutstationButton.click();
	}

	// method to enter Pickup Loaction
	public void EnterPickupLocation(String pick) throws InterruptedException {
		Thread.sleep(3000);
		LocationField.sendKeys(pick);
		List<WebElement> option1 = PickupLocDropdown.findElements(By.tagName("li"));
		for (int i = 0; i < option1.size(); i++) {
			List<WebElement> spans = option1.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(pick)) {
				spans.get(1).click();
			}
		}
	}

	// method to enter the destination
	public void EnterDestination(String destiny) throws InterruptedException {
		Thread.sleep(3000);
		DestinationField.sendKeys(destiny);
		List<WebElement> option2 = DestinationDropdown.findElements(By.tagName("li"));
		for (int i = 0; i < option2.size(); i++) {
			List<WebElement> spans = option2.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(destiny)) {
				spans.get(1).click();
			}
		}
	}

	// method to enter date and time from when the bus is required
	public void EnterDateTime(String inDate, String intime) throws InterruptedException, ParseException {
		Thread.sleep(3000);
		StartDateField.click();
		DTPicker.dateAndTime(inDate, intime);

	}

	// method to enter the return date and time
	public void EnterReturnDateandTime(String returnDate, String returnTime)
			throws InterruptedException, ParseException {
		Thread.sleep(3000);
		EndDateField.click();
		DTPicker.dateAndTime(returnDate, returnTime);

	}

	// method to enter the passenger count
	public void PassengerCount(String count) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PassengerCountField.sendKeys(count);
	}

	// method to click on proceed button of outstation
	public void ProceedOutstation() throws InterruptedException {
		ProceedButtonOutstation.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		closeDriver();
	}

	// mehtod to click on Oneway Trip option
	public void ClickOnewayTrip() throws InterruptedException {
		Thread.sleep(2000);
		OnewayButton.click();
	}

	// end of methods for Bus Hire Outstation

	// Bus hire for local

	// method to click on local
	public void clickLocal() throws InterruptedException {
		driver.switchTo().frame(BusHireOptions);
		LocalButton.click();
	}

	// method to enter pickup location for local and chose it from the dropdown
	public void EnterPickupLoactionLocal(String pick) throws InterruptedException {
		Thread.sleep(2000);
		LocationField.sendKeys(pick);
		List<WebElement> option1 = driver.findElement(By.xpath("/html/body/ul[1]")).findElements(By.tagName("li"));
		for (int i = 0; i < option1.size(); i++) {
			List<WebElement> spans = option1.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(pick)) {
				spans.get(1).click();
			}
		}
	}

	// method to select the package for local
	public void Package(String packageName) throws InterruptedException {
		List<WebElement> object = PackageOptions
				.findElements(By.tagName("label"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		for (int obj = 0; obj < object.size(); obj++) {
			if (object.get(obj).getText().equals(packageName)) {
				object.get(obj).click();
				break;
			}
		}
	}

	// method to enter date and time for local from when the bus is required
	public void EnterDateTimeLocal(String inDate, String intime) throws InterruptedException, ParseException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DateFieldLocal.click();
		DTPicker.dateAndTime(inDate, intime);

	}

	// method to click on the proceed button for local
	public void clickProceedLocal() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		ProceedLocal.click();
		closeDriver();
	}

	// End of Bus Hire Local methods

	// Start of methods for Airport

	// method to click on Airport button inside Bus Hire
	public void clickAirport() throws InterruptedException {
		driver.switchTo().frame(BusHireOptions);
		AirportButton.click();
	}

	// method to select the city form the dropdown.
	public void selectCity(String city) throws InterruptedException {
		Thread.sleep(3000);
		CityField.click();
		List<WebElement> select = CityDropdown
				.findElements(By.className("select-item"));

		for (int item = 0; item < select.size(); item++) {
			if (select.get(item).getText().equals(city)) {
				select.get(item).click();
			}
		}
	}

	// method to enter the destination for airport
	public void EnterDestinationAirport(String pick) throws InterruptedException {
		Thread.sleep(3000);
		LocationField.sendKeys(pick);
		List<WebElement> option1 = AirportLocationDropdown.findElements(By.tagName("li"));
		for (int i = 0; i < option1.size(); i++) {
			List<WebElement> spans = option1.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(pick)) {
				spans.get(1).click();
			}
		}
	}

	// method to enter date and time for local from when the bus is required
	public void EnterDateTimeAirport(String inDate, String intime) throws InterruptedException, ParseException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DateFieldAirport.click();
		DTPicker.dateAndTime(inDate, intime);
	}

	// method to click on the drop to airport option.
	public void clickDropToAirport() throws InterruptedException {
		Thread.sleep(2000);
		DropToAirportButton.click();
	}

	// method to click on the proceed button of Airport.
	public void clickProceedAirport() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		ProceedButtonAirport.click();
		closeDriver();
	}

	// method to enter pickup location for Airport and chose it from the dropdown
	public void EnterPickLocAirport(String pick) throws InterruptedException {
		Thread.sleep(3000);
		LocationField.sendKeys(pick);
		List<WebElement> option1 = AirportLocationDropdown.findElements(By.tagName("li"));
		for (int i = 0; i < option1.size(); i++) {
			List<WebElement> spans = option1.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(pick)) {
				spans.get(1).click();
			}
		}
	}

	// end of methods for the Airport

}