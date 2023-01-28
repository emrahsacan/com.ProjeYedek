package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EmrahUSPage {

    public EmrahUSPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(id="login-email")
    public WebElement kullaniciEmailKutusu;

    @FindBy(id="login-password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//*[@onclick='cookieAccept();']")
    public WebElement cookieButtonAccept;

    @FindBy(xpath = "//*[text()='User profile']")
    public WebElement userProfileLinki;

    @FindBy(xpath = "//*[@class='user-box menu-icon-box']")
    public WebElement userIconDropdown;

    @FindBy(xpath = "//*[text()=' Photo']")
    public WebElement userPhotoButonu;

    @FindBy(xpath="//*[@id=\"user_image\"]")
    public WebElement dosyaSecLinki;

    @FindBy(xpath="//*[text()=' Upload']")
    public WebElement uploadButonu;


    @FindBy(xpath = "//div[@class='icon']")
    public WebElement instructorLink;

    @FindBy(xpath = "(//*[@class='card-body text-center'])[1]")
    public WebElement numberOfCoursesLinki;

    @FindBy(xpath = "(//*[@class='card-body text-center'])[3]")
    public WebElement pendingBalanceLinki;

    @FindBy(xpath = "(//*[@class='card-body text-center'])[4]")
    public WebElement requestedWithdrawalAmountLinki;


    @FindBy(className = "page-title")
    public WebElement coursesYazisi;


    @FindBy(className = "page-title")
    public WebElement payoutReportYazisi;


    @FindBy(linkText = "Course manager")
    public WebElement courseManagerLinki;

    @FindBy(xpath = "//*[@id='category_id']")
    public WebElement categoriesDropdownLinki;

    @FindBy(id= "status")
    public WebElement statusDropdownLinki;

    @FindBy(id= "price")
    public WebElement priceDropdownLinki;

    @FindBy(xpath = "//*[text()='Filter']")
    public WebElement filterLinki;

    @FindBy(xpath = "(//*[text()='Web Design for Web Developers'])[3]")
    public WebElement categoriesYazisi;


    @FindBy(xpath = "//*[@class='form-control form-control-sm']")
    public WebElement dersAramaKutusu;

    @FindBy(xpath = "//*[text()='Emrah deneme 1']")
    public WebElement aramaSonucuDersinIsmi;

    @FindBy(xpath = "(//*[@class='mdi mdi-dots-vertical'])[1]")
    public WebElement ED2actionsDropdownLinki;

    @FindBy(xpath = "(//*[text()='View course on frontend'])[1]")
    public WebElement viewCourseOnFrontendButonu;

    @FindBy(xpath = "(//*[@class='title'])[1]")
    public WebElement yeniSekmeninTitleYazisi;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[2]")
    public WebElement goToCoursePlayingPageLinki;

    @FindBy( xpath = "//*[text()='Course content']")
    public WebElement YSekmeCourseContentYazisi;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[3]")
    public WebElement editThisCourseLinki;

    @FindBy( xpath = "(//*[text()='Section and lesson'])[1]")
    public WebElement sectionAndLessonLinki;


    @FindBy( xpath = "(//*[text()='Mark as drafted'])[1]")
    public WebElement markAsDraftedLinki;

    @FindBy( xpath = "(//*[text()='Continue'])[1]")
    public WebElement continueButonu;

    @FindBy( xpath = "//*[text()='Draft']")
    public WebElement draftYazisi;


    @FindBy( xpath = "(//*[text()='Active'])[2]")
    public WebElement activeYazisi;

    @FindBy( xpath = "//*[text()='Publish this course']")
    public WebElement publishThisCourseLinki;


    @FindBy(xpath = "(//*[@class='mdi mdi-dots-vertical'])[1]")
    public WebElement silinecekDersinActionsButonu;


    @FindBy(xpath = "(//*[text()='Delete'])[9]")
    public WebElement deleteLinki;


    @FindBy( xpath = "//*[text()='Silinecek test dersi']")
    public WebElement silinecekTestDersiIsmi;


    @FindBy( xpath = "//*[text()='Add new course']")
    public WebElement addNewCourseLinki;

    @FindBy( xpath = "//*[text()='Emrah deneme 4']")
    public WebElement emrahDeneme4Dersi;



    @FindBy( xpath = "//*[text()=' Update: Emrah deneme 4']")
    public WebElement updateEmrahDeneme4Yazisi;



























    @FindBy( xpath = "//title[text()='Edit course | Quality Demy']")
    public WebElement editCourseTitle;

































    @FindBy(xpath = "(//*[@class='d-none d-sm-inline'])[8]")
    public WebElement finishLinki;

    @FindBy(xpath = "//*[@class='btn btn-primary text-center']")
    public WebElement submitButonu;

    @FindBy(xpath = "//*[@class='jq-toast-heading']")
    public WebElement congratulationsYazisi;







}
