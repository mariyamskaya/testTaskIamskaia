package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import tables.CustomersResultTable;

public class CheckCustomersTableSteps extends ScenarioSteps {

  CustomersResultTable customersResultTable;

  @Step
  public CheckCustomersTableSteps receiveResultTable() {
    customersResultTable.parseResultTable();
    return this;
  }

  @Step("Customer address should match: {0} - {1}")
  public void customerAddressShouldMatch(String name, String expectedAddress) {
    Assert.assertTrue(customersResultTable.isCustomerAddressMatchCustomerName(name, expectedAddress));
  }

  @Step
  public void rowsCountShouldBe(int expectedRowsCount) {
    Assert.assertTrue(expectedRowsCount == customersResultTable.getResultTableSize());
  }

  @Step
  public void checkDataIsUpdated(String id, String newCustomerName, String newContactName, String newAddress,
                                 String newCity, String newPostalCode, String newCountry) {
    Assert.assertTrue(customersResultTable.isCustomerDataUpdated(id, newCustomerName, newContactName, newAddress,
            newCity, newPostalCode, newCountry));
  }
}
