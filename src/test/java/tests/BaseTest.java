package tests;

import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

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
