package ui_automation.pages;
import gherkin.ast.ScenarioOutline;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Dashboard']")
    public WebElement dashboardText;

    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li")
    public List<WebElement> dashboardMenu;

    public void verifyDashboardText (String expecteDashboardText) {
        String actualUsernameHeader = dashboardText.getText();
        Assert.assertEquals("Username header verification failed!",
                expecteDashboardText, actualUsernameHeader);
    }

    public void clickDashboardMenu(String dashboardOption){

        switch (dashboardOption) {
            case "Admin":
                dashboardMenu.get(0).click();
                break;
            case "PIM":
                dashboardMenu.get(1).click();
                break;
            case "Leave":
                dashboardMenu.get(2).click();
                break;
            case "Time":
                dashboardMenu.get(3).click();
                break;
            case "Recruitment":
                dashboardMenu.get(4).click();
                break;
            case "My Info":
                dashboardMenu.get(5).click();
                break;
            case "Performance":
                dashboardMenu.get(6).click();
                break;
            case "Dashboard":
                dashboardMenu.get(7).click();
                break;
            case "Directory":
                dashboardMenu.get(8).click();
                break;
            case "Maintenance":
                dashboardMenu.get(9).click();
                break;
            case "Claim":
                dashboardMenu.get(10).click();
                break;
            case "Buzz":
                dashboardMenu.get(11).click();
                break;
            default:
                System.out.println("Dashboard Menu option not found");
        }

    }

    public void deleteAccount(String firstName, String middleName, String lastName ) throws InterruptedException {
        boolean isTheAccountExisiting = driver.findElement(By.xpath("//div[text()='"+ firstName + " "+ middleName+ " " + lastName +"']")).isDisplayed();
        if (isTheAccountExisiting){
            driver.findElement(By.xpath("//div[text()='"+firstName + " "+ middleName+ " " + lastName +"']/../..//i[@class='oxd-icon bi-trash']")).click();
            driver.findElement(By.xpath("(//div[@class='orangehrm-modal-footer']//button)[2]")).click();
            Thread.sleep(5000);
        }}
}
