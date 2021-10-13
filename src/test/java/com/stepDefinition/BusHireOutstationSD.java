package com.stepDefinition;

import java.text.ParseException;

import com.base.Base;
import com.pages.BusHirePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusHireOutstationSD extends Base {
	BusHirePage BHPage = new BusHirePage(); 

	@Given("User is on Home page")
	public void user_is_on_home_page() {
		// calling chrome driver and get redbus.in
		initialization();
	}

	@When("User clicks on Bus hire")
	public void user_clicks_on_bus_hire() {
		try {
			// calling the method to click on Bus Hire button in the homepage
			BHPage.clickBusHire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("User clicks on OutStation")
	public void user_clicks_on_out_station() {
		try {
			// calling the method to click on Bus Station button inside Bus Hire
			BHPage.clickOutStation();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enters pickup location")
	public void user_enters_pickup_location() {
		try {
			// Entering the pickup loaction in pickup field
			// getting pickup data from data.properties
			BHPage.EnterPickupLocation(prop.getProperty("PickUp"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enter destination")
	public void user_enter_destination() {
		try {
			// Enter the destination in destination field
			// getting the destination data from data.properties
			BHPage.EnterDestination(prop.getProperty("Destination"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enters current date")
	public void user_enters_current_date() {
		try {
			// calling the Date and Time method to enter the date and the time
			BHPage.EnterDateTime(prop.getProperty("InDate"), prop.getProperty("InTime"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("User enters return date")
	public void user_enters_return_date() {
		try {
			// calling the return Date and Time method to enter the return date and time
			BHPage.EnterReturnDateandTime(prop.getProperty("ReturnDate"), prop.getProperty("ReturnTime"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enters passenger count")
	public void user_enters_passenger_count() {
		try {
			// calling the method to enter the passenger count
			BHPage.PassengerCount(prop.getProperty("count"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User clicks on proceed and successfully hires bus")
	public void user_clicks_on_proceed_and_successfully_hires_bus() {
		try {
			// calling the method to click on proceed button of outstation
			BHPage.ProceedOutstation();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User clicks on oneWayTrip")
	public void user_clicks_on_one_way_trip() {
		try {
			// calling the method to click on oneway trip option
			BHPage.ClickOnewayTrip();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
