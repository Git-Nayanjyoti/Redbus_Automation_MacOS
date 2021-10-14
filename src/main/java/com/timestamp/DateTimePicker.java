package com.timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.Base;

public class DateTimePicker extends Base {
	// Method for picking up the date and time
	public void dateAndTime(String date, String time) throws InterruptedException, ParseException {

		String[] timeArr = time.split(":");
		String hour = timeArr[0];
		String minute = timeArr[1];
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] dateArr = date.split("-", 2);
		String day = dateArr[0];
		String[] year = date.split("-");
		String month = year[1];
		Date now = new Date();
		String formatDate = "";
		for (int num = 0; num < months.length; num++) {
			if (months[num].equals(month)) {
				int monthInNum = num + 1;
				formatDate = day + "/" + monthInNum + "/" + year[2];
			}
		}

		Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(formatDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		now = calendar.getTime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		cal.set(Calendar.SECOND, 40);
		inputDate = cal.getTime();
		if (inputDate.before(now)) {
			// Do nothing
			System.out.println("Pre date can't be entered");
		} else {
			String MonthYear = dateArr[1].replace("-", " ");
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			while (!driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[4]/div[1]/div[1]/div/p"))
					.getText().equalsIgnoreCase(MonthYear)) {
				driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[4]/div[1]/div[1]/button[2]"))
						.click();
			}

			List<WebElement> size = driver
					.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[4]/div[2]/div/div[1]"))
					.findElements(By.tagName("div"));

			for (int i = 1; i < size.size(); i++) {
				for (int j = 1; j <= size.size(); j++) {
					WebElement findDate = driver
							.findElement(By.xpath("//html/body/div[5]/div[3]/div/div[1]/div/div[4]/div[2]/div/div[" + i
									+ "]/div[" + j + "]"));
					if (MonthYear == "February 2021") {
						while (j != 1) {
							if (findDate.getText().equals(day)) {
								findDate.click();
								break;
							}
						}
					} else if (findDate.getText().equals(day)) {
						// System.out.println(findDate.getText());
						findDate.click();
						i = 0;
						break;
					}
				}
				if (i == 0) {
					break;
				}

			}
			// For selecting the time
			// Hour Hand
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			List<WebElement> hourHand = driver
					.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[4]/div/div"))
					.findElements(By.tagName("span"));
			for (int hrs = 0; hrs < hourHand.size(); hrs++) {
				if (hourHand.get(hrs).getText().equals(hour)) {
					WebElement cor1 = hourHand.get(hrs);
					Actions clickonhour = new Actions(driver);
					clickonhour.moveToElement(cor1).click().perform();
					cor1 = null;
					break;

				}
			}
			// Second Hand
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			List<WebElement> secondHand = driver
					.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[4]/div/div"))
					.findElements(By.tagName("span"));
			for (int min = 0; min < secondHand.size(); min++) {
				if (secondHand.get(min).getText().equals(minute)) {
					WebElement cor2 = secondHand.get(min);
					Actions clickonhour = new Actions(driver);
					clickonhour.moveToElement(cor2).click().perform();
					cor2 = null;
					break;

				}
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]")).click();

		}

	}

}
