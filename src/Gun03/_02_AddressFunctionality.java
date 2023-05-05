package Gun03;

/*
    Senaryo;
    1- Siteyi acçınız.
    2- Adress ekleyiniz.
    3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
    4- En son adresi siliniz.
*/

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class _02_AddressFunctionality extends BaseDriver {

    @Test
    void addAddress(){
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();
        WebElement newAddress = driver.findElement(By.linkText("New Address"));
        newAddress.click();

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Ahmet Yusuf");
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Kuru");
        WebElement addressName = driver.findElement(By.cssSelector("input[name='address_1']"));
        addressName.sendKeys("Trabzon/Sürmene");
        WebElement city = driver.findElement(By.cssSelector("input[name='city']"));
        city.sendKeys("Trabzon");
        WebElement postCode = driver.findElement(By.cssSelector("input[name='postcode']"));
        postCode.sendKeys("123456789");

        WebElement countryMenu = driver.findElement(By.cssSelector("select[name='country_id']"));
        Select cntMenu= new Select(countryMenu);
        cntMenu.selectByVisibleText("Turkey");

        //2. Seçenek
        wait.until(ExpectedConditions.elementToBeClickable(countryMenu));
        //ülke seçimi clickable olana kadar bekleme

        // 1. Seçenek
//        WebElement options = driver.findElement(By.cssSelector("Select[id='input-zone']>option"));
//        wait.until(ExpectedConditions.stalenessOf(options)); //bayatlama geçene kadar bekle


        WebElement webState = driver.findElement(By.id("input-zone"));
        Select state = new Select(webState);
        //state.selectByVisibleText("Ankara");
        //state.selectByValue("3321");
        state.selectByIndex(7);//indexle bulma implicitlyWait ile çalışmaz element bayatlar

//        rgnMenu.selectByVisibleText("Trabzon");//indexle bulma implicitlyWait ile çalışmaz element bayatlar

        WebElement editBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        editBtn.click();

    }

    @Test(dependsOnMethods = {"addAddress"})
    void editAddress(){
        WebElement editBtn = driver.findElement(By.linkText("Edit"));
        editBtn.click();
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.clear();
        firstName.sendKeys("Ahmet");
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.clear();
        lastName.sendKeys("Şahin");
        WebElement editBtn1 = driver.findElement(By.cssSelector("input[type='submit']"));
        editBtn1.click();
    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress(){
        WebElement deleteBtn = driver.findElement(By.linkText("Delete"));
        deleteBtn.click();
    }
}
