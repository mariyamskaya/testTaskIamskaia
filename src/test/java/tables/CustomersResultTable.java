package tables;

import java.util.HashMap;

public class CustomersResultTable extends ResultTable {

  public boolean isCustomerAddressMatchContactName(String contactName, String expectedAddress) {
    for (int x = 0; x < this.resultTable.size(); x++) {
      HashMap<String, String> row = this.resultTable.get(x);
      String parsedContactName = row.get("ContactName");
      if (parsedContactName.equals(contactName)) {
        return row.get("Address").equals(expectedAddress);
      }
    }
    return false;
  }

  public boolean isCustomerDataUpdated(String customerID, String newCustomerName, String newContactName, String newAddress,
                                       String newCity, String newPostalCode, String newCountry) {
    HashMap<String, String> customerData = this.resultTable.get(0);
    String currentCustomerID = customerData.get("CustomerID");
    if (currentCustomerID.equals(customerID)) {
      return customerData.get("CustomerName").equals(newCustomerName) &&
              customerData.get("ContactName").equals(newContactName) &&
              customerData.get("Address").equals(newAddress) &&
              customerData.get("City").equals(newCity) &&
              customerData.get("PostalCode").equals(newPostalCode) &&
              customerData.get("Country").equals(newCountry);
    }
    return false;
  }
}
