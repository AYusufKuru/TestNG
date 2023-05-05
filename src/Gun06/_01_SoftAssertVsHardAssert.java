package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {


    @Test
    void hardAssert(){
        String s1 = "Merhaba";
        Assert.assertEquals("Merhaba",s1,"Oluşanla beklenen aynı değil.");
    }

    @Test
    void softAssert(){
        String strHomePage="www.facebook.com/homepage";
        String strCardPage="www.facebook.com/cardpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert _softAsser = new SoftAssert();

        _softAsser.assertEquals("www.facebook.com/homepage", strHomePage);
        System.out.println("soft assert 1");
        _softAsser.assertEquals("www.facebook.com/profile", strCardPage);
        System.out.println("soft assert 2");
        _softAsser.assertEquals("www.facebook.com/settings", strEditAccount);
        System.out.println("soft Assert 3");

        _softAsser.assertAll();  // Bütün asser sonuçları işleme koyulur.
        System.out.println("soft AssertAll : aktiflik sonrası");
        // bu bölüm assertAll dan sonra olduğu ve öncesinde hata için ekrana çıkamayacak.
    }

}
