package Gun02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone olunuz(YES)
 */
public class _04_SubscribeNewsLetter extends BaseDriver {

    By link = By.linkText("Newsletter");
    By subYes = By.cssSelector("input[value='0']");
    By subNo = By.cssSelector("input[value='0']");
    By ctnBtn = By.cssSelector("input[type='submit']");

    @Test(priority = 0)
    void subscribeFunctionYes() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        Tools.Bekle(1);
        WebElement newsLetter = driver.findElement(link);
        newsLetter.click();

        Tools.Bekle(1);
        WebElement subscribeRadio = driver.findElement(subYes);
        subscribeRadio.click();

        Tools.Bekle(1);
        WebElement contiune = driver.findElement(ctnBtn);
        contiune.click();
        Tools.Bekle(1);
        Tools.successMessageValidation();
    }
    @Test(priority = 1)
    void subscribeFunctionNo() {

        Tools.Bekle(1);
        WebElement newsLetter = driver.findElement(link);
        newsLetter.click();

        Tools.Bekle(1);
        WebElement subscribeRadio = driver.findElement(subYes);
        subscribeRadio.click();

        Tools.Bekle(1);
        WebElement contiune = driver.findElement(ctnBtn);
        contiune.click();
        Tools.Bekle(1);
        Tools.successMessageValidation();
    }
    @Test(priority = 2)
    void subscribeFunctionReverse() {

        Tools.Bekle(1);
        WebElement newsLetter = driver.findElement(link);
        newsLetter.click();

        WebElement subscribeRadioYes = driver.findElement(subYes);
        WebElement subscribeRadioNo = driver.findElement(subNo);

        if (subscribeRadioYes.isSelected()){
            subscribeRadioNo.click();
        }else
            subscribeRadioYes.click();

        WebElement contiune = driver.findElement(ctnBtn);
        contiune.click();
        Tools.successMessageValidation();
    }
}
