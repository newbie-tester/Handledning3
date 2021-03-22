package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;

	@Given("I navigate to MarshuCalculator")
	public void i_navigate_to_marshu_calculator() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");
		Thread.sleep(3000);
	}

	@Given("I have entered {int} into the calculator")
	public void i_have_entered_into_the_calculator(Integer int1) {
		WebElement num1 = driver.findElement(By.name("n01"));
		num1.sendKeys("123");
	}

	@Given("I have also entered {int} into the calculator")
	public void i_have_also_entered_into_the_calculator(Integer int1) {
		WebElement num2 = driver.findElement(By.name("n02"));
		num2.sendKeys("456");
	}

	@When("I press add")
	public void i_press_add() throws InterruptedException {
//		WebElement addButton = driver.findElement(By.xpath(
//				"/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
//		addButton.click();
//		WebElement addButtonByCSS = driver.findElement(By.cssSelector("input[type=button]"));
		WebElement addButtonByCSS = driver.findElement(By.cssSelector("input[value='Find Addition']"));
		addButtonByCSS.click();
	}

	@Then("the result should be {int} on the screen")
	public void the_result_should_be_on_the_screen(Integer int1) throws InterruptedException {
//		WebElement result = driver.findElement(By.name("answer"));
//		assertEquals("579", result.getAttribute("value"));
//		Thread.sleep(3000);
//		driver.quit();

//		List<WebElement> inputFields = driver.findElements(By.className("regfont"));
//		List<WebElement> inputFields = driver.findElements(By.cssSelector("input.regfont"));
//		List<WebElement> inputFields = driver.findElements(By.cssSelector("input[name]"));
		List<WebElement> inputFields = driver.findElements(By.cssSelector("input[class]"));
		for (WebElement e : inputFields) {
			System.out.println(e.getAttribute("name"));
		}
		
		List<WebElement> input = driver.findElements(By.tagName("input"));
		System.out.println(input.size());
		
		driver.quit();
	}

}
