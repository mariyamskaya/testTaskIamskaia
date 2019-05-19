package tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CheckCustomersTableSteps;
import steps.RestoreDatabaseSteps;
import steps.SendSQLQuerySteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/resources/testData/UpdateRow.csv")
public class UpdateRowTest extends BaseTest {

  private String updateQuery;
  private String selectQuery;
  private String customerId;
  private String newCustomerName;
  private String newCustomerContactName;
  private String newCustomerAddress;
  private String newCity;
  private String newPostalCode;
  private String newCountry;

  @Steps
  SendSQLQuerySteps sendSQLQuerySteps;

  @Steps
  CheckCustomersTableSteps checkCustomersTableSteps;

  @Steps
  RestoreDatabaseSteps restoreDatabaseSteps;

  @Test
  public void updateRow() {
    String insertSQL = String.format(this.updateQuery, this.newCustomerName, this.newCustomerContactName,
            this.newCustomerAddress, this.newCity, this.newPostalCode, this.newCountry, this.customerId);
    String selectSQL = String.format(this.selectQuery, this.customerId);

    sendSQLQuerySteps.userOpenMainPage()
            .userTypeSQLQuery(insertSQL)
            .userClickOnRunSQLQueryButton()
            .userTypeSQLQuery(selectSQL)
            .userClickOnRunSQLQueryButton();
    checkCustomersTableSteps.receiveResultTable()
            .checkDataIsUpdated(this.customerId, this.newCustomerName, this.newCustomerContactName, this.newCustomerAddress,
                    this.newCity, this.newPostalCode, this.newCountry);
  }

  @After
  public void restoreDatabase() {
    restoreDatabaseSteps.clickOnRestoreDatabaseButton()
            .acceptConfirmationAlert();
  }
}
