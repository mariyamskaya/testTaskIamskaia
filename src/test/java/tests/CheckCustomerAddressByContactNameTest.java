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
public class CheckCustomerAddressByContactNameTest extends BaseTest {

  private String query;
  private String contactName;
  private String expectedAddress;

  @Steps
  SendSQLQuerySteps makeSQLQuerySteps;

  @Steps
  CheckCustomersTableSteps checkCustomersTableSteps;

  @Test
  public void checkCustomerAddressByContactName() {
    makeSQLQuerySteps.userOpenMainPage()
            .userTypeSQLQuery(this.query)
            .userClickOnRunSQLQueryButton();

    checkCustomersTableSteps.receiveResultTable()
            .customerAddressShouldMatch(this.contactName, this.expectedAddress);
  }
}
