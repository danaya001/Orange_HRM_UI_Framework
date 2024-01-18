package ui_automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RecruitmentPage {
    WebDriver driver;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    public WebElement addButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameBoxText;

    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleNameBoxText;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameBoxText;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    public WebElement vacancyDropdownBox;

    @FindBy(xpath = "(//div[@class='']/input)[4]")
    public WebElement emailBox;

    @FindBy(xpath = "(//div[@class='']/input)[5]")
    public WebElement contactNumberBox;

    @FindBy(xpath = "//div[@class='oxd-file-button']")
    public WebElement browseButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement browseButton2;

    @FindBy(xpath = "//div[@class='oxd-file-input-div']")
    public WebElement uploadButton;

    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    public WebElement keywordsBox;

    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    public WebElement dateOfApplicationBox;

    @FindBy(xpath = "//textarea[@placeholder='Type here']")
    public WebElement notesBox;

    @FindBy(xpath = "//input[@type='checkbox']/..")
    public WebElement checkBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//p[text()='Daniela  Romo']")
    public WebElement nameVerification;

    public void clickOnAddButton(){
        addButton.click();
    }

    //p[text()='Daniela  Romo']

    public void vacancyDropdwonClick(String dropdwonOption){
        vacancyDropdownBox.click();
        vacancyDropdownBox.sendKeys(dropdwonOption);
    }
}
