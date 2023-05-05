package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void baslangicIslemleri() {

        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");//gereksis bildirimleri silme

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
       // loginTest();
    }

    @AfterClass
   public void bitisIslemleri() {
        Tools.Bekle(5);
        driver.quit();
    }

    void loginTest(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        Tools.Bekle(1);
        WebElement eMail = driver.findElement(By.name("email"));
        eMail.sendKeys("yusufK@gmail.com");

        Tools.Bekle(1);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("1390039Yk");

        Tools.Bekle(1);

        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));

        // List<WebElement> myAccound = driver.findElements(By.id("content1"));
        // System.out.println(myAccound.size());
        //Assert.assertTrue(myAccound.size() >= 1);
    }
}
