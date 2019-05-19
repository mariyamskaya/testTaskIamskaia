package tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CheckCustomersTableSteps;
import steps.SendSQLQuerySteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/resources/testData/CheckCustomerAddress.csv")
public class CheckCustomerAddressByCustomerNameTest extends BaseTest {

  private String query;
  private String customerName;
  private String expectedAddress;

  public CheckCustomerAddressByCustomerNameTest() {
    this.query = query;
    this.customerName = customerName;
    this.expectedAddress = expectedAddress;
  }

  @Steps
  SendSQLQuerySteps makeSQLQuerySteps;

  @Steps
  CheckCustomersTableSteps checkCustomersTableSteps;

  @Test
  public void checkCustomerAddressByCustomerName() {
    makeSQLQuerySteps.userOpenMainPage()
            .userTypeSQLQuery(this.query)
            .userClickOnRunSQLQueryButton();

    checkCustomersTableSteps.receiveResultTable()
            .customerAddressShouldMatch(customerName, expectedAddress);
  }
}
