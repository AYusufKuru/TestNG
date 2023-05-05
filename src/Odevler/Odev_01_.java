package Odevler;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

//1-Senaryo
//1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
//2- random 100 e kadar 2 sayı üretiniz.
//3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
//4- Sonuçları Assert ile kontrol ediniz.
//5- Yukarıdaki işlemi 5 kez tekrar ettiriniz.

//2-Senaryo
//1- https://www.youtube.com/ adresine gidiniz
//2- "Selenium" kelimesi ile video aratınız.
//3- Listelenen sonuçlarda 80 videoaya kadar lsiteyi uzatınız.
//4- Son videonun title ını yazdırınız.
public class Odev_01_ extends BaseDriver {

    By firstNumber = By.id("number1Field");
    By secondNumber = By.id("number2Field");
    By calculate = By.id("calculateButton");
    By rslt = By.name("numberAnswer");
    WebElement ddmenu = driver.findElement(By.id("selectOperationDropdown"));
    Select Menu= new Select(ddmenu);

    @Test
    public void Test1(){
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        WebElement num1 = driver.findElement(firstNumber);
        num1.sendKeys(RandomNumber());
        WebElement num2 = driver.findElement(secondNumber);
        num2.sendKeys(RandomNumber());
        Menu.selectByIndex(0);
        WebElement calBtn = driver.findElement(calculate);
        calBtn.click();
        WebElement resoult = driver.findElement(rslt);
       // Assert.assertTrue(resoult.getText().equals(Integer.toString(num1+num2)));

    }






    public String RandomNumber(){
        String a = Integer.toString((int)Math.random()*100);
        return a;
    }
}
