# com.QualitydemyProject TestNG
## 1. Yazım Esaslari
### A- Locate Yazim Bicimi
Locate alınırken locate'in üzerine butonun yolu yazılır
Gerekiyorsa 'Sağ üstte' gibi ifadeler de eklenebilir
````Java
//mainPage/Sign Up/Login Butonu
@FindBy(xpath = "//div[@class='icon']")
    public WebElement loginButonu;
````
### B- Package ve Class isimlendirmesi
Package= qa_Semih  
Class  = US_01

### C- TestCase Yazımı

````Java
@Test
public void TC_01(){
    
        }
````
### D- ReusableMethods isimlendirmesi
mothodun üzrine methodun ne işe yaradığı kısaca açıklanır
````Java
//========Switching Window=====//
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
````
### E- Properties isimlendirmesi
isimlendirme Qa'in ismiyle baslar  
semihQaulitydemyUserName="semih@gmail.com"  
semihQualitydemyPassword="1234"  
semihQaulitydemyCoursepageUrl="https://..."

## 2- Github
### A- Git Ignore Sayfası
a. proje ismine sağ tıklanıp > file   
b. file'a git.ignore ismi verilir  
c. idea ve target dosyalarının github'a gönderilmesinin ignore edilmesi için  
aşağıdaki gibi yazılır:
````Java
/.idea  
/target
````


