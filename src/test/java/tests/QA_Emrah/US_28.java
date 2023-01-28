package tests.QA_Emrah;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmrahUSPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class US_28 {
    @Test
    public void TC_01() {
        //When the submit button is pressed, it should redirected to the course_edit/Curriculum
        // section and Congratulations! message should appear in the corner
        //(Gönder düğmesine basıldığında, Course_edit/Curriculum bölümüne yönlendirilmelidir
        // ve Tebrikler! mesaj köşede görünmelidir)

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

        //-"Course Manager" linkine tıklanır
        emrahUSPage.courseManagerLinki.click();

        //-Actions başlıklı üç nokta tıklanır
        emrahUSPage.ED2actionsDropdownLinki.click();

        //-Edit this course linkine tıklanır
        emrahUSPage.editThisCourseLinki.click();

        //- Finish linkine tıklanır
        emrahUSPage.finishLinki.click();

        //- Submit butonuna tıklanır
        emrahUSPage.submitButonu.click();

        //-Köşede beliren yazının Congratulations icerdigi kontrol edilir
        String expectedKelime="Congratulations";
        String actualSonucYazisi= emrahUSPage.congratulationsYazisi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        Driver.closeDriver();


    }
}
