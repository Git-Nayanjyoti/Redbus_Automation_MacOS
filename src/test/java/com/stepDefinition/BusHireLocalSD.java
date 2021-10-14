package com.stepDefinition;

import java.text.ParseException;

import com.base.Base;
import com.pages.BusHirePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusHireLocalSD extends Base {
	BusHirePage BHPage = new BusHirePage();

	@Given("User is on Home page for local")
	public void user_is_on_home_page_for_local() {
		initialization();
	}

	@When("User clicks on Bus hire for local")
	public void user_clicks_on_bus_hire_for_local() {
		try {
			// calling the method to click on bus hire
			BHPage.clickBusHire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User clicks on Local")
	public void user_clicks_on_local() {
		try {
			// calling the method to click on bus hire
			BHPage.clickLocal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enters pickup location for local")
	public void user_enters_pickup_location_for_local() {
		try {
			// calling the method to enter pick up location and select it from dropdown
			BHPage.EnterPickupLoactionLocal(prop.getProperty("PickUp"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User selects package")
	public void user_selects_package() {
		try {
			// calling the method to select the package
			BHPage.Package(prop.getProperty("package"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enters start date and time for local")
	public void user_enters_start_date_and_time_for_local() {
		try {
			// calling the method to select the date and time for local
			BHPage.EnterDateTimeLocal(prop.getProperty("InDate"), prop.getProperty("InTime"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enters passenger count for local")
	public void user_enters_passenger_count_for_local() {
		try {
			// calling the method to enter the passenger count for local
			BHPage.PassengerCount(prop.getProperty("count"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User should be able to click on local proceed successfully")
	public void user_should_be_able_to_click_on_local_proceed_successfully() {
		// calling the method to click on proceed and close the driver.
		BHPage.clickProceedLocal();
	}

}
