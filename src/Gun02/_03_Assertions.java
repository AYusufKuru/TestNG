package Gun02;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void equalOrnek(){
        String s1 = "Merhaba";
        String s2 = "Merhaba";

        // Actual(oluşan), Expected(beklenen), Mesaj(obsiyonel)
        Assert.assertEquals(s1,s2,"Karşılaştırma başarısız oldu.");
    }
    @Test
    void notEqualOrnek(){
        String s1 = "Merhaba";
        String s2 = "Merhaba1";

        // Actual(oluşan), Expected(beklenen), Mesaj(obsiyonel)
        Assert.assertNotEquals(s1,s2,"Oluşan ve beklenen eşit oldu");
    }
    @Test
    void trueOrnek(){
        int s1 = 55;
        int s2 = 55;

        // Expected(beklenen), Mesaj(obsiyonel)
        Assert.assertTrue(s1 == s2, "Oluşan ve beklenen eşit olmadı");
    }
    @Test
    void nullOrnek(){
        String s1 = null;

        Assert.assertNull(s1, "Oluşan null olmadı");
    }
    @Test
    void direktFail(){
        int a = 55;

        if (a==55)
        Assert.fail();
    }

}
