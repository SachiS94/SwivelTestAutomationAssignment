
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestObjects {

	private WebDriver driver;
	
	public TestObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public Select getCategoryListElement() {
		
		return new Select(this.driver.findElement(By.id("searchDropdownBox")));
	}
	
	public WebElement getSearchtextBox() {
		
		return this.driver.findElement(By.id("twotabsearchtextbox"));
	}
	
	public WebElement getSearchButton() {
		
		return this.driver.findElement(By.id("nav-search-submit-button"));
	}
	
	public WebElement getCustomerReviewsElement() {
		
		return this.driver.findElement(By.id("p_72/1250221011"));
	}
	
	public WebElement getPrefferedLanguageElement() {
		
		return this.driver.findElement(By.xpath("//*[@id=\"p_n_feature_nine_browse-bin/3291437011\"]/span/a/span"));
	}
	
	public WebElement getSecondProductElementOnSearchResults() {
		
		return this.driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
	}
	
	public WebElement getUnitPriceElement() {
		
		try {
			return this.driver.findElement(By.id("price"));
		} catch (NoSuchElementException exception) {
			return this.driver.findElement(By.id("corePrice_feature_div"));
		}
	}
	
	public WebElement getProuductPageTitleElement() {
		
		return this.driver.findElement(By.id("productTitle"));
	} 
	
	public Select getQuantityListElement() {
		
		return new Select(this.driver.findElement(By.id("quantity")));
	} 
	
	public WebElement getAddToCartButton() {
		
		return this.driver.findElement(By.id("add-to-cart-button"));
	}
	
	public WebElement getGoToCartButton() {
		
		return this.driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a"));
	}
	
	public WebElement getCartItemName() {
		
		return this.driver.findElement(By.className("sc-grid-item-product-title"));
	}
	
	public WebElement getActiveCartSubTotalElement() {
		
		return this.driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-activecart\"]/span"));
	}
	
	public Select getCartQuantityListElement() {
		
		return new Select(this.driver.findElement(By.id("quantity")));
	} 
}
