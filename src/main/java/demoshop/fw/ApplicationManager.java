package demoshop.fw;

import demoshop.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class ApplicationManager {
    private final String browser;
    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    private UserHelper user;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Test started in Chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            logger.info("Test started in Firefox");
        }
        user = new UserHelper(driver);

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Current URL: " + driver.getCurrentUrl());
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }
}
