package tests.QA_Emrah;



import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmrahUSPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class US_17 {


  @Test //Calisti
  public void TC_01(){
      //When selecting a file, the computer folder should be opened.
      // (Bir dosya seçerken, bilgisayar klasörü açılmalıdır.)

      //- qa.qualtydemy sayfasına gidilir
      Driver.getDriver().get(ConfigReader.getProperty("emrahQDUrl"));
      //- Login butonuna basılır
      EmrahUSPage emrahUSPage = new EmrahUSPage();
      emrahUSPage.ilkLoginLinki.click();
      //- e mail ve password girilerek kullanıcı girişi
      // yapılır
      emrahUSPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("emrahEmail"));
      emrahUSPage.passwordKutusu.sendKeys(ConfigReader.getProperty("emrahPassword"));
      ReusableMethod.bekle(2);
      // -cookie accept butonuna basılır
      emrahUSPage.cookieButtonAccept.click();
      ReusableMethod.bekle(1);
      //- Login butonuna basılır
      emrahUSPage.loginButonu.click();

      //- giris yapildiktan sonra sağ üst köşede çıkan Welcome yazisinin
      // kaybolması beklenir
      ReusableMethod.bekle(6);

      //- Sağ köşede bulunan kullanıcı ikonuna tıklanır
      emrahUSPage.userIconDropdown.click();

      //- menüde çıkan user profil butonu tıklanır
      emrahUSPage.userProfileLinki.click();

      //- açılan sayfada photo butonu tıklanır
      emrahUSPage.userPhotoButonu.click();

      //- dosya seç butonu aktif olduğu kontrol edilir
      Assert.assertTrue(emrahUSPage.dosyaSecLinki.isEnabled());

     // Dosya Seç kısmına foto dosyası gönderilir
      emrahUSPage.dosyaSecLinki.sendKeys("C:\\Users\\emrah\\IntelliJ Projeler\\com.QualitydemyProject\\src\\test\\java\\tests\\QA_Emrah\\Team9.jpeg");

      //- Gönderdiğimiz dosyanın ismi görülmesi icin Ekran Görüntüsü alinir
      ReusableMethod.bekle(2);

      ReusableMethod.tumSayfaScreenshotCek(Driver.getDriver());

      ReusableMethod.bekle(3);

      Driver.closeDriver();

  }

    @Test //Calisti
    public void TC_02() {
        // When the upload button is pressed after the selected picture file, the profile picture should be uploaded.
        // (Seçilen resim dosyasından sonra yükle butonuna basıldığında profil resminin yüklenmesi gerekmektedir.

        //- qa.qualtydemy sayfasına gidilir
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
        // - Login butonuna basılır
        emrahUSPage.loginButonu.click();

        //- giris yapildiktan sonra sağ üst köşede çıkan Welcome yazisinin
        // kaybolması beklenir
        ReusableMethod.bekle(6);

        //- Sağ köşede bulunan kullanıcı ikonuna tıklanır
        emrahUSPage.userIconDropdown.click();

        //- menüde çıkan user profil butonu tıklanır
        emrahUSPage.userProfileLinki.click();

        //- açılan sayfada photo butonu tıklanır
        emrahUSPage.userPhotoButonu.click();

        //- dosya seç butonu aktif olduğu kontrol edilir
        Assert.assertTrue(emrahUSPage.dosyaSecLinki.isEnabled());

        //- dosya seç butonuna dosya gönderilir
        emrahUSPage.dosyaSecLinki.sendKeys("C:\\Users\\emrah\\IntelliJ Projeler\\com.QualitydemyProject\\src\\test\\java\\tests\\QA_Emrah\\Team9.jpeg");

        // Dosyanın yazidiginin kontrolü için ekran fotosu alınır

        ReusableMethod.bekle(1);

        ReusableMethod.tumSayfaScreenshotCek(Driver.getDriver());

        //- Upload clicklenir
        emrahUSPage.uploadButonu.click();

        //- Sağ ust kosede "Updated successfully" yazısının ve foto yüklenmiş oldugunun anlaşılması için ekran fotosu alinir

        ReusableMethod.bekle(1);

        ReusableMethod.tumSayfaScreenshotCek(Driver.getDriver());

        ReusableMethod.bekle(3);

        Driver.closeDriver();
    }

    @Test //Calisti
    public void TC_03(){
        //It should give a warning when something other than image format is selected.
        // (Görüntü formatı dışında bir şey seçildiğinde bir uyarı vermelidir.)


        //- qa.qualtydemy sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("emrahQDUrl"));
        //- Login butonuna basılır
        EmrahUSPage emrahUSPage = new EmrahUSPage();
        emrahUSPage.ilkLoginLinki.click();
        //- e mail ve password girilerek kullanıcı girişi
        // yapılır
        emrahUSPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("emrahEmail"));
        emrahUSPage.passwordKutusu.sendKeys(ConfigReader.getProperty("emrahPassword"));
        ReusableMethod.bekle(2);
        // -cookie accept butonuna basılır
        emrahUSPage.cookieButtonAccept.click();
        ReusableMethod.bekle(1);
        //- Sağ köşede bulunan kullanıcı ikonuna tıklanır
        emrahUSPage.loginButonu.click();

        //- giris yapildiktan sonra sağ üst köşede çıkan Welcome yazisinin
        // kaybolması beklenir
        ReusableMethod.bekle(6);

        //- Sağ köşede bulunan kullanıcı ikonuna tıklanır
        emrahUSPage.userIconDropdown.click();

        //- menüde çıkan user profil butonu tıklanır
        emrahUSPage.userProfileLinki.click();

        //- açılan sayfada photo butonu tıklanır
        emrahUSPage.userPhotoButonu.click();

        //- dosya seç butonu aktif olduğu kontrol edilir
        Assert.assertTrue(emrahUSPage.dosyaSecLinki.isEnabled());

        //- dosya seç butonuna foto formatı dışında başka bir dosya(txt) gönderilir

        emrahUSPage.dosyaSecLinki.sendKeys("C:\\Users\\emrah\\IntelliJ Projeler\\com.QualitydemyProject\\src\\test\\java\\tests\\QA_Emrah\\US17Test03TestiIcinSilmeyin.txt");

        // Dosyanın yazidiginin kontrolü için ekran fotosu alınır

        ReusableMethod.bekle(1);

        ReusableMethod.tumSayfaScreenshotCek(Driver.getDriver());


        //- Upload butonuna tıklanır
        emrahUSPage.uploadButonu.click();

        //- Sağ ust kosede kırmızı renkte "Please select only jpg/png file." uyarısıyla yazı dosyasinin yüklenemediği
        // anlaşılması için ekran fotosu alinir

        ReusableMethod.bekle(1);

        ReusableMethod.tumSayfaScreenshotCek(Driver.getDriver());

        ReusableMethod.bekle(3);

        Driver.closeDriver();

    }

}
