import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class SelectDropdown {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver");
        ChromeOptions ops=new ChromeOptions();
        //ops.addArguments("--headed");
        ops.addArguments("--headless");//for not opening browser
        driver=new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void selectDropdown(){
        driver.get("https://demoqa.com/select-menu");
        Select color=new Select(driver.findElement(By.id("oldSelectMenu")));
        color.selectByValue("3");
    }
    @After
    public void finishTest() {
        driver.close();
    }
}
