package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.MainPage;

public class RestoreDatabaseSteps extends ScenarioSteps {

  MainPage mainPage;

  @Step
  public RestoreDatabaseSteps clickOnRestoreDatabaseButton() {
    mainPage.clickOnRestoreDatabaseButton();
    return this;
  }

  @Step
  public RestoreDatabaseSteps acceptConfirmationAlert() {
    mainPage.acceptConfirmationAlert();
    return this;
  }
}
