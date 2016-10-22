// Created by Madhavi Arra
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Categories extends BaseSetUP {

	// get category count based on color passed
	@Test(dataProvider = "colors")
	public void getCategoryCountByColor(String color, int expRes) throws InterruptedException {

		int noOfItemWithGivenColor = driver.findElements(By.cssSelector("pre span[style='color: " + color + "']"))
				.size();
		Assert.assertEquals(expRes, noOfItemWithGivenColor);
	}

	// Verify category color after adding item with category
	@Test(dataProvider = "categoryTest")
	public void getCategoryColor(String expColor, int idx) throws InterruptedException {

		int noOfItemWithGivenColor = driver.findElements(By.cssSelector("pre span[style='color: " + expColor + "']"))
				.size();
		driver.findElement(By.name("data")).sendKeys("aboutTest12");
		Select categoryOption = new Select(driver.findElement(By.cssSelector("select[name='category']")));
		categoryOption.selectByIndex(idx);
		driver.findElement(By.cssSelector("input[value='Add']")).click();

		driver.navigate().refresh();

		int noOfCategoriesOfGivenColor = driver
				.findElements(By.cssSelector("pre span[style='color: " + expColor + "']")).size();

		System.out.println("CategoryColor " + noOfCategoriesOfGivenColor + noOfItemWithGivenColor);
		Assert.assertTrue(noOfCategoriesOfGivenColor < noOfItemWithGivenColor);

	}

	@DataProvider
	public Object[][] colors() {
		return new Object[][] { { "red", 5 }, { "#FF00FF", 1 },

		};
	}

	@DataProvider
	public Object[][] categoryTest() {
		return new Object[][] {

				{ "#00FF00", 2 }, };
	}
}
