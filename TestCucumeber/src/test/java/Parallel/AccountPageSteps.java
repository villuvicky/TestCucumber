package Parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import com.Factory.DriverFactory;
import com.PageObjects.AccountPageObjects;
import com.PageObjects.LoginPageObjects;

public class AccountPageSteps {


	private LoginPageObjects LoginPageObjects = new LoginPageObjects(DriverFactory.getDriver());

	private AccountPageObjects accountsPage;
	

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {

		List<Map<String, String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage=LoginPageObjects.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {

		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: " + title);
	}

	@Then("user gets accounts section")

	public void user_gets_accounts_section(DataTable dataTable) {

		List<String> expAccountSectionsList = dataTable.asList();
		System.out.println("Expected accounts section list: " + expAccountSectionsList);
		List<String> actualAccountSectionsList = accountsPage.getAccountsSectionsList();
		System.out.println("Actual accounts section list: " + actualAccountSectionsList);
		Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {

		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
	}

}
