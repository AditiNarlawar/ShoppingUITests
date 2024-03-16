package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reusableComponents.AbstractComponents;

import java.util.List;

public class OrdersPage extends AbstractComponents {
    WebDriver driver;

    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> productsNameInTable;

    public OrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean verityOrderDisplay(String productName) {
        Boolean match = productsNameInTable.stream().anyMatch(Product -> Product.getText().equalsIgnoreCase(productName));
        return match;
    }
}
