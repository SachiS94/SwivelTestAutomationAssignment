import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	
	static Logger log = Logger.getLogger(Test.class);

	public static void main(String[] args) throws IOException {
		
		FileReader reader = new FileReader("src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(reader);
		
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driverLocation"));
		WebDriver driver = new ChromeDriver();
		
		TestObjects testObjects = new TestObjects( driver);
		Utils utils = new Utils(driver);
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Launch the site
		driver.get(prop.getProperty("url"));
		log.info("Launched Amazon url");
	
		utils.wait(10);
		
		//Select books from the dropdown
		Select menu = testObjects.getCategoryListElement();
		menu.selectByVisibleText("Books");
		log.info("Selected category Books from category list");
		
		
		//searching for the keyword automation
		testObjects.getSearchtextBox().sendKeys("automation"); 
		testObjects.getSearchButton().click();
		log.info("Searched for key word Automation");
		
		  
		utils.wait(10);
			
		//clicking on customer reviews 4 and up
		testObjects.getCustomerReviewsElement().click(); 
		log.info("Selected customer reviews 4 and up");
		
		
		utils.wait(10);
		
		//select English as the preferred language
		testObjects.getPrefferedLanguageElement().click();
		log.info("Selected customer reviews 4 and up");
		
		utils.wait(10);
		
		//assert name of the second item from the product list
		String title = testObjects.getSecondProductElementOnSearchResults().getText();
		log.info("Getting the item name of the second item on the list");
		
		//click on the second product on the list
		testObjects.getSecondProductElementOnSearchResults().click();
		log.info("Clicked on  the second item on the list");
		
		utils.wait(10);
		
		//getting the unit price
		Double price = Double.parseDouble(testObjects.getUnitPriceElement().getText().substring(1));
		log.info("Getting the unit price of the item selected");
		
		//assert the titles
		String titleProduct = testObjects.getProuductPageTitleElement().getText();
		Assert.assertEquals(title, titleProduct);
		log.info("Asserted the product titles");
			
		utils.wait(10);
		
		//setting the quantity to 2
		Select quantity = testObjects.getQuantityListElement();
		quantity.selectByVisibleText("2");
		log.info("Selected the quantity as 2");
		
		utils.wait(10);;
		
		//clicking on add to cart button
		testObjects.getAddToCartButton().click();
		log.info("Clicked on add to cart button");
		
		utils.wait(10);
		
		//clicking on go to cart button
		testObjects.getGoToCartButton().click();
		log.info("Clicked on go to cart button");
		
		utils.wait(10);
		
		//verifying the cart details
		String cartTitle = testObjects.getCartItemName().getText();
		Assert.assertEquals(title,cartTitle);
		
		Double subtotal = Double.parseDouble(testObjects.getActiveCartSubTotalElement().getText().substring(1));
		Double total = 2* price;
		Assert.assertEquals(subtotal, total);
		log.info("Asserted the cart details");
		
		utils.wait(10);
		
		//clearing cart
		Select cartQuantity = testObjects.getCartQuantityListElement();
		cartQuantity.selectByVisibleText("0 (Delete)");
		log.info("Cleared the cart");
		
		utils.wait(10);
		
		//verifying that the new sub total is 0
		String updatedSubtotal = testObjects.getActiveCartSubTotalElement().getText();
		updatedSubtotal.trim();
		Assert.assertEquals(updatedSubtotal,"$0.00");
		log.info("Asserted that the updated price is 0");
		
		//quit driver
		log.info("Quitting the driver");
		driver.quit();

	}

}
