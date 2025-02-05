package pages;

import org.junit.Assert;

public class ThankYouPage extends BasePage {
    public ThankYouPage() {
        super(driver);
    }

    private String successMessage = "//h1[contains(text(), ' Thank you for your submission')]";
    private String contactMessage = "//h2[contains(text(), ' We’ll be in contact within 24 business hours.')]";

    public void dataRecordingsSuccessfully() {
        Assert.assertTrue("Success message is not displayed", elementDisplayedXpath(successMessage));
        Assert.assertTrue("Contact message is not displayed", elementDisplayedXpath(contactMessage));

    }

}
