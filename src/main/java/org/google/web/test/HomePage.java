package org.google.web.test;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverProvider {

	@FindBy(how = How.CSS, using = "input[name='q']")
	private WebElement searchField;

	@FindBy(how = How.CSS, using = "input[name='btnK']")
	private WebElement searchButton;

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	@Given("I am on the homepage")
	public void openHomePage() {
		driver.get("https://www.google.com/webhp?hl=en&output=search&ech=1&psi=Vp6JUNyJJMeK0AX0-oCYDg.1351196238788.5&emsg=NCSR&noj=1&ei=ZJ6JUMtb6ZjRBcingOgD");
	}

	@When("I search for <query>")
	public void clickFirstResult(@Named("query") String query)
			throws InterruptedException {
		searchField.sendKeys(query);
		searchButton.click();
	}

}