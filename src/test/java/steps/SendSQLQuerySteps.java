package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import tables.CustomersResultTable;
import pages.MainPage;
import tables.ResultTable;

public class SendSQLQuerySteps extends ScenarioSteps {
  MainPage mainPage;
  ResultTable resultTable;
  CustomersResultTable customersResultTable;

  @Step
  public SendSQLQuerySteps userOpenMainPage() {
    mainPage.open();
    return this;
  }

  @Step("User Enter SQL Query: {0}")
  public SendSQLQuerySteps userTypeSQLQuery(String query) {
    mainPage.typeQuery(query);
    return this;
  }

  @Step
  public SendSQLQuerySteps userClickOnRunSQLQueryButton() {
    mainPage.clickOnRunSQLButton();
    return this;
  }
}
