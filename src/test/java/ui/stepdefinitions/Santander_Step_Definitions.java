package ui.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import ui.pages.SantanderPage;
import ui.utulities.ConfigReader;
import ui.utulities.Driver;

public class Santander_Step_Definitions {
    Logger log = (Logger) LogManager.getLogger(Santander_Step_Definitions.class);
    SantanderPage santanderPage=new SantanderPage();

    @Given("Go to the {string}")
    public void go_to_the(String page_url) {
        Driver.getDriver().get(ConfigReader.getProperty(page_url));
        log.info("It has gone to " +ConfigReader.getProperty(page_url));
    }
    @Then("Verify true page")
    public void verify_true_page() {
        Driver.getDriver().getTitle();
            String expected_Title="Santander Bank";
            String actual_Title=Driver.getDriver().getTitle();

            Assert.assertTrue(actual_Title.contains(expected_Title));
        log.info("Page Title is true");
    }

    @Then("Click to Banking tab")
    public void click_to_banking_tab() {
        santanderPage.bankingTab.click();
        log.info("Banking tab is clicked");
    }
    @Then("Select to Santander Select Checking tab")
    public void select_to_santander_select_checking_tab() {
        santanderPage.santander_Select_Checking_Tab.click();
        log.info("Santander Select Checking tab is clicked");
    }

    @When("Click to About Us")
    public void click_to_about_us() {
        santanderPage.about_Us_Tap.click();
        log.info("About Us is clicked");
    }

    @Then("Click to Account set-up")
    public void click_to_account_set_up() {
        santanderPage.account_Setup_Tap.click();
        log.info("Account Setup is clicked");
    }


    @Given("Click to Santander Private Client")
    public void click_to_santander_private_client() {
        santanderPage.santander_Private_Client_Tab.click();
        log.info("Santander Private Client is clicked");


    }
    @Then("Go to bottom of the page to see unreadable symbols")
    public void go_to_bottom_of_the_page() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //  js.executeScript("window.scrollBy(0,5000)", ""); //Scroll vertically down by 5000 pixels
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,-500)", "");
        log.info("It has gone to bottom of the page");

        System.out.println("========================Unreadable Symbols For This Page Are Listed Below===============");
            for (WebElement each: santanderPage.unreadable_Symbols_List())
            {
            System.out.println(each.getText());
            }
        log.info("Bug Report-1 is verified. Unreadable Symbols Displayed on the Page");
    }

    @Then("Click to Small Business")
    public void click_to_small_business() {

        santanderPage.small_Business_Tab.click();
        log.info("Small Business is clicked");
    }
    @When("Click to Santander Safety Net")
    public void click_to_santander_safety_net() {

        santanderPage.safety_Net_Tap.click();
        log.info("Santander Safety Net is clicked");

    }
    @When("Page scroll down to Overdraft fee details to see Invisible Images")
    public void scrool_down_the_page_to_overdarft_fee_details() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,2000)", ""); //Scroll vertically down by 5000 pixels to Over_Draft Fee
        log.info("It has gone to Overdraft fee details");

        log.info("Bug Report-3 is verified. Invisible images Displayed on the Page");
    }

    @Then("Go to bottom of the page")
    public void goToBottomOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");  //Scroll vertically down to bottom;
        log.info("It went to the bottom of the page.");
    }

    @And("Verify Meaningless Sentences")
    public void verifyMeaninglessSentences() {
        System.out.println("========================Meaningless Sentences For This Page Are Listed Below===============");

        for (WebElement each: santanderPage.meaningless_Sentences()) {
            System.out.println(each.getText());
            Assert.assertTrue(each.isDisplayed());
            }
        log.info("Bug Report-2 is verified. Meaningless Sentences Displayed on the Page");

    }

    /////////////////////////// SCENARIO 2 FILL THE BUS LEAD FORM ========================

    @Given("Move To Borrowing Tap")
    public void move_to_borrowing_tap() {
        Actions action=new Actions(Driver.getDriver());
        action.moveToElement(santanderPage.borrowing_Tab).perform();

        log.info("It has gone to Borrowing Tap");
    }
    @Then("Move Borrowing Option")
    public void move_borrowing_option() {
        Actions action=new Actions(Driver.getDriver());

        action.moveToElement(santanderPage.borrowingOptions).perform();
        log.info("It has gone to Borrowing Option");
    }
    @Then("Click to Business Term Loan")
    public void click_to_business_term_loan() {

        santanderPage.business_Term_Loan.click();

        log.info("Business Term Loan was clicked");
    }
    @Then("Click to Get in Touch")
    public void click_to_get_in_touch() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,500)", "");
        santanderPage.get_in_Touch_Button.click();

        log.info("Get in Touch was clicked");
    }
    @Then("Fill the Firstname {string}")
    public void fill_the_firstname(String name) throws InterruptedException {

        Faker fake=new Faker();
        Actions action=new Actions(Driver.getDriver());

        action.sendKeys(santanderPage.fistName_Box,name).sendKeys(Keys.TAB)
                .sendKeys(fake.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(fake.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(fake.job().title()).sendKeys(Keys.TAB)
                .sendKeys(fake.job().position()).sendKeys(Keys.TAB)
                .sendKeys(fake.phoneNumber().phoneNumber())
                .perform();
        santanderPage.zipcode_box.sendKeys("10005",Keys.ENTER);

        log.info(name +" name is added and the other box were filled");

        Select select=new Select(santanderPage.Industry_Select_Tab);
        select.selectByVisibleText("Franchise");

        log.info(" Franchise were selected");

        santanderPage.submit_Button.click();

        log.info("Submit Button was clicked");
        Thread.sleep(5000);
        Assert.assertTrue(santanderPage.Thankyou_text.isDisplayed());

        log.info(santanderPage.Thankyou_text.getText() + " text is seen.");

    }
}
