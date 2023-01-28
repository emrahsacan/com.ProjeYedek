package tests.QA_Emrah;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmrahUSPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class US_18 {
    @Test //Calisti
    public void TC_01() {

        //-"https://qa.qualitydemy.com/" sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("emrahQDUrl"));
        //- Login butonuna basılır
        EmrahUSPage emrahUSPage = new EmrahUSPage();
        emrahUSPage.ilkLoginLinki.click();
        //- e mail ve password girilerek kullanıcı girişi yapılır
        emrahUSPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("emrahEmail"));
        emrahUSPage.passwordKutusu.sendKeys(ConfigReader.getProperty("emrahPassword"));
        ReusableMethod.bekle(2);
        // -cookie accept butonuna basılır
        emrahUSPage.cookieButtonAccept.click();
        ReusableMethod.bekle(1);
        //- Sağ köşede bulunan kullanıcı ikonuna tıklanır
        emrahUSPage.loginButonu.click();

        //-"Instructor" linki tıklanır
        emrahUSPage.instructorLink.click();

        //-"Number of courses" linkine tıklanır
        emrahUSPage.numberOfCoursesLinki.click();

        //- courses sayfasında olduğumuz kontrol edilir

        String expectedKelime = "Courses";
        String actualSonuc = emrahUSPage.coursesYazisi.getText();

        Assert.assertTrue(actualSonuc.contains(expectedKelime));

        Driver.closeDriver();

    }

    @Test //Calisti
    public void TC_02() {
        //-"https://qa.qualitydemy.com/" sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("emrahQDUrl"));
        //- Login butonuna basılır
        EmrahUSPage emrahUSPage = new EmrahUSPage();
        emrahUSPage.ilkLoginLinki.click();
        //- e mail ve password girilerek kullanıcı girişi yapılır
        emrahUSPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("emrahEmail"));
        emrahUSPage.passwordKutusu.sendKeys(ConfigReader.getProperty("emrahPassword"));
        ReusableMethod.bekle(2);
        // -cookie accept butonuna basılır
        emrahUSPage.cookieButtonAccept.click();
        ReusableMethod.bekle(1);
        //- Sağ köşede bulunan kullanıcı ikonuna tıklanır
        emrahUSPage.loginButonu.click();

        //-"Instructor" linki tıklanır
        emrahUSPage.instructorLink.click();

        //-"Pending Balance" linkine tıklanır
        emrahUSPage.pendingBalanceLinki.click();

        //- "Payout report" sayfasında olduğumuz kontrol edilir
        String expectedKelime = "Payout report";
        String actualSonuc = emrahUSPage.payoutReportYazisi.getText();

        Assert.assertTrue(actualSonuc.contains(expectedKelime));

        Driver.closeDriver();
    }

    @Test
    public void TC_03() {
        //-"https://qa.qualitydemy.com/" sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("emrahQDUrl"));
        //- Login butonuna basılır
        EmrahUSPage emrahUSPage = new EmrahUSPage();
        emrahUSPage.ilkLoginLinki.click();
        //- e mail ve password girilerek kullanıcı girişi yapılır
        emrahUSPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("emrahEmail"));
        emrahUSPage.passwordKutusu.sendKeys(ConfigReader.getProperty("emrahPassword"));
        ReusableMethod.bekle(2);
        // -cookie accept butonuna basılır
        emrahUSPage.cookieButtonAccept.click();
        ReusableMethod.bekle(1);
        //- Sağ köşede bulunan kullanıcı ikonuna tıklanır
        emrahUSPage.loginButonu.click();

        //-"Instructor" linki tıklanır
        emrahUSPage.instructorLink.click();

        //-"Requested withdrawal amount" linkine tıklanır
        emrahUSPage.requestedWithdrawalAmountLinki.click();

        // - "Payout report" sayfasında olduğumuz kontrol edilir
        String expectedKelime = "Payout report";
        String actualSonuc = emrahUSPage.payoutReportYazisi.getText();

        Assert.assertTrue(actualSonuc.contains(expectedKelime));

        Driver.closeDriver();

    }
}
