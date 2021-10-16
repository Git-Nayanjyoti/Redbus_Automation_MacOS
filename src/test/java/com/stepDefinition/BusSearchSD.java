package com.stepDefinition;

import java.text.ParseException;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import com.base.Base;
import com.pages.BusSearchPage;
import com.pages.ViewSeatsPage;
import com.timestamp.DatePicker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusSearchSD extends Base {
	BusSearchPage BSPage = new BusSearchPage();
	DatePicker DPicker = new DatePicker();
	ViewSeatsPage VSPage = new ViewSeatsPage();

	@Given("User is on Home Page")
	public void user_is_on_home_page() throws InterruptedException {
		initialization();
	}

	@When("User enters current location")
	public void user_enters_current_location() throws InterruptedException {
		//BSPage.busTicketDropdown(prop.getProperty("Location"), "current");
		VSPage.enterLocation(prop.getProperty("Location"));
	}

	@When("User enters destination location")
	public void user_enters_destination_location() throws InterruptedException {
		//BSPage.busTicketDropdown(prop.getProperty("Destn"), "destination");
		VSPage.enterDestination(prop.getProperty("Destn"));
	}

	@When("User enters journey date")
	public void user_enters_journey_date() throws InterruptedException, ParseException {
		VSPage.enterDate(prop.getProperty("Date"));

	}

	@When("User clicks Search Buses button")
	public void user_clicks_search_buses_button() throws InterruptedException {
		driver.findElement(By.id("search_btn")).click();

	}

	@Then("Available Buses listed")
	public void available_buses_listed() throws InterruptedException {
		BSPage.searchPopUps();
		WebElement results = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[2]"));
		Assert.assertTrue(results.isDisplayed());
		closeDriver();

	}

	@Then("All the user entered values should be displayed")
	public void all_the_user_entered_values_should_be_displayed() {
		boolean src = driver
				.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]"))
				.getCssValue("border-color").contains("rgb(210, 210, 210)");
		Assert.assertTrue(src);
		boolean dest = driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[2]")).getCssValue("border-color")
				.contains("rgb(210, 210, 210)");
		Assert.assertTrue(dest);
		String date = prop.getProperty("date");

		boolean dateValue = driver.findElement(By.xpath("//*[@id=\"onward_cal\"]")).getAttribute("data-caleng")
				.contains(date);

		Assert.assertTrue(dateValue);
		closeDriver();
	}

	@Then("^User select (.+) and (.+)$")
	public void user_select_and(String filter, String value) throws Throwable {
		BSPage.searchPopUps();
		BSPage.filterForBusSearch(filter, value);
		boolean filterName = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/ul/li")).getText()
				.contains(value);
		Assert.assertTrue(filterName);

	}

}
