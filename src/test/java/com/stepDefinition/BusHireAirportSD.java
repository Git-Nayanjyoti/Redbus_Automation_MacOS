package com.stepDefinition;

import java.text.ParseException;

import com.base.Base;
import com.pages.BusHirePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusHireAirportSD extends Base {
	BusHirePage BHPage = new BusHirePage();

	@Given("User is on Home page for airport")
	public void user_is_on_home_page_for_airport() {
		// calling the method to load the driver and Redbus.in site from base class.
		initialization();
	}

	@When("User clicks on Bus hire for airport")
	public void user_clicks_on_bus_hire_for_airport() {
		try {
			// calling the method to click on bus hire button in homepage.
			BHPage.clickBusHire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User clicks on Airport")
	public void user_clicks_on_airport() {
		try {
			// calling the method to click on Airport
			BHPage.clickAirport();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User selects city")
	public void user_selects_city() {
		try {
			// calling the method to select the city inside Airport
			BHPage.selectCity(prop.getProperty("city"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enter destination for airport")
	public void user_enter_destination_for_airport() {
		try {
			// calling the method to enter the destination inside Airport
			BHPage.EnterDestinationAirport(prop.getProperty("Destination"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enters date and time when he wants the vehicle")
	public void user_enters_date_and_time_when_he_wants_the_vehicle() {
		try {
			// calling the method to enter the date and time inside Airport option.
			BHPage.EnterDateTimeAirport(prop.getProperty("InDate"), prop.getProperty("InTime"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enters passenger count for airport")
	public void user_enters_passenger_count_for_airport() {
		try {
			// calling the method to enter the passenger count for Airport.
			BHPage.PassengerCount(prop.getProperty("count"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User clicks on Airport proceed and successfully hires bus")
	public void user_clicks_on_airport_proceed_and_successfully_hires_bus() {
		try {
			// calling the method to click on the proceed button of Airport.
			BHPage.clickProceedAirport();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User clicks on Drop to Airport")
	public void user_clicks_on_drop_to_airport() {
		try {
			// method to click on the drop to airport button.
			BHPage.clickDropToAirport();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enters pickup location for aiport")
	public void user_enters_pickup_location_for_aiport() {
		try {
			// calling the method to enter pickup location 
			BHPage.EnterPickLocAirport(prop.getProperty("PickUp"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
