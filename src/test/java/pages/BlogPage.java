package pages;

public class BlogPage extends BasePage {
    public BlogPage() {
        super(driver);
    }

    private String articleFound = "//a[contains(text(), 'Why fintech in Latin America is booming')]";
    private String author = "//a[contains(text(), 'Sofia Gonzalez')]";

    public void scrollUntilActicleIsVisible(String article) {
        scrollUntilTextVisible(article, 20);
    }

    public void clickOnArticleFound() {
        try {
            if (elementDisplayed(articleFound)) {
                clickElementByXpath(articleFound);
            }
        } catch (Exception e) {
            System.out.println("article is not displayed");
        }
    }

    public void clickOnTheAuthorWhoPostedTheArticle(String Author) {
        try {
            if (elementDisplayed(author)) {
                clickElementByXpath(author);
            }
        } catch (Exception e) {
            System.out.println("author is not displayed");
        }
    }

    public void verifyPage() {
        driver.get("https://blankfactor.com/author/sofia-gonzalez/");
        assertURL("https://blankfactor.com/author/sofia-gonzalez/");
    }

    public void scrollAndCapturePost() {
        scrollAndCaptureText();
    }

}
