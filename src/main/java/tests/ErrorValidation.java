package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductCatalogue;
import testComponents.BaseTest;
import testComponents.RetryFailedTests;

import java.util.List;

public class ErrorValidation extends BaseTest {

    /**
     * Test method to validate error message when logging in with incorrect credentials.
     */
  @Test(groups = {"ErrorHandling"}, retryAnalyzer = RetryFailedTests.class)
    public void loginPageErrorValidation() {
        landingPage.loginApplication("pass@mail.com", "Pass2913");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }

    /**
     * Test method to validate product selection and display in the cart.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
  @Test
    public void productErrorValidation() throws InterruptedException {
        String productName = "ADIDAS ORIGINAL";
        ProductCatalogue productCatalogue = landingPage.loginApplication("test@yaho.com", "Test5678");
       List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCard(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.verityProductDisplay("ADIDAS ORIGINAL");
        Assert.assertTrue(match);
    }
}
