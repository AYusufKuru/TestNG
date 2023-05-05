package Gun02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class _01_Enable {
    public static WebDriver driver;
    @BeforeClass
    void baslangicIslemleri() {

        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        // outputtaki gerekmeyen logları kaldıracağız
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }

    @Test
    void test1() {
        System.out.println("test 1");
    }

    @Test(enabled = false)
    void test2() {
        System.out.println("test 2");
    }

    @Test
    void test3() {
        System.out.println("test 3");
    }

    @AfterClass
    void bitisIslemleri() {
        System.out.println("test 3");
    }
}
