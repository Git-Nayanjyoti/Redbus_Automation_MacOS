package com.stepDefinition;

import java.text.ParseException;

import com.base.Base;
import com.pages.ViewSeatsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewSeatsSD extends Base{
	ViewSeatsPage VSPage = new ViewSeatsPage();

	@Given("User is on Home page for viewing seats")
	public void user_is_on_home_page_for_viewing_seats() {
	   initialization();
	}

	@When("User enters location for viewing seats")
	public void user_enters_location_for_viewing_seats() throws InterruptedException {
		VSPage.enterLocation(prop.getProperty("Location"));
	}

	@When("User enters destination for viewing seats")
	public void user_enters_destination_for_viewing_seats() throws InterruptedException {
		VSPage.enterDestination(prop.getProperty("Destn"));
	} 

	@When("User enters date for viewing seats")
	public void user_enters_date_for_viewing_seats() throws InterruptedException, ParseException {
		VSPage.enterDate(prop.getProperty("Date"));
	}

	@When("User clicks on search button for viewing seats")
	public void user_clicks_on_search_button_for_viewing_seats() throws InterruptedException {
		VSPage.clickSearchBus();
	}

	@Then("User should be able to click on view seats successfully")
	public void user_should_be_able_to_click_on_view_seats_successfully() throws InterruptedException {
		VSPage.viewBus();
	}
}