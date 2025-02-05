package pages;

public class InsightsPage extends BasePage {

    public InsightsPage() {
        super(driver);
    }

    private String insightsMenu = ".menu-item-4436";
    private String blogSection = "//a[contains(text(), 'Blog')]";

    public void clickOnInsightsMenu() {
        clickElement(insightsMenu);
    }

    public void verifyInsightsPageURL() {
        driver.get("https://blankfactor.com/insights/");
        assertURL("https://blankfactor.com/insights/");
    }

    public void verifyBlogPage() {
        clickElementByXpath(blogSection);
        driver.get("https://blankfactor.com/insights/blog/");
        assertURL("https://blankfactor.com/insights/blog/");
    }

}
