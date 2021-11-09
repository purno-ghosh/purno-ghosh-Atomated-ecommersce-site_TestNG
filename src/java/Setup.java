import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Setup {


    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        driver = new ChromeDriver(ops);
        ops.addArguments("--headed");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void ScreenShot(ITestResult result) throws IOException{
        if(ITestResult.FAILURE==result.getStatus()){
            try {
                Utils util=new Utils(driver);
                util.takeScreenShot();
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }

    }
}