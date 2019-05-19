package tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CheckCustomersTableSteps;
import steps.RestoreDatabaseSteps;
import steps.SendSQLQuerySteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/resources/testData/InsertRow.csv")
public class InsertRowTest extends BaseTest {

  private String insertQuery;
  private String selectQuery;
  private String customerName;
  private String contactName;
  private String address;
  private String city;
  private String postalCode = RandomStringUtils.random(10, true, false); // create unique ID for row
  private String country;

  @Steps
  SendSQLQuerySteps sendSQLQuerySteps;

  @Steps
  CheckCustomersTableSteps checkCustomersTableSteps;

  @Steps
  RestoreDatabaseSteps restoreDatabaseSteps;

  @Test
  public void insertRow() {
    String insertSQL = String.format(this.insertQuery, this.customerName, this.contactName, this.address, this.city, this.postalCode, this.country);
    String selectSQL = String.format(this.selectQuery, this.postalCode);

    sendSQLQuerySteps.userOpenMainPage()
            .userTypeSQLQuery(insertSQL)
            .userClickOnRunSQLQueryButton()
            .userTypeSQLQuery(selectSQL)
            .userClickOnRunSQLQueryButton();
    checkCustomersTableSteps.receiveResultTable()
            .rowsCountShouldBe(1);
  }

  @After
  public void restoreDatabase() {
    restoreDatabaseSteps.clickOnRestoreDatabaseButton()
            .acceptConfirmationAlert();
  }
}
