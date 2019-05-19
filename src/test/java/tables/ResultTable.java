package tables;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultTable extends PageObject {

  @FindBy(id = "divResultSQL")
  private WebElementFacade resultTableDiv;

  HashMap<Integer, HashMap<String, String>> resultTable = new HashMap<Integer, HashMap<String, String>>();

  public void parseResultTable() {
    List<WebElementFacade> rowsList = this.resultTableDiv.thenFindAll(By.tagName("tr")); // get all table rows
    List<WebElementFacade> headersList = rowsList.get(0).thenFindAll(By.tagName("th")); // get all table headers
    rowsList.remove(0); // remove headers row

    // Extract header's name from all table headers
    List<String> textHeaders = new ArrayList<String>();
    for (WebElementFacade header : headersList) {
      textHeaders.add(header.getAttribute("textContent"));
    }
    // Fill Hashmap with values in accordance with existing columns
    int i = 0;
    for (WebElementFacade row : rowsList) {
      List<WebElementFacade> rowColumnsList = row.thenFindAll(By.tagName("td"));
      HashMap<String, String> rowData = new HashMap<String, String>();
      for (String header : textHeaders) {
        rowData.put(header, (rowColumnsList.get(textHeaders.indexOf(header)).getAttribute("textContent")));
      }
      resultTable.put(i++, rowData);
    }
  }

  public int getResultTableSize() {
    return this.resultTable.size();
  }
}
