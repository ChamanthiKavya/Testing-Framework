package AMC.Ex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class AmazonTestSuite {

    private static final String Assert = null;
	private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\Users\budda\Desktop\software\chromedriver-win64\chromedriver-win64\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testUserRegistration() {
      
        driver.get("https://www.amazon.com/"); 
       
        WebElement signInLink = driver.findElement(By.id("nav-link-accountList"));
        signInLink.click();


        WebElement createAccountButton = driver.findElement(By.id("createAccountSubmit"));
        createAccountButton.click();


        WebElement nameInput = driver.findElement(By.id("ap_customer_name"));
        nameInput.sendKeys("kavya");

        WebElement emailInput = driver.findElement(By.id("ap_email"));
        emailInput.sendKeys("bujjichamanthi98@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("ap_password"));
        passwordInput.sendKeys("Kavya@9836");

        WebElement confirmPasswordInput = driver.findElement(By.id("ap_password_check"));
        confirmPasswordInput.sendKeys("Kavya@9836");

        
        WebElement finalCreateAccountButton = driver.findElement(By.id("continue"));
        finalCreateAccountButton.click();

        
        WebElement successMessage = driver.findElement(By.className("a-alert-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Registration success message not displayed.");

        // Negative Scenario
        driver.get("https://www.amazon.com/");
        // Click on the "Sign in" link
        signInLink.click();

        // Fill in registration details with an existing email
        emailInput.sendKeys("ch.kavya9836@gmail.com");
        passwordInput.sendKeys("Kavya@9836");
        confirmPasswordInput.sendKeys("Kavya@9836");
        finalCreateAccountButton.click();

        // Assertions for registration failure
        WebElement errorMessage = driver.findElement(By.id("auth-email-missing-alert"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message for existing email not displayed.");
    }
 

    @Test
    public void testUserLogin() {
        
        driver.get("https://www.amazon.com/");
        
        WebElement signInLink = driver.findElement(By.id("nav-link-accountList"));
        signInLink.click();

        
        WebElement emailInput = driver.findElement(By.id("ap_email"));
        emailInput.sendKeys("ch.kavya9836@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("ap_password"));
        passwordInput.sendKeys("Kavya@9836");


        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();

        
        WebElement userGreeting = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Assert.assertTrue(userGreeting.isDisplayed(), "User greeting not displayed, login failed.");

       
        driver.get("https://www.amazon.com/");
      
        signInLink.click();

       
        emailInput.sendKeys("ch.kavya9836@gmail.com");
        passwordInput.sendKeys("9836983698");
        signInButton.click();


        WebElement errorMessageBox = driver.findElement(By.id("auth-error-message-box"));
        Assert.assertTrue(errorMessageBox.isDisplayed(), "Error message box for invalid login not displayed.");
    }

    @Test
    public void testProductSearchAndFilter() {
       
        driver.get("https://www.amazon.com/");
        
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");


        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

    
        WebElement resultCount = driver.findElement(By.xpath("//span[@data-component-type='s-result-count']"));
        Assert.assertTrue(resultCount.isDisplayed(), "Search results count not displayed.");

   
        WebElement minPriceFilter = driver.findElement(By.id("low-price"));
        WebElement maxPriceFilter = driver.findElement(By.id("high-price"));
        minPriceFilter.sendKeys("500");
        maxPriceFilter.sendKeys("1000");
        driver.findElement(By.cssSelector("input[value='Go']")).click();

       
        WebElement filteredResultCount = driver.findElement(By.xpath("//span[@data-component-type='s-result-count']"));
        Assert.assertTrue(filteredResultCount.isDisplayed(), "Filtered results count not displayed.");

      
        driver.get("https://www.amazon.com/");
        
        searchBox.sendKeys("xyz123");
        searchButton.click();

       
        WebElement noResultsMessage = driver.findElement(By.xpath("//span[contains(text(),'No results for')]"));
        Assert.assertTrue(noResultsMessage.isDisplayed(), "No results message not displayed.");
    }


    @Test
    public void testAddToShoppingCart() {
       
        driver.get("https://www.amazon.com/");
        
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("headphones");

      
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();


        WebElement firstProduct = driver.findElement(By.xpath("//div[@data-index='0']//a[@class='a-link-normal']"));
        firstProduct.click();


        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        
        WebElement cartItemCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartItemCount.getText(), "1", "Product not added to the cart.");

      
        driver.get("https://www.amazon.com/");
        // Perform a search with non-existing product
        searchBox.sendKeys("xyz123");
        searchButton.click();

      
        Assert.assertTrue(driver.findElements(By.id("add-to-cart-button")).isEmpty(), "Add to Cart button found for non-existing product.");
    }


    @Test
    public void testCheckoutProcess() {
      
        driver.get("https://www.amazon.com/");
   
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("smartphone");

       
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();


        WebElement firstProduct = driver.findElement(By.xpath("//div[@data-index='0']//a[@class='a-link-normal']"));
        firstProduct.click();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

       
        WebElement cartIcon = driver.findElement(By.id("nav-cart"));
        cartIcon.click();

       
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//a[@id='hlb-ptc-btn-native']"));
        proceedToCheckoutButton.click();

      
        WebElement checkoutTitle = driver.findElement(By.xpath("//span[@class='a-text-bold' and contains(text(),'Select a shipping address')]"));
        Assert.assertTrue(checkoutTitle.isDisplayed(), "Checkout page not reached successfully.");

      
        driver.get("https://www.amazon.com/");
        
        cartIcon.click();
        WebElement emptyCartMessage = driver.findElement(By.xpath("//h1[contains(text(),'Your Shopping Cart is empty.')]"));
        Assert.assertTrue(emptyCartMessage.isDisplayed(), "Empty cart message not displayed.");

        driver.get("https://www.amazon.com/gp/cart/view.html/");
        Assert.assertTrue(emptyCartMessage.isDisplayed(), "Empty cart message not displayed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}