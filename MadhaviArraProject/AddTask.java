
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AddTask extends BaseSetUP {
	public static final int idx = 2;

	// method to add a task
	@Test
	public void addTask() throws InterruptedException {
		int noOfCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		for (int i=1; i<= 3; i++ ) // creates 3 tasks. 3 is an arbitrary number.
								   // task names are Test1, Test2, Test3
		{
			String TaskName = "Test" + i;
			driver.findElement(By.name("data")).sendKeys(TaskName);
			driver.findElement(By.cssSelector("input[value='Add']")).click();
		}
		
		driver.navigate().refresh();

		int noOfCheckBoxesAfter = driver.findElements(By.cssSelector("input[type='checkbox']")).size();

		Assert.assertTrue(noOfCheckBoxesAfter > noOfCheckBoxes);
        Thread.sleep(3000);// Sleep is introduced to enable us to see the action on the web page
	}

	// Add duplicate task
	@Test
	public void addDuplicateTask() throws InterruptedException {

		String expMessage = "Sorry that TODO item already exists. Back";

		driver.findElement(By.name("data")).sendKeys("aboutTest22");
		driver.findElement(By.cssSelector("input[value='Add']")).click();
		
		// try adding the same task one more time to test for duplicates
		driver.findElement(By.name("data")).sendKeys("aboutTest22");
		driver.findElement(By.cssSelector("input[value='Add']")).click();
	       
		driver.navigate().refresh();
		String actualMessage = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(actualMessage, expMessage);
		Thread.sleep(3000);// Sleep is introduced to enable us to see the action on the web page
	}

	// method to remove a task
    @Test
	public void removeTask() throws InterruptedException {

		int noOfCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        // following loop deletes all tasks one by one
		for (int i=0; i<noOfCheckBoxes; i++ )
 		{
 			driver.findElement(By.cssSelector ("input[type='checkbox']")).click();
       
 			driver.findElement(By.cssSelector("input[value='Remove']")).click();
 		}
		int noOfCheckBoxesAfter = driver.findElements(By.cssSelector("input[type='checkbox']")).size();

		Assert.assertEquals(noOfCheckBoxesAfter, noOfCheckBoxes);
		Thread.sleep(3000);// Sleep is introduced to enable us to see the action on the web page
	}

}
