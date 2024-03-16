package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";

    /**
     * Test method to submit an order for a product and verify the confirmation message.
     *
     * @param input a map containing input data such as email, password, and product name
     */
    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String, String> input) throws InterruptedException {
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCard(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.verityProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.checkOut();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmationMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    /**
     * Test method to navigate to the order history page and verify the display of a specific product.
     */
    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistoryPage() {
        ProductCatalogue productCatalogue = landingPage.loginApplication("pass@mail.com", "Pass@2913");
        OrdersPage ordersPage = productCatalogue.goToOrdersPage();
        Assert.assertTrue(ordersPage.verityOrderDisplay(productName));
    }

    /**
     * Data provider method to provide test data for the submitOrder test method.
     *
     * @return an array of test data objects
     * @throws IOException if an I/O error occurs while reading the test data
     */
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\main\\java\\data\\PurchaseOrder.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }
}

