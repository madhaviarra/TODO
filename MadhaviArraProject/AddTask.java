
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddTask extends BaseSetUP {
	public static final int idx = 2;

	// method to add a task
	// @Test
	public void addTask() throws InterruptedException {
		int noOfCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();

		driver.findElement(By.name("data")).sendKeys("aboutTest6");
		driver.findElement(By.cssSelector("input[value='Add']")).click();

		driver.navigate().refresh();

		int noOfCheckBoxesAfter = driver.findElements(By.cssSelector("input[type='checkbox']")).size();

		Assert.assertTrue(noOfCheckBoxesAfter > noOfCheckBoxes);
	}

	// Add duplicate task
	// @Test
	public void addDuplicateTask() throws InterruptedException {

		String expMessage = "Sorry that TODO item already exists. Back";

		driver.findElement(By.name("data")).sendKeys("aboutTest2");
		driver.findElement(By.cssSelector("input[value='Add']")).click();

		driver.navigate().refresh();
		String actualMessage = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(actualMessage, expMessage);
	}

	// method to remove a task
	// @Test
	public void removeTask() throws InterruptedException {

		int noOfCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();

		driver.navigate().refresh();

		driver.findElement(By.cssSelector("input[value='Remove']")).click();
		int noOfCheckBoxesAfter = driver.findElements(By.cssSelector("input[type='checkbox']")).size();

		Assert.assertEquals(noOfCheckBoxesAfter, noOfCheckBoxes);

	}

}
