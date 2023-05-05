package Gun02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Ornek extends BaseDriver {
    @Test
    void test1(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        Tools.Bekle(1);
        WebElement eMail = driver.findElement(By.name("email"));
        eMail.sendKeys("yusufK@gmail.com");

        Tools.Bekle(1);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("1390039Yk.");

        Tools.Bekle(1);

        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));

       // List<WebElement> myAccound = driver.findElements(By.id("content1"));
       // System.out.println(myAccound.size());
        //Assert.assertTrue(myAccound.size() >= 1);

    }

}
