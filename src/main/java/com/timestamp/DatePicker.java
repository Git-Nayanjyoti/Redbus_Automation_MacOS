package com.timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.Base;

public class DatePicker extends Base {
	// Method for picking up the date only
	public void datepicker(String date) throws InterruptedException, ParseException {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		String[] dateArr = date.split("-", 2);
		String day = dateArr[0];
		String[] year = date.split("-");
		String month = year[1];
		Date currentDate = new Date();
		String formateDate = "";

		// converting the String date to date format so that we can compare it
		for (int num = 0; num < months.length; num++) {
			if (months[num].equals(month)) {
				int monthInNum = num + 1;
				formateDate = day + "/" + monthInNum + "/" + year[2];
			}
		}

		Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(formateDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		currentDate = calendar.getTime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		cal.set(Calendar.SECOND, 40);
		inputDate = cal.getTime();
		if (inputDate.before(currentDate)) {
			// Do nothing
			System.out.println("Pre date can't be entered");
		} else {
			String MonthYear = dateArr[1].replace("-", " ");
			Thread.sleep(3000);
			while (!driver.findElement(By.className("monthTitle")).getText().equalsIgnoreCase(MonthYear)) {
				driver.findElement(By.className("next")).click();
			}

			List<WebElement> size = driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[3]"))
					.findElements(By.tagName("td"));
			for (int i = 3; i <= size.size(); i++) {
				for (int j = 1; j <= size.size(); j++) {
					WebElement findDate = driver
							.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[" + i + "]/td[" + j + "]"));

					// checking if the month is February and have date more the 28
					if (MonthYear == "Feb 2021") {
						while (j != 1) {
							if (findDate.getText().equals(day)) {
								findDate.click();
								break;
							}
						}
					} else if (findDate.getText().equals(day)) {
						findDate.click();
						i = 0;
						break;
					}

				}
				if (i == 0) {
					break;
				}
			}
		}

	}

}
