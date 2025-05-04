package demoshop.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;

public class BaseHelper {
    protected WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        if (text == null || text.isEmpty()) {
            return;
        }
        WebElement el = driver.findElement(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File png = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, png);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return png.getAbsolutePath();
    }
}