package tests.QA_Emrah;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmrahUSPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.Set;

public class US_19  {


    @Test  //Çalışıyor
    public void TC_01() {
        //When the appropriate values are selected from the filter and the filter button is pressed, the relevant course
        // should appear in the list.(Filtreden uygun değerler seçilip filtre butonuna basıldığında ilgili ders listede görünmelidir.)

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

        //-Categories başlıklı dropdown menüsünden "Web Design for Web Developers" seçilir (önceden yüklü dersin kategorisi)
        Select select1 = new Select(emrahUSPage.categoriesDropdownLinki);
        select1.selectByVisibleText("Web Design for Web Developers");

        //-Status başlıklı dropdown menüsünden "Active" seçilir
        Select select2 = new Select(emrahUSPage.statusDropdownLinki);
        select2.selectByVisibleText("Active");

        //-Price dropdown menüsünden "Paid" seçilir
        Select select3 = new Select(emrahUSPage.priceDropdownLinki);
        select3.selectByVisibleText("Paid");

        //-"Filter" butonuna tıklanır
        emrahUSPage.filterLinki.click();

        //-Çıkan ders listesinde Category bölümü bilgisi ile seçilen değerin aynı olup olmadığı test edilir
        String expectedKelime = "Web Design for Web Developers";  // Emrah deneme 4 dersi
        String actualSonuc = emrahUSPage.categoriesYazisi.getText();

        Assert.assertTrue(actualSonuc.contains(expectedKelime));

        Driver.closeDriver();
    }

    @Test //Calisiyor
    public void TC_02() {
        // Course should be able to get selected from the search box
        // (Kurs, arama kutusundan seçilebilmelidir.)

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

        //-Arama Butonuna aranacak ders ismi  yazılır
        emrahUSPage.dersAramaKutusu.sendKeys("Emrah deneme 1" + Keys.ENTER);


        //-Sıralanan dersin isminin aranan değer ile aynı olup olmadığı kontrol edilir
        String expectedKelime = "Emrah deneme 1";
        String actualAramaSonucu = emrahUSPage.aramaSonucuDersinIsmi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

        Driver.closeDriver();
    }

    @Test //calisiyor
    public void TC_03() {
        //Clicking on the three dots under the action section and clicking the View course on frontend link should
        // redirect to the page of the relevant course. (Action bölümünün altında bulunan üç noktaya tıklanarak ve
        // View Course on frontend linkine tıklandığında ilgili dersin sayfasına yönlendirilmelidir.)

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

        //-"View Course on frontend" linki tıklanır
        // Yeni sekme açılacağından ilk sekmenin handle degerini alalım sonra tıkla yapalım
        String ilkSayfaHandleDegeri= Driver.getDriver().getWindowHandle();
        emrahUSPage.viewCourseOnFrontendButonu.click();

        //-Açılan yeni sekme sayfasının ders ismi kontrol edilir
        ReusableMethod.bekle(2);

        Set<String> tumWHDegerleriSeti= Driver.getDriver().getWindowHandles();

        String ikinciSayfaWHD="";
        for (String eachWhd:tumWHDegerleriSeti) {
            if (!eachWhd.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaWHD=eachWhd;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);

        String expectedKelime = "Emrah deneme 2";
        String actualTitle = emrahUSPage.yeniSekmeninTitleYazisi.getText();

        Assert.assertTrue(actualTitle.contains(expectedKelime));

        Driver.quitDriver();

    }

    @Test //Calisti
    public void TC_04() {
        //Clicking on the three dots under the action section and clicking the Go to course playing page link should
        // lead to the page of the relevant course content. (Action bölümünün altındaki üç noktaya tıklayıp
        // Go to Course playing page linkine tıklandığında ilgili ders içeriğinin bulunduğu sayfaya yönlendirilmelidir.)

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

        //-"Go to Course playing page" linki tıklanır
        // Yeni sekme açılacağından ilk sekmenin handle degerini alalım sonra tıkla yapalım
        String ilkSayfaHandleDegeri= Driver.getDriver().getWindowHandle();
        emrahUSPage.goToCoursePlayingPageLinki.click();

        //-Açılan yeni sekme sayfasında "Course content" -ders içeriği-  yazısı kontrol edilir
        ReusableMethod.bekle(2);

        Set<String> tumWHDegerleriSeti= Driver.getDriver().getWindowHandles();

        String ikinciSayfaWHD="";
        for (String eachWhd:tumWHDegerleriSeti) {
            if (!eachWhd.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaWHD=eachWhd;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);

        String expectedKelime = "Course content";
        String actualTitle = emrahUSPage.YSekmeCourseContentYazisi.getText();

        Assert.assertTrue(actualTitle.contains(expectedKelime));

        Driver.quitDriver();

    }

    @Test // Calisti
    public void TC_05() {
        //When you click on the three dots under the action section and click on the Edit this course link, it should
        // redirect to the edit page of the relevant course. (Action bölümünün altındaki üç noktaya tıklayıp
        // Edit this course-bu dersi düzenle- linkine tıkladığınızda ilgili dersin edit sayfasına yönlendirilmelidir.)

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

        // -Açılan sayfa başlığında "Edit Course" yazısı kontrol edilir
        ReusableMethod.bekle(3);

        String expectedAcilanSayfaTitle="Edit course";
        String actualSayfaTitle= Driver.getDriver().getTitle();

        // Assert.assertEquals(expectedAcilanSayfaTitle,actualSayfaTitle);

        Assert.assertTrue(actualSayfaTitle.contains(expectedAcilanSayfaTitle));

        Driver.closeDriver();

    }

    @Test //Calisti
    public void TC_06() {
        //Clicking on the three dots under the action section and clicking the Section and lesson link should
        // lead to the edit page of the relevant course. (Action bölümünün altında bulunan üç noktaya tıklayıp,
        // Section and lesson linkine tıklandığında ilgili dersin edit sayfasına yönlendirilmelidir.)

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
        //-"Section and lesson" linki tıklanır
        emrahUSPage.sectionAndLessonLinki.click();

        // -Açılan sayfa başlığında "Edit Course" yazısı kontrol edilir
        ReusableMethod.bekle(3);
        String expectedAcilanSayfaTitle="Edit course";
        String actualSayfaTitle= Driver.getDriver().getTitle();

        // Assert.assertEquals(expectedAcilanSayfaTitle,actualSayfaTitle);

        Assert.assertTrue(actualSayfaTitle.contains(expectedAcilanSayfaTitle));

        Driver.closeDriver();

    }

    @Test //Calisti  ESKİ HALİNE DÖNMESİ İÇİN ARDINDAN TC08'İ ÇALIŞTIRMAK GEREKİYOR YOKSA DİĞER DENEMEDE HATA VERİR!!
    public void TC_07_And_TC_08() {
        // When you click on the three dots under the action section and click on the Mark as drafted link, a
        // confirmation message should come and after approval, the status section of the course should change to draft.
        // (Action bölümünün altındaki üç noktaya tıklayıp Mark as drafted linkine tıkladığınızda onay mesajı gelmeli ve
        // onaydan sonra dersin durum bölümü draft olarak değişmelidir.)
        // When you click on the three dots under the action section and click on the Publish this course link,
        // a confirmation message should come and after approval, the status section of the course should
        // change to active. (Action bölümünün altındaki üç noktaya tıklayıp Publish this course -Bu kursu yayınla-
        // linkine tıkladığınızda bir onay mesajı gelmeli ve onaydan sonra kursun durum bölümü aktif olarak değişmelidir.)


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
        //-"Mark as drafted" linki tıklanır
        emrahUSPage.markAsDraftedLinki.click();

        //-Açılan onay mesajı sayfasından "Continue" butonu tıklanır
        emrahUSPage.continueButonu.click();

        //- Dersin Status başlığı altında "draft" yazısı kontrol edilir
        ReusableMethod.bekle(2);
        String expectedKelime = "Draft";
        String actualStatusYazisi = emrahUSPage.draftYazisi.getText();

        Assert.assertTrue(actualStatusYazisi.contains(expectedKelime));

        //Tekrar denemede çalisabilmesi için kontrol sonrası tekrar Active edilir. Yani TC08'de istenen yapilir

        // TC08()----------------------------------------------------------------------

        //-Actions başlıklı üç nokta tıklanır
        emrahUSPage.ED2actionsDropdownLinki.click();

        //-"Publish this course" linki tıklanır
        emrahUSPage.publishThisCourseLinki.click();

        //-Açılan onay mesajı sayfasından "Continue" butonu tıklanır
        emrahUSPage.continueButonu.click();

        //- Dersin Status başlığı altında "active" yazısı kontrol edilir
        ReusableMethod.bekle(2);
        String expectedActiveKelime = "Active";
        String actualStatusYazisiSon = emrahUSPage.activeYazisi.getText();

        Assert.assertTrue(actualStatusYazisiSon.contains(expectedActiveKelime));

        Driver.quitDriver();
    }
    // TC_08 AYRI TESTİ pasif halde kalsın!!!
    //@Test
    //public void TC_08() {
    //    // When you click on the three dots under the action section and click on the Publish this course link,
    //    // a confirmation message should come and after approval, the status section of the course should
    //    // change to active. (Action bölümünün altındaki üç noktaya tıklayıp Publish this course -Bu kursu yayınla-
    //    // linkine tıkladığınızda bir onay mesajı gelmeli ve onaydan sonra kursun durum bölümü aktif olarak değişmelidir.)


    //    //-"https://qa.qualitydemy.com/" sayfasına gidilir
    //    Driver.getDriver().get(ConfigReader.getProperty("emrahQDUrl"));

    //    //- Login butonuna basılır
    //    EmrahUSPage emrahUSPage = new EmrahUSPage();
    //    emrahUSPage.ilkLoginLinki.click();

    //    //- e mail ve password girilerek kullanıcı girişi yapılır
    //    emrahUSPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("emrahEmail"));
    //    emrahUSPage.passwordKutusu.sendKeys(ConfigReader.getProperty("emrahPassword"));
    //    ReusableMethod.bekle(2);

    //    // -cookie accept butonuna basılır
    //    emrahUSPage.cookieButtonAccept.click();
    //    ReusableMethod.bekle(1);

    //    //- Sağ köşede bulunan kullanıcı ikonuna tıklanır
    //    emrahUSPage.loginButonu.click();

    //    //-"Instructor" linki tıklanır
    //    emrahUSPage.instructorLink.click();

    //    //-"Course Manager" linkine tıklanır
    //    emrahUSPage.courseManagerLinki.click();

    //    //-Actions başlıklı üç nokta tıklanır
    //    emrahUSPage.ED2actionsDropdownLinki.click();

    //    //-"Publish this course" linki tıklanır
    //    emrahUSPage.publishThisCourseLinki.click();

    //    //-Açılan onay mesajı sayfasından "Continue" butonu tıklanır
    //    emrahUSPage.continueButonu.click();

    //    //- Dersin Status başlığı altında "active" yazısı kontrol edilir
    //    ReusableMethod.bekle(2);
    //    String expectedKelime = "Active";
    //    String actualStatusYazisi = emrahUSPage.activeYazisi.getText();

    //    Assert.assertTrue(actualStatusYazisi.contains(expectedKelime));

    //    Driver.quitDriver();
    //}
    @Test //Calisti
    public void TC_09() {
        //When you click on the three dots under the action section and click on the delete link from here,
        // a confirmation message should come and the course should be deleted from the list after approval.
        // (Action bölümünün altında bulunan üç noktaya tıklayıp buradan sil linkine tıkladığınızda onay mesajı
        // gelmeli ve onay alındıktan sonra ders listeden silinmelidir.)


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

        //-Silinecek dersin Actions başlıklı üç nokta butonu tıklanır
        emrahUSPage.silinecekDersinActionsButonu.click();
        //Burada locate aldığımız buton silme işlemi olacağından geri gelmeyecektir!! Bu sebeple her kodu
        //   çalistirdiğimizda yeniden locate alıp tanımlamalıyız!!
        // -"delete" linki tıklanır
        emrahUSPage.deleteLinki.click();
        // -Açılan onay mesajı sayfasından "Continue" butonu tıklanır
        //    emrahUSPage.continueButonu.click();

        // - Listede silinen dersin görüntülenmediği kontrol edilir
        ReusableMethod.bekle(2);

        ReusableMethod.tumSayfaScreenshotCek(Driver.getDriver());

        ReusableMethod.bekle(3);

        // String expectedSilinecekDersIsmi = "Silinecek test dersi";
        // String actualDersIsmi = emrahUSPage.silinecekTestDersiIsmi.getText();

        // Assert.assertTrue(!actualDersIsmi.contains(expectedSilinecekDersIsmi));

        Driver.quitDriver();

    }

    @Test //Calisti
    public void TC_10() {

        //Clicking the add new course button should redirect to the add_course page (Yeni kurs ekle düğmesine
        // tıklandığında, add_course sayfasına yönlendirilmelidir)

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

        //-"add new course" linki tıklanır
        emrahUSPage.addNewCourseLinki.click();


        //- Açılan sayfa başlığında "Add course" yazısı kontrol edilir
        ReusableMethod.bekle(3);
        String expectedAcilanSayfaTitle="Add course";
        String actualSayfaTitle= Driver.getDriver().getTitle();

        Assert.assertTrue(actualSayfaTitle.contains(expectedAcilanSayfaTitle));

        Driver.closeDriver();
    }

    @Test // Calisti
    public void TC_11() {
        //When the course name in the list is clicked, it should redirect to the edit page of the relevant course.
        // (Listedeki ders adına tıklandığında ilgili dersin düzenleme sayfasına yönlendirilmelidir.)

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

        //-Listedeki ders adı tıklanır
        emrahUSPage.emrahDeneme4Dersi.click();

        //- Açılan sayfa başlığında "Edit course" yazısı kontrol edilir
        ReusableMethod.bekle(3);
        String expectedAcilanSayfadakiBaslik="Update: Emrah deneme 4";
        String actualSayfaBasligi = emrahUSPage.updateEmrahDeneme4Yazisi.getText();

        Assert.assertTrue(actualSayfaBasligi.contains(expectedAcilanSayfadakiBaslik));

        Driver.closeDriver();
    }


}




