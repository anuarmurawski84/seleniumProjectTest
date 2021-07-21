package pages.telecommunications;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class MobilePhoneReplenishmentPage extends BasePage {
    public MobilePhoneReplenishmentPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonWallet = By.xpath("//div[contains(text(), 'My wallet')]");
    private final By inputPhoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    private final By inputAmount = By.xpath("//input[@data-qa-node='amount']");
    private final By inputCardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
    private final By inputCardExpDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    private final By inputCardCvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    private final By buttonSubmitToTheCard = By.xpath("//button[@data-qa-node='submit']");
    private final By inputFirstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    /**
     * Choose a card from the wallet
     */
    public MobilePhoneReplenishmentPage selectCardFromWallet() {
        driver.findElement(buttonWallet).click();
        return this;
    }
    /**
     * Enter phone number excluding country code
     * @param number phone number
     */
    public MobilePhoneReplenishmentPage enterPhoneNumber(String number) {
        driver.findElement(inputPhoneNumber).sendKeys(number);
        return this;
    }
    public MobilePhoneReplenishmentPage enterAmount(String amount) {
        driver.findElement(inputAmount).sendKeys(amount);
        return this;
    }
    public MobilePhoneReplenishmentPage enterCardFrom (String card){
        driver.findElement(inputCardFrom).sendKeys(card);
        return this;
    }
    public MobilePhoneReplenishmentPage enterCardExpDate(String expDate){
        driver.findElement(inputCardExpDate).sendKeys(expDate);
        return this;
    }
    public MobilePhoneReplenishmentPage enterCvv(String cvv){
        driver.findElement(inputCardCvv).sendKeys(cvv);
        return this;
    }
    public MobilePhoneReplenishmentPage submitToTheCard(){
        driver.findElement(buttonSubmitToTheCard).click();
        return this;
    }
    public MobilePhoneReplenishmentPage checkPaymentDetailsIsPresentInTheCard(String text){
        WebElement firstName = driver.findElement(inputFirstName);
        waitElementIsVisible(firstName);
        Assertions.assertEquals(text, firstName.getAttribute("placeholder"));
        return this;
    }
}