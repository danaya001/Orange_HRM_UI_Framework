package ui_automation.step_definitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ui_automation.pages.DashboardPage;
import ui_automation.pages.RecruitmentPage;
import ui_automation.utilities.Driver;
import ui_automation.utilities.ExcelUtility;
import ui_automation.utilities.GenericHelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class RecruitmentPageSteps {
    WebDriver driver = Driver.getInstance().getDriver();
    RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    Actions actions = new Actions(driver);
    private static final Logger oLog = LogManager.getLogger(GenericHelper.class);

    @Given("user clicks {string} on the Dashboard Menu on HRM page")
    public void user_clicks_on_the_Dashboard_Menu_on_HRM_page(String dashboardMenu)  {
        dashboardPage.clickDashboardMenu(dashboardMenu);
        oLog.info("User clicks on Recruitment on the dashboard menu on Orange HRM");
    }

    @Then("user click on AddButton on Recruitment Page")
    public void user_click_on_AddButton_on_Recruitment_Page()  {
        recruitmentPage.clickOnAddButton();

    }

    @Then("user fill out the first name {string}, middle name {string} and last Name {string}")
    public void user_fill_out_the_first_name_middle_name_and_last_Name(String firstName, String middleName, String lastName) throws Exception {
        // works from feature.file and Exel

        Thread.sleep(2000);
        /* establishing the connection to the excel file */
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\orangeHRMtestData.xlsx";
        ExcelUtility.setExcelFile(filePath, "Sheet1");
        /* retrieving data from excel file */
        firstName = ExcelUtility.getCellDataAsString(1, 1);
        middleName = ExcelUtility.getCellDataAsString(1, 2);
        lastName = ExcelUtility.getCellDataAsString(1, 3);
        System.out.println(firstName + " " + lastName);
        recruitmentPage.firstNameBoxText.sendKeys(firstName);
        recruitmentPage.middleNameBoxText.sendKeys(middleName);
        recruitmentPage.lastNameBoxText.sendKeys(lastName);
    }

    @Then("user should be able to choose Vacancy dropdown {string}")
    public void user_should_be_able_to_choose_Vacancy_dropdown(String vacancyDropdownOption) {
        recruitmentPage.vacancyDropdwonClick(vacancyDropdownOption);
    }

    @Then("user should be able to add gmail {string} and contact number {string}")
    public void user_should_be_able_to_add_gmail_and_contact_number(String email, String contactNumber) {
        recruitmentPage.emailBox.sendKeys(email);
        recruitmentPage.contactNumberBox.sendKeys(contactNumber);

        oLog.info("User adds email: " + email + " and contact number: " + contactNumber);

    }

    @Then("user should be able to upload resume")
    public void user_should_be_able_to_upload_resume() throws InterruptedException {
        String homeDirectory = System.getProperty("user.dir");
        Thread.sleep(10000);
        String filePath = homeDirectory + "\\src\\test\\resources\\testData\\Resume sample.docx";
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", recruitmentPage.browseButton2);
        recruitmentPage.browseButton2.sendKeys(filePath);
        oLog.info("User uploads a resume");
    }
    @Then("user should be able to write keywords {string}, date of application yyyy-mm-dd {string} and notes {string}")
    public void user_should_be_able_to_write_keywords_date_of_application_yyyy_mm_dd_and_notes(String keywords, String date, String notes) throws InterruptedException {
        Thread.sleep(3000);
        recruitmentPage.keywordsBox.sendKeys(keywords);
        Thread.sleep(3000);
        recruitmentPage.dateOfApplicationBox.click();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.DELETE).perform();
        recruitmentPage.dateOfApplicationBox.sendKeys(date);
        Thread.sleep(3000);
        recruitmentPage.notesBox.sendKeys(notes);
        oLog.info("User writes keywords: " + keywords + ", date of application: " + date + ", and notes: " + notes);

    }

    @Then("user checks the consent to keep data and click on save button")
    public void user_checks_the_consent_to_keep_data_and_click_on_save_button() throws InterruptedException {
        recruitmentPage.checkBox.click();
        Thread.sleep(3000);
        recruitmentPage.saveButton.click();
        Thread.sleep(3000);
        oLog.info("User checks the consent to keep data and clicks on the save button");

    }

    @Then("user verifies that the name is listed after saved")
    public void user_verifies_that_the_name_is_listed_after_saved() {
        String expectedAccountName = "Dani Romo";
        String actualAccountName = driver.findElement(By.xpath("(//div[@class='']/p)[1]")).getText();
        assertEquals(expectedAccountName, actualAccountName, "New Account Verification Failed");
        oLog.info("Verifying that the name is listed after saved");

    }

    @Then("user verifies that the details for the added user {string} or candidate match the data provided")
    public void user_verifies_that_the_details_for_the_added_user_or_candidate_match_the_data_provided(String fullName) {
        boolean isNamePresent = driver.findElement(By.xpath("//div[text()='"+fullName+"']")).isDisplayed();
        String expectdFullName = "Dani Romo";
        String actualFullName = driver.findElement(By.xpath("//div[text()='"+fullName+"']")).getText();
        assertEquals(expectdFullName, actualFullName, "Name verification failed!");
        oLog.info("Verifying that the details for the added user or candidate match the data provided");

    }
}
