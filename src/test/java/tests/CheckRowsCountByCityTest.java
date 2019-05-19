package tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CheckCustomersTableSteps;
import steps.SendSQLQuerySteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/resources/testData/CheckRowsCountByCity.csv")
public class CheckRowsCountByCityTest extends BaseTest {

  private String query;
  private int expectedRowsCount;

  public CheckRowsCountByCityTest() {
    this.query = query;
    this.expectedRowsCount = expectedRowsCount;
  }

  @Steps
  SendSQLQuerySteps sendSQLQuerySteps;

  @Steps
  CheckCustomersTableSteps checkCustomersTableSteps;

  @Test
  public void checkRowsCountByCity() {
    sendSQLQuerySteps.userOpenMainPage()
            .userTypeSQLQuery(this.query)
            .userClickOnRunSQLQueryButton();
    checkCustomersTableSteps.receiveResultTable()
            .rowsCountShouldBe(expectedRowsCount);
  }
}
