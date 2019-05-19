package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.MainPage;

public class SendSQLQuerySteps extends ScenarioSteps {

  MainPage mainPage;

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
