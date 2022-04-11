package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utulities.Driver;

import java.util.ArrayList;
import java.util.List;

public class SantanderPage {
    public SantanderPage() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (xpath = "//a[@class='level-2-collapsed']")
    public WebElement bankingTab;

    @FindBy (linkText = "Santander Select Checking")
    public WebElement santander_Select_Checking_Tab;

    @FindBy (linkText = "About Us")
    public WebElement about_Us_Tap;

    @FindBy (id = "p-footer-account-set-up")
    public WebElement account_Setup_Tap;

    @FindBy (xpath = "//img[@alt='Santander Private Client']")
    public  WebElement santander_Private_Client_Tab;

    @FindBy (linkText = "Small Business")
    public WebElement small_Business_Tab;

    @FindBy (xpath = "//img[@alt='Billboard image']")
    public  WebElement safety_Net_Tap;

    @FindBy (xpath = "//*[(text()='Borrowing')]")
    public WebElement borrowing_Tab;

    @FindBy (xpath = "//*[(text()='Borrowing Options')]")
    public WebElement borrowingOptions;

    @FindBy (linkText = "Business Term Loan")
    public WebElement business_Term_Loan;

    @FindBy (linkText = "Get in touch")
    public WebElement get_in_Touch_Button;

    @FindBy (id = "businessContactFormFirstName")
    public  WebElement fistName_Box;

    @FindBy (id = "businessContactBusinessZipCode")
    public WebElement zipcode_box;

    @FindBy (id = "businessContactIndustry")
    public WebElement Industry_Select_Tab;

    @FindBy (id="submitBusinessContactForm")
    public  WebElement submit_Button;

    @FindBy (xpath = "(//h2)[4]")
    public WebElement Thankyou_text;

    public List<WebElement> unreadable_Symbols_List() {
       List<WebElement>unreaddable_Icons_List=new ArrayList<>();
        unreaddable_Icons_List=Driver.getDriver().findElements(By.xpath("//sup"));
        return unreaddable_Icons_List;
   }

   public List<WebElement> meaningless_Sentences () {
        List<WebElement> footer_sentences=Driver.getDriver().findElements(By.xpath("//*[.=' HTML Example ']"));  //Bug Report2 Footer Sentencess
        return footer_sentences;
   }
}
