package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PrincipalPage;
import pages.InsightsPage;
import pages.BlogPage;
import pages.ContactPage;
import pages.ThankYouPage;

public class BlankFactorSteps {

    PrincipalPage principalPage = new PrincipalPage();
    InsightsPage insightsPage = new InsightsPage();
    BlogPage blogPage = new BlogPage();
    ContactPage contactPage = new ContactPage();
    ThankYouPage thankYouPage = new ThankYouPage();

    @Given("the user navigates to {string}")
    public void the_user_opens_the_browser(String url) {
        principalPage.navigateToBlankFactorPage(url);
    }

    @When("the user accepts the website policy")
    public void acceptWebsitePolicy() {
        principalPage.acceptOurPolicy();
    }

    @Then("the website should be accessible without further prompts")
    public void verifyNoMorePolicyPrompt() {
        principalPage.policyBannerIsNotVisible();
    }

    @Given("the user navigates to the insights page")
    public void userNavigatesToBlogPage() {
        insightsPage.clickOnInsightsMenu();
        insightsPage.verifyInsightsPageURL();
    }

    @And("click on the Blog section")
    public void userNavigatesToBlogSection() {
        insightsPage.verifyBlogPage();
    }

    @And("Scroll until the article {string} is visible")
    public void scrollUntilSpecificTextAppears(String article) {
        blogPage.scrollUntilActicleIsVisible(article);
    }

    @When("the article is found and user access the {string} post")
    public void articleIsFoundUserAccessIt(String author) {
        blogPage.clickOnArticleFound();
        blogPage.clickOnTheAuthorWhoPostedTheArticle(author);
    }

    @Then("The user can see Sofia Gonzales Page")
    public void verifyURLPage() {
        blogPage.verifyPage();
    }

    @Given("the user go to the Become a Client form")
    public void userGoToTheBecomeAClientForm() {
        contactPage.clickOnBecomeClient();
    }

    @When("the user enters {string} in the first name field")
    public void userEntersFirtNameInField(String firstName) {
        contactPage.enterFirtsName(firstName);
    }

    @And("the user enters {string} in the last name field")
    public void userEntersLastNameInField(String lastName) {
        contactPage.enterLastName(lastName);
    }

    @And("the user enters {string} in the company field")
    public void userEntersCompanyInField(String company) {
        contactPage.enterCompany(company);
    }

    @And("the user enters {string} in the email field")
    public void userEntersEmailInField(String email) {
        contactPage.enterEmail(email);
    }

    @And("the the user enters {string} in the phone field")
    public void userEntersPhoneInField(String phone) {
        contactPage.enterPhone(phone);
    }

    @And("the user enters {string} in the project field")
    public void userEntersProjectInField(String project) {
        contactPage.enterProject(project);
    }

    @And("the user check the Privacy Policy")
    public void checkPrivacyPolicy() {
        contactPage.checkPrivacyPolicy();
    }

    @And("the user clicks Get Started button")
    public void clickOnGetStartedToEnterTheRecord() {
        contactPage.clickOnGetStarted();

    }

    @Then("user gets registration success message")
    public void userGetsRegistrationSuccess() {
        thankYouPage.dataRecordingsSuccessfully();
    }

    @When("User scrolls the blog page and captures all the posts on the page")
    public void printAllPostsOnTheBlogPage() {
        blogPage.scrollAndCapturePost();
    }

}
