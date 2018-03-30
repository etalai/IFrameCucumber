package step_definitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AlertPOM;
import pages.iFrames;
import static utilities.Driver.getDriver;

public class Implementations {

	iFrames frames = new iFrames(getDriver());
	WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	AlertPOM alertPOM = new AlertPOM(getDriver());

	@Given("^user is on https://the-internet\\.herokuapp\\.com/$")
	public void user_is_on_https_the_internet_herokuapp_com() {
		getDriver().get("https://the-internet.herokuapp.com/");
	}

	@When("^user clicks on Frames link$")
	public void user_clicks_on_Frames_link() throws Throwable {
		frames.frames.click();
	}

	@Then("^user should see Nested Frames & iFrame$")
	public void user_should_see_Nested_Frames_iFrame() throws Throwable {
		assert (frames.iFrame.isDisplayed());
		assert (frames.nestedFrame.isDisplayed());
	}

	@Then("^when user clicks iFrame$")
	public void when_user_clicks_iFrame() throws Throwable {
		frames.iFrame.click();
	}

	@Then("^user should see iFrame$")
	public void user_should_see_iFrame() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(frames.text));
		String text = "An iFrame containing the TinyMCE WYSIWYG Editor";
		assert (frames.text.isDisplayed());
	}

	@When("^user enters in iFrame$")
	public void user_enters_in_iFrame() throws Throwable {
		getDriver().switchTo().frame(0);
		System.out.println(frames.iframeText.getText());
	}

	@Then("^user must be able to type in$")
	public void user_must_be_able_to_type_in() throws Throwable {
		frames.iframeText.clear();
		frames.iframeText.sendKeys("i'm in iframe");
		System.out.println(frames.iframeText.getText());
	}

	@Then("^user must be able to exit iFrame$")
	public void user_must_be_able_to_exit_iFrame() throws Throwable {
		getDriver().switchTo().defaultContent();
		frames.elementalSelenium.click();
		// frames.switchTab("http://elementalselenium.com/");

	}

	@When("^user clicks on JavaScript Alerts$")
	public void user_clicks_on_JavaScript_Alerts() throws Throwable {
		Actions action = new Actions(getDriver());
		action.moveToElement(frames.nestedFrame).pause(Duration.ofMillis(3000)).perform();
		alertPOM.jsAlerts.click();
		String url = "https://the-internet.herokuapp.com/javascript_alerts";
		assert (getDriver().getCurrentUrl().contains(url));
	}

	@Then("^user sees (\\d+) types of alert$")
	public void user_sees_types_of_alert(int arg1) throws Throwable {
		assert (alertPOM.jsAlert.isDisplayed());
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(alertPOM.jsConfirm.isDisplayed());
		softAssertion.assertTrue(alertPOM.jsPrompt.isDisplayed());
		softAssertion.assertAll();
	}

	@When("^user clicks on JS Alert, user sees JavaScript Alerts pop up$")
	public void user_clicks_on_JS_Alert_user_sees_JavaScript_Alerts_pop_up() {
		alertPOM.jsAlert.click();
		new WebDriverWait(getDriver(), 15).until(ExpectedConditions.alertIsPresent());
		getDriver().switchTo().alert().accept();
		assert(alertPOM.result.getText().equals("You successfuly clicked an alert"));
	}

	@When("^once user clicks on JS Confirm, user should be able to confirm/cancel$")
	public void once_user_clicks_on_JS_Confirm_user_should_be_able_to_confirm_cancel() {
		alertPOM.jsConfirm.click();
		getDriver().switchTo().alert().dismiss();
		assert(alertPOM.result.getText().equals("You clicked: Cancel"));
	}

	@When("^once user clicks on JS Prompt, user should be able to manipulate the pop up$")
	public void once_user_clicks_on_JS_Prompt_user_should_be_able_to_manipulate_the_pop_up() {
		alertPOM.jsPrompt.click();
	}

	@When("^user should be able to send \"([^\"]*)\"$")
	public void user_should_be_able_to_send(String arg1) throws Throwable {
		Alert alert=getDriver().switchTo().alert();
		alert.sendKeys(arg1);
		alert.accept();
		assert(alertPOM.result.getText().equals("You entered: "+arg1));
	}

}
