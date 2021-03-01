package Parallel;
import org.junit.Assert;

import com.Factory.DriverFactory;
import com.PageObjects.LoginPageObjects;
import io.cucumber.java.en.*;

public class LoginPageSteps {

	private LoginPageObjects LoginPageObjects = new LoginPageObjects(DriverFactory.getDriver());
	private String PageTitle;

	@Given("user is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver().navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		PageTitle=LoginPageObjects.getLoginPageTitle();

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String Title) {

		Assert.assertTrue(PageTitle.equals(Title));

	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {

		Assert.assertTrue(LoginPageObjects.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String UserName) {
		LoginPageObjects.enterUserName(UserName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String PassWord) {

		LoginPageObjects.enterPassword(PassWord);

	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		
		LoginPageObjects.clickOnLogin();
	}


}
