import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	private WebDriver driver;
	
	public Utils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void wait(int seconds) {
		
		//new WebDriverWait(this.driver, Duration.ofSeconds(seconds));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
}
