package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class BusSearchPage extends Base {

	@FindBy(xpath = "/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/ul")
	public WebElement from;

	@FindBy(xpath = "/html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/ul")
	public WebElement to;

	@FindBy(id = "src")
	public WebElement fromInput;

	@FindBy(id = "dest")
	public WebElement toInput;

	@FindBy(className = "close")
	public WebElement firstPopup;

	@FindBy(xpath = "/html/body/section/div[2]/div[1]/div/div[3]/div[2]")
	public WebElement primoPopup;

	public BusSearchPage() {
		PageFactory.initElements(driver, this);
	}

	public void searchPopUps() throws InterruptedException {

		Thread.sleep(5000);
		firstPopup.click();

		Thread.sleep(5000);
		primoPopup.click();

	}

	public void filterForBusSearch(String filterType, String value) throws InterruptedException {

		if (filterType.equals("DEPARTURE TIME")) {

			WebElement dt = driver.findElement(By.xpath("//ul[@class='dept-time dt-time-filter']"));
			List<WebElement> options = dt.findElements(By.tagName("li"));
			for (int i = 0; i < options.size(); i++) {
				int k = i + 1;
				String text = driver
						.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[2]/li[" + k + "]/label[2]"))
						.getText();

				if (text.contains(value)) {
					driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[2]/li[" + k + "]/label[1]"))
							.click();
					Thread.sleep(5000);
					break;
				}
				text = "";
			}

		}

		if (filterType.equals("BUS TYPES")) {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[3]")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver
					.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/ul[2]")));
			WebElement dt = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[3]"));
			List<WebElement> options = dt.findElements(By.tagName("li"));
			for (int i = 0; i < options.size(); i++) {
				int k = i + 1;
				String text = driver
						.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[3]/li[" + k + "]/label[2]"))
						.getText();
				System.out.println(text);

				if (text.contains(value)) {
					driver.findElement(
							By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/ul[3]/li[" + k
									+ "]/label[1]"))
							.click();
					Thread.sleep(5000);
					System.out.println(driver
							.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[3]/li[" + k + "]/label[1]"))
							.isSelected());
					break;
				}
				text = "";
			}
		}

		if (filterType.equals("ARRIVAL TIME")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver
					.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/ul[3]")));
			WebElement dt = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[4]"));
			List<WebElement> options = dt.findElements(By.tagName("li"));
			for (int i = 0; i < options.size(); i++) {
				int k = i + 1;
				String text = driver
						.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[4]/li[" + k + "]/label[2]"))
						.getText();
				System.out.println(text);

				if (text.contains(value)) {
					driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[4]/li[" + k + "]/label[1]"))
							.click();
					Thread.sleep(5000);
					System.out.println(driver
							.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[4]/li[" + k + "]/label[1]"))
							.isSelected());
					break;
				}
				text = "";
			}
		}

		if (filterType.equals("DROPPING POINT")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver
					.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/ul[5]")));
			WebElement dt = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[5]"));
			List<WebElement> options = dt.findElements(By.tagName("li"));
			for (int i = 0; i < options.size(); i++) {
				int k = i + 1;
				String text = driver
						.findElement(
								By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[5]/li[" + k + "]/label[2]/span[1]"))
						.getText();
				System.out.println(text);

				if (text.contains(value)) {
					driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[5]/li[" + k + "]/label[1]"))
							.click();
					Thread.sleep(5000);
					System.out.println(driver
							.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[5]/li[" + k + "]/label[1]"))
							.isSelected());
					break;
				}
				text = "";
			}
		}
		if (filterType.equals("BOARDING POINT")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver
					.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div[5]")));
			driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[5]/input")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[6]/div[2]/div/div/div/div/div[3]/input"))
					.sendKeys(value);
			Thread.sleep(1000);
			List<WebElement> list = driver
					.findElement(
							By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[6]/div[2]/div/div/div/div/div[4]/ul"))
					.findElements(By.tagName("li"));
			for (int i = 1; i < list.size(); i++) {
				int k = i + 1;
				String text = driver.findElement(
						By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[6]/div[2]/div/div/div/div/div[4]/ul/li[" + k
								+ "]/label[2]"))
						.getText();
				if (text.contains(value)) {
					driver.findElement(
							By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[6]/div[2]/div/div/div/div/div[4]/ul/li["
									+ k + "]/label[1]"))
							.click();
					Thread.sleep(1000);
					driver.findElement(By
							.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[6]/div[2]/div/div/div/div/div[5]/div[2]"))
							.click();
					Thread.sleep(1000);
					break;
				}
			}
		}

		if (filterType.equals("OPERATOR")) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver
					.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div[8]")));
			driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[8]/input")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[9]/div[2]/div/div/div/div/div[3]/input"))
					.sendKeys(value);
			Thread.sleep(1000);
			List<WebElement> list = driver
					.findElement(
							By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[9]/div[2]/div/div/div/div/div[4]/ul"))
					.findElements(By.tagName("li"));
			for (int i = 1; i < list.size(); i++) {
				int k = i + 1;
				String text = driver.findElement(
						By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[9]/div[2]/div/div/div/div/div[4]/ul/li[" + k
								+ "]/label[2]"))
						.getText();
				if (text.contains(value)) {
					driver.findElement(
							By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[9]/div[2]/div/div/div/div/div[4]/ul/li["
									+ k + "]/label[1]"))
							.click();
					Thread.sleep(1000);
					driver.findElement(By
							.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[9]/div[2]/div/div/div/div/div[5]/div[2]"))
							.click();
					Thread.sleep(1000);
					break;
				}
			}
		}

	}

}