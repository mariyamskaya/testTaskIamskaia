package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BaseTest {

  @Managed(driver = "chrome")
  WebDriver driver;

  @Before
  public void maximizeBrowserWindow() {
    this.driver.manage().window().maximize();
  }

  public WebDriver getDriver() {
    return this.driver;
  }
}
