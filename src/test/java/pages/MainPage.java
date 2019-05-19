package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.w3schools.com/sql/trysql.asp?filename=trysql_select_all")
public class MainPage extends PageObject {

  @FindBy(xpath = "//form[@id='tryitform']")
  private WebElementFacade sqlQueryField;

  @FindBy(xpath = "//button[@class='w3-green w3-btn']")
  private WebElementFacade runSQLButton;

  @FindBy(xpath = "//button[@id='restoreDBBtn']")
  private WebElementFacade restoreDatabaseButton;

  public void typeQuery(String query) {
    Actions actions = new Actions(getDriver());
    actions.click(sqlQueryField).build().perform();
    actions.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.BACK_SPACE)).build().perform();
    actions.sendKeys(query).build().perform();
  }

  public void clickOnRunSQLButton() {
    runSQLButton.click();
  }

  public void clickOnRestoreDatabaseButton() {
    restoreDatabaseButton.click();
  }

  public void acceptConfirmationAlert() {
    getDriver().switchTo().alert().accept();
  }
}
