package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tools {
    public static void Bekle(int sn)
    {
        try {
            Thread.sleep(1000*sn); // ms beklediği
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void successMessageValidation(){
        WebElement msgLabel = BaseDriver.driver.findElement(By.xpath("//*[contains(text(), 'has been successfully updated!')]"));
        Assert.assertTrue(msgLabel.getText().equals("has been successfully updated!"));
    }
}
